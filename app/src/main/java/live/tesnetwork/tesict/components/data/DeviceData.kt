package live.tesnetwork.tesict.components.data

import org.json.JSONObject

data class DeviceData (
    val deviceId: Int,
    val deviceName: String,
    val userId: String,
    val deviceOs: Int
) {
    fun toJson(): JSONObject {
        return JSONObject()
            .put("deviceId", deviceId)
            .put("deviceName", deviceName)
            .put("userId", userId)
            .put("deviceOs", deviceOs)
    }

    companion object {
        fun fromJson(json: JSONObject): DeviceData {
            return DeviceData(
                deviceId = json.getInt("deviceId"),
                deviceName = json.getString("deviceName"),
                userId = json.getString("userId"),
                deviceOs = json.getInt("deviceOs")
            )
        }
    }
}
