package live.tesnetwork.tesict.components.data.common

import org.json.JSONArray
import org.json.JSONObject
import java.util.Date

data class WorkOrderData(
    val workOrderId: Int,
    val creationDate: Date,
    val requestData: RequestData,
    val workerId: Int,
    val deviceId: Int,
    val status: Int,
    val serviceData: List<ServiceData> = listOf(),
    val invoiceId: Int? = null,
    val title: String = requestData.title,
    val description: String = requestData.description
) {

    fun getPrice(): Float {
        var price = 0f
        serviceData.forEach { s -> price += s.priceData.totalPrice }
        return price
    }

    fun toJson(): JSONObject {
        var serviceJsonArray = JSONArray()
        serviceData.stream().map(ServiceData::toJson).forEach(serviceJsonArray::put)
        return JSONObject()
            .put("workOrderId", workOrderId)
            .put("creationDate", creationDate.time)
            .put("requestData", requestData.toJson())
            .put("serviceData", serviceJsonArray)
            .put("title", title)
            .put("description", description)
            .put("workerId", workerId)
            .put("deviceId", deviceId)
            .put("status", status)
            .put("invoiceId", invoiceId)
    }

    companion object {
        fun fromJson(json: JSONObject): WorkOrderData {
            val workOrderId = json.getInt("workOrderId")
            val creationDate = Date(json.getLong("creationDate"))
            val requestDataJson = json.getJSONObject("requestData")
            val requestData = RequestData.fromJson(requestDataJson)

            val serviceDataJsonArray = json.getJSONArray("serviceData")
            val serviceData = mutableListOf<ServiceData>()
            for (i in 0 until serviceDataJsonArray.length()) {
                val serviceJson = serviceDataJsonArray.getJSONObject(i)
                serviceData.add(ServiceData.fromJson(serviceJson))
            }

            val title = json.getString("title")
            val description = json.getString("description")
            val workerId = json.getInt("workerId")
            val deviceId = json.getInt("deviceId")
            val invoiceId =
                if (json.has("invoiceId") && !json.isNull("invoiceId")) json.getInt("invoiceId") else null
            val status = json.getInt("status")

            return WorkOrderData(
                workOrderId,
                creationDate,
                requestData,
                workerId,
                deviceId,
                status,
                serviceData,
                invoiceId,
                title,
                description,
            )
        }
    }

}
