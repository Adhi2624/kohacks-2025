package com.payir.controllers

import com.payir.services.AuthService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// Request data classes
data class AgriRegisterRequest(
    val username: String,
    val password: String,
    val email: String? = null,
    val phone: String? = null
)

data class AgriLoginRequest(
    val username: String,
    val password: String
)

fun Route.agriDeptRoutes() {

    route("/agri") {

        // Register AgriDept personnel
        post("/register") {
            val req = call.receive<AgriRegisterRequest>()
            try {
                AuthService.register(
                    username = req.username,
                    password = req.password,
                    role = "AGRI_DEPT",
                    email = req.email,
                    phone = req.phone
                )
                call.respond(mapOf("success" to true, "message" to "AgriDept personnel registered successfully"))
            } catch (e: Exception) {
                call.respond(mapOf("success" to false, "error" to e.message))
            }
        }

        // Login AgriDept personnel
        post("/login") {
            val req = call.receive<AgriLoginRequest>()
            val success = AuthService.login(req.username, req.password)
            if (success)
                call.respond(mapOf("success" to true, "message" to "Login successful"))
            else
                call.respond(mapOf("success" to false, "error" to "Invalid username or password"))
        }

        // Optional: Fetch profile
        get("/profile/{username}") {
            val username = call.parameters["username"]
            if (username == null) {
                call.respond(mapOf("success" to false, "error" to "Username is required"))
                return@get
            }

            val user = AuthService.getUserByUsername(username)
            if (user != null)
                call.respond(mapOf("success" to true, "data" to user))
            else
                call.respond(mapOf("success" to false, "error" to "User not found"))
        }
    }
}
