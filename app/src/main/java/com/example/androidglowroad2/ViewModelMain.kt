package com.example.androidglowroad2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.IOException
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class ViewModelMain(val context : Application) : AndroidViewModel(context) {

  var responseAwaited = MutableLiveData<String>()

   fun CallApi() : LiveData<String>
   {
     CoroutineScope(Dispatchers.IO).launch {
       val job = async {
        val request = OkHttpRequest()
        request.GET("https://kamateraho.s3.ap-south-1.amazonaws.com/test_response.json",object :Callback{
  override fun onFailure(request: Request?, e: IOException?) {

  }

  override fun onResponse(response: Response?) {
    val responseData = response!!.body().string()
    var json = JSONObject(responseData)
    Log.d("Success","Request Successful!!")
    Log.d("Success JSON",""+json)
    val responseObject = json.getJSONObject("photos")
    Log.d("Final",""+responseObject.toString())
    responseAwaited.postValue(responseObject.toString())
  }


})


       }
       val abc = job.await()
       try {
         withContext(Dispatchers.Main)
         {

         }
       }catch (e:Exception){

         }

     }


     return responseAwaited
  }



}