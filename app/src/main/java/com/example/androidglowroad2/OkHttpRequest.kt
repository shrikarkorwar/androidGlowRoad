package com.example.androidglowroad2

import com.squareup.okhttp.*

class OkHttpRequest() {

  companion object {
    val JSON = MediaType.parse("application/json; charset=utf-8")
  }

  fun GET(url: String, callback: Callback): Call {
    var client = OkHttpClient()
    val request = Request.Builder()
      .url(url)
      .build()

    val call = client.newCall(request)
    call.enqueue(callback)
    return call
  }
}