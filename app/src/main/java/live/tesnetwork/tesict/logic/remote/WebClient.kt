package live.tesnetwork.tesict.logic.remote

import org.json.JSONObject
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets


class WebClient {
    fun get(url: URL): HttpURLConnection {
        return sendHttpRequest(url)
    }

    fun post(url: URL, data: JSONObject = JSONObject()): HttpURLConnection {
        return sendHttpRequestWithData(url, data = data)
    }

    private fun sendHttpRequest(url: URL, methode: String = "GET"): HttpURLConnection {
        val connection = (url.openConnection() as HttpURLConnection).apply {
            requestMethod = methode
            connectTimeout = 5000
            readTimeout = 5000
        }

        return connection
    }

    private fun sendHttpRequestWithData(
        url: URL,
        methode: String = "POST",
        data: JSONObject = JSONObject()
    ): HttpURLConnection {
        val connection = (URL(url.toString()).openConnection() as HttpURLConnection).apply {
            requestMethod = methode
            connectTimeout = 5000
            readTimeout = 5000
            doOutput = true
        }
        val postData = data.toString().toByteArray(StandardCharsets.UTF_8)
        val outputStream = DataOutputStream(connection.outputStream)
        outputStream.write(postData)
        outputStream.flush()
        outputStream.close()
        return connection
    }


    private fun buildUrlWithParams(url: URL, data: JSONObject): String? {
        TODO("Not yet implemented")
    }
}