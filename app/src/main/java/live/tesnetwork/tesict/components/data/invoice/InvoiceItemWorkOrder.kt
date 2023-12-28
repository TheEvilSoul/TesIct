package live.tesnetwork.tesict.components.data.invoice

import live.tesnetwork.tesict.components.data.common.WorkOrderData
import org.json.JSONObject

class InvoiceItemWorkOrder (
    private val itemId: Int,
    private val workOrderData: WorkOrderData,
    private val quantity: Int
) : InvoiceItem {

    fun getWorkOrder(): WorkOrderData {
        return workOrderData
    }
    override fun getItemId(): Int {
        return itemId;
    }

    override fun getTitle(): String {
        return workOrderData.title
    }

    override fun getDescription(): String {
        return workOrderData.description
    }

    override fun getQuantity(): Int {
        return quantity
    }

    override fun getUnitPrice(): Float {
       return workOrderData.getPrice()
    }

    override fun getVAT(): Float {
        return 21f
    }


    override fun isWorkOrder(): Boolean {
        return true
    }

    override fun toJson(): JSONObject {
        return JSONObject()
            .put("itemId", itemId)
            .put("workOrderId", workOrderData.workOrderId)
            .put("quantity", quantity)
            .put("isWorkOrder", isWorkOrder())
    }

    companion object {
        fun fromJson(json: JSONObject): InvoiceItemWorkOrder {
            val itemId = json.getInt("itemId")
            val workOrderDataJson = json.getJSONObject("workOrderData")
            val workOrderData = WorkOrderData.fromJson(workOrderDataJson)
            val quantity = json.getInt("quantity")

            return InvoiceItemWorkOrder(itemId, workOrderData, quantity)
        }
    }
}
