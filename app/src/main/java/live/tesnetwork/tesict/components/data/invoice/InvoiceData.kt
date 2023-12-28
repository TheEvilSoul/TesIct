package live.tesnetwork.tesict.components.data.invoice

import live.tesnetwork.tesict.components.data.helper.IConvertible
import org.json.JSONArray
import org.json.JSONObject
import java.util.Date

data class InvoiceData (
    val invoiceId: Int,
    val clientId: Int,
    val items: List<InvoiceItem>,
    val payedStatus: Boolean,
    val dueDate: Date
) : IConvertible {

    fun getPrice(): Float {
        var price = 0f
        items.forEach { item -> price+= item.getPrice()}
        return price
    }
    override fun toJson(): JSONObject {
        val itemsArray = JSONArray()
        items.stream()
            .map(InvoiceItem::toJson)
            .forEach(itemsArray::put)

        return JSONObject()
            .put("invoiceId", invoiceId)
            .put("clientId", clientId)
            .put("items", itemsArray)
            .put("payedStatus", payedStatus)
            .put("dueDate", dueDate.time)

    }

    companion object {
        fun fromJson(json: JSONObject): InvoiceData {
            val invoiceId = json.getInt("invoiceId")
            val clientId = json.getInt("clientId")
            val itemsArray = json.getJSONArray("items")
            val items = mutableListOf<InvoiceItem>()
            for (i in 0 until itemsArray.length()) {
                val itemJson = itemsArray.getJSONObject(i)
                items.add(InvoiceItem.fromJson(itemJson))
            }
            val payedStatus = json.getBoolean("payedStatus")
            val dueDate = Date(json.getLong("dueDate"))

            return InvoiceData(invoiceId, clientId, items, payedStatus, dueDate)
        }
    }
}
