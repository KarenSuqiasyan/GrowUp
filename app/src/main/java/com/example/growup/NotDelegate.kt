package com.example.growup

class NetworkCallbackHandler {
    fun onSuccess(response: String) {
        println("NetworkCallbackHandler: Success - $response")
    }

    fun onFailure(error: String) {
        println("NetworkCallbackHandler: Failure - $error")
    }
}

class NetworkClient {
    private val callbackHandler = NetworkCallbackHandler()

    fun makeNetworkRequest() {
        val isSuccess = true
        if (isSuccess) {
            callbackHandler.onSuccess("Response from server")
        } else {
            callbackHandler.onFailure("Network error")
        }
    }
}

fun main() {
    val client = NetworkClient()

    client.makeNetworkRequest()
}
