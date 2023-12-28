package live.tesnetwork.tesict.components.data.user.device

import org.json.JSONObject

data class DeviceData (
    val deviceId: Int,
    val deviceName: String,
    val clientId: Int,
    val deviceOs: Int
) {
    fun toJson(): JSONObject {
        return JSONObject()
            .put("deviceId", deviceId)
            .put("deviceName", deviceName)
            .put("clientId", clientId)
            .put("deviceOs", deviceOs)
    }

    companion object {
        fun fromJson(json: JSONObject): DeviceData {
            return DeviceData(
                deviceId = json.getInt("deviceId"),
                deviceName = json.getString("deviceName"),
                clientId = json.getInt("clientId"),
                deviceOs = json.getInt("deviceOs")
            )
        }
    }
}
