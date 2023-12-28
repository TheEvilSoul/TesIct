package live.tesnetwork.tesict.components.data.user

import live.tesnetwork.tesict.components.data.helper.IConvertible
import org.json.JSONObject

data class ClientData(
    val clientId: Int,
    val name: String,
    val profileData: ProfileData
) : IConvertible {

    fun getAsUser(): User {
        return User(name, profileData.profileImageUrl)
    }
    override fun toJson(): JSONObject {
        return JSONObject()
            .put("clientId", clientId)
            .put("name", name)
            .put("profileData", profileData)
    }

}