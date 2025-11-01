package routes

import com.payir.controllers.AdminController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.adminRoutes() {
    route("/admin") {
        post("/createFacility") {
            AdminController.createFacility(call)
        }

        put("/updateFacility/{id}") {
            AdminController.updateFacility(call)
        }

        get("/facilities") {
            AdminController.getAllFacilities(call)
        }

        get("/facility/{id}") {
            AdminController.getFacilityById(call)
        }

        delete("/facility/{id}") {
            AdminController.deleteFacility(call)
        }
    }
}
