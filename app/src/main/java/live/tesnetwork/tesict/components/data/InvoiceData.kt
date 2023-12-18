package live.tesnetwork.tesict.components.data

import org.json.JSONObject
import java.util.Date

data class InvoiceData (
    val invoiceId: Int,
    val userId: String,
    val price: Float,
    val workOrderId: Int,
    val payedStatus: Boolean,
    val dueDate: Date
) {
    fun toJson(): JSONObject {
        return JSONObject()
            .put("invoiceId", invoiceId)
            .put("userId", userId)
            .put("price", price)
            .put("orderId", workOrderId)
            .put("payedStatus", payedStatus)
            .put("dueDate", dueDate.time)
    }

    companion object {
        fun fromJson(json: JSONObject): InvoiceData {
            return InvoiceData(
                invoiceId = json.getInt("invoiceId"),
                userId = json.getString("userId"),
                price = json.getDouble("price").toFloat(),
                workOrderId = json.getInt("orderId"),
                payedStatus = json.getBoolean("payedStatus"),
                dueDate = Date(json.getLong("dueDate"))
            )
        }
    }
}
