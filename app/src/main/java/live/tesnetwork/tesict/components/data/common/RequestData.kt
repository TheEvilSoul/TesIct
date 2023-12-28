package live.tesnetwork.tesict.components.data.common

import live.tesnetwork.tesict.components.data.helper.IConvertible
import org.json.JSONObject

data class RequestData(
    val title: String,
    val description: String,
    val clientId: Int
) : IConvertible {
    override fun toJson(): JSONObject {
        return JSONObject()
            .put("title", title)
            .put("description", description)
            .put("clientId", clientId)
    }

    companion object {
        fun fromJson(json: JSONObject): RequestData {
            val title = json.getString("title")
            val description = json.getString("description")
            val clientId = json.getInt("clientId")

            return RequestData(title, description, clientId)
        }
    }

}
