package live.tesnetwork.tesict.components.data.invoice

import live.tesnetwork.tesict.components.data.helper.IConvertible
import org.json.JSONObject

interface InvoiceItem: IConvertible {
    fun getItemId(): Int
    fun getTitle(): String
    fun getDescription(): String
    fun getQuantity(): Int
    fun getUnitPrice(): Float
    fun getVAT(): Float
    fun isWorkOrder(): Boolean
    fun getPrice(): Float {
        return getUnitPrice() * getQuantity()
    }

    companion object {
        fun fromJson(json: JSONObject): InvoiceItem {
            if (json.getBoolean("isWorkOrder")) return InvoiceItemWorkOrder.fromJson(json)
            return InvoiceItemProduct.fromJson(json)
        }
    }

}