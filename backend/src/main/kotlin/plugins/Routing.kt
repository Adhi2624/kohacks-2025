package com.payir.plugins

import com.payir.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        authRoutes()
        farmerRoutes()
        agriDeptRoutes()
        facilityRoutes()
        bookingRoutes()
        storageRecordRoutes()
        locationRoutes()
        syncRoutes()
        adminRoutes()
    }
}

