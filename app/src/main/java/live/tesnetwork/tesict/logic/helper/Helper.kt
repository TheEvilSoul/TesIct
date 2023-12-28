package live.tesnetwork.tesict.logic.helper

import android.icu.util.Calendar
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.util.Date


fun getDateAtMidnight(): Date {
    return Calendar.getInstance().apply {
        time = Date()
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.time
}
fun String.toJsonObject(): JSONObject {
    return try {
        JSONObject(this)
    } catch (e: Exception) {
        throw IllegalArgumentException("Invalid JSON string: $this", e)
    }
}

fun String.toJsonArray(): JSONArray {
    return try {
        JSONArray(this)
    } catch (e: Exception) {
        throw IllegalArgumentException("Invalid JSON string: $this", e)
    }
}

fun HttpURLConnection.getData(): String {
    try {
        val responseCode = this.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val inputStream = this.inputStream
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()

            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }

            bufferedReader.close()
            inputStream.close()

            return stringBuilder.toString()
        } else {
            throw RuntimeException("Failed to get response from server. Response code: $responseCode")
        }
    } finally {
        this.disconnect()
    }
}