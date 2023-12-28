package live.tesnetwork.tesict.components.data.invoice

import org.json.JSONObject

class InvoiceItemProduct (
    private val itemId: Int,
    private val title: String,
    private val description: String,
    private val quantity: Int,
    private val unitPrice: Float,
    private val vat: Float,
) : InvoiceItem {
    override fun getItemId(): Int {
        return itemId
    }


    override fun getTitle(): String {
        return title
    }

    override fun getDescription(): String {
        return description
    }

    override fun getQuantity(): Int {
        return quantity
    }

    override fun getUnitPrice(): Float {
       return unitPrice
    }

    override fun getVAT(): Float {
        return vat
    }

    override fun isWorkOrder(): Boolean {
        return false
    }

    override fun toJson(): JSONObject {
        return JSONObject()
            .put("itemId", itemId)
            .put("title", title)
            .put("description", description)
            .put("quantity", quantity)
            .put("unitPrice", unitPrice)
            .put("btw", vat)
            .put("isWorkOrder", isWorkOrder())
    }
    companion object {
        fun fromJson(json: JSONObject): InvoiceItemProduct {
            val itemId = json.getInt("itemId")
            val title = json.getString("title")
            val description = json.getString("description")
            val quantity = json.getInt("quantity")
            val unitPrice = json.getDouble("unitPrice").toFloat()
            val btw = json.getDouble("btw").toFloat()

            return InvoiceItemProduct(itemId, title, description, quantity, unitPrice, btw)
        }
    }
}
