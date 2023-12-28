package live.tesnetwork.tesict.components.data.common

import live.tesnetwork.tesict.components.data.helper.IConvertible
import live.tesnetwork.tesict.components.data.invoice.PriceData
import org.json.JSONObject

data class ServiceData(
    val title: String,
    val description: String,
    val priceData: PriceData
) : IConvertible {
    override fun toJson(): JSONObject {
        return JSONObject()
            .put("title", title)
            .put("description", description)
            .put("priceData", priceData.toJson())
    }

    companion object {
        fun fromJson(json: JSONObject): ServiceData {
            val title = json.getString("title")
            val description = json.getString("description")
            val priceDataJson = json.getJSONObject("priceData")
            val priceData = PriceData.fromJson(priceDataJson)

            return ServiceData(title, description, priceData)
        }
    }

}
