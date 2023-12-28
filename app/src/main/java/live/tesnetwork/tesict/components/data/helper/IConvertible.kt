package live.tesnetwork.tesict.components.data.helper

import org.json.JSONObject

interface IConvertible {
    
    fun toJson(): JSONObject
}