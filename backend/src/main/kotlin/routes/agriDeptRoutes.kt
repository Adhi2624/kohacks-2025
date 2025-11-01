package routes

import com.payir.controllers.AgriDeptController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.agriDeptRoutes() {
    route("/agri") {

        // ✅ Approve a farmer registration
        put("/approveFarmer/{farmerId}") {
            AgriDeptController.approveFarmer(call)
        }

        // ❌ Reject a farmer registration
        put("/rejectFarmer/{farmerId}") {
            AgriDeptController.rejectFarmer(call)
        }

        // 📄 Verify a farmer’s document
        put("/verifyDocument/{documentId}") {
            AgriDeptController.verifyDocument(call)
        }

        // 📋 View all pending farmers
        get("/pendingFarmers") {
            AgriDeptController.getPendingFarmers(call)
        }

        // 📦 View storage/facility data
        get("/facilities") {
            AgriDeptController.getAllFacilities(call)
        }
    }
}
