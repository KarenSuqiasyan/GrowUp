package com.example.growup

interface NetworkCallback {
    fun onSuccess(response: String)
    fun onFailure(error: String)
}

class NetworkDelegate : NetworkCallback {
    override fun onSuccess(response: String) {
        println("NetworkDelegate: Success - $response")
    }

    override fun onFailure(error: String) {
        println("NetworkDelegate: Failure - $error")
    }
}

class NetworkClientWithDelegate(callback: NetworkCallback) : NetworkCallback by callback {

    fun makeNetworkRequest() {
        val isSuccess = true
        if (isSuccess) {
            onSuccess("Response from server")
        } else {
            onFailure("Network error")
        }
    }

}

fun main() {
    val delegate = NetworkDelegate()
    val client = NetworkClientWithDelegate(delegate)
    client.makeNetworkRequest()


}

