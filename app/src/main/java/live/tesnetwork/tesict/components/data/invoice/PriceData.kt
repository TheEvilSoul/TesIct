package live.tesnetwork.tesict.components.data.invoice

import live.tesnetwork.tesict.components.data.helper.IConvertible
import org.json.JSONObject

data class PriceData(
    val totalPrice: Float,
    val vat: Float
) : IConvertible {
    fun getPriceWithoutVAT(): Float {
        return totalPrice - getAmountOfVAT()
    }

    fun getAmountOfVAT(): Float {
        if (vat == 0f || vat < 0f) return 0f
        return totalPrice * (vat / 100)
    }

    override fun toJson(): JSONObject {
        return JSONObject()
            .put("totalPrice", totalPrice)
            .put("vat", vat)
    }

    companion object {
        fun fromJson(json: JSONObject): PriceData {
            val totalPrice = json.getDouble("totalPrice").toFloat()
            val vat = json.getDouble("vat").toFloat()

            return PriceData(totalPrice, vat)
        }
    }
}
