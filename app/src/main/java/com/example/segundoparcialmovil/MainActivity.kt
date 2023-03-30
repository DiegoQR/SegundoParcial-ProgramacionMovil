package com.example.segundoparcialmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restApiAdapter = RestApiAdapter()
        val endPoint = restApiAdapter.connectionApi()
        val bookResponseCall = endPoint.getAllPost()

        bookResponseCall.enqueue(object: Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t?.printStackTrace();
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response?.body()
                Log.d("Resp Post", Gson().toJson(posts))
                posts?.forEach{
                    Log.d("Resp Post", it.body)
                }
            }
        })
    }
}