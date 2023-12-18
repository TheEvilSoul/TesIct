package live.tesnetwork.tesict.components.data

import org.json.JSONObject
import java.util.Date

data class WorkOrderData(
    val workOrderId: Int,
    val creationDate: Date,
    val userId: String,
    val workerId: String,
    val deviceId: Int,
    val description: String,
    val title: String,
    val status: Int,
    val invoiceId: Int
) {
    fun toJson(): JSONObject {
        return JSONObject()
            .put("workOrderId", workOrderId)
            .put("creationDate", creationDate.time)
            .put("userId", userId)
            .put("workerId", workerId)
            .put("deviceId", deviceId)
            .put("description", description)
            .put("title", title)
            .put("status", status)
            .put("invoiceId", invoiceId)
    }
    companion object {
        fun fromJson(json: JSONObject): WorkOrderData {
            return WorkOrderData(
                workOrderId = json.getInt("workOrderId"),
                creationDate = Date(json.getLong("creationDate")),
                userId = json.getString("userId"),
                workerId = json.getString("workerId"),
                deviceId = json.getInt("deviceId"),
                description = json.getString("description"),
                title = json.getString("title"),
                status = json.getInt("status"),
                invoiceId = json.getInt("invoiceId")
            )
        }
    }

}
