package com.payir.controllers

import com.payir.services.AuthService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

data class RegisterRequest(
    val username: String,
    val password: String,
    val email: String? = null,
    val phone: String? = null
)

data class LoginRequest(
    val username: String,
    val password: String
)

fun Route.adminRoutes() {
    route("/admin") {

        // Admin Register
        post("/register") {
            val req = call.receive<RegisterRequest>()
            try {
                AuthService.register(
                    username = req.username,
                    password = req.password,
                    role = "ADMIN",
                    email = req.email,
                    phone = req.phone
                )
                call.respond(mapOf("success" to true, "message" to "Admin registered successfully"))
            } catch (e: Exception) {
                call.respond(mapOf("success" to false, "error" to e.message))
            }
        }

        // Admin Login
        post("/login") {
            val req = call.receive<LoginRequest>()
            val success = AuthService.login(req.username, req.password)
            if (success)
                call.respond(mapOf("success" to true, "message" to "Login successful"))
            else
                call.respond(mapOf("success" to false, "error" to "Invalid username or password"))
        }
    }
}
