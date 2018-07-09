package com.example.sonika.myretrofitapplication

import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sonika.myretrofitapplication.ApiInterface.Companion.client
import com.example.sonika.myretrofitapplication.ApiInterface.Companion.retrofit
import com.example.sonika.myretrofitapplication.Model.Model
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback




class MainActivity : AppCompatActivity() {

//    private var disposable: Disposable? = null
//
//    private val ApiServe by lazy {
//        ApiInterface.create()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (isOnline())
        {
            client = retrofit.create(ApiInterface::class.java)

// Fetch a list of the repositories.
            val call = client.reposForUser()

// Execute the call asynchronously. Get a positive or negative callback.
            call.enqueue(object : Callback<List<Model.User>> {

                override fun onFailure(call: Call<List<Model.User>>?, t: Throwable?) {
                    Log.e("helo", "fail")
                    toast("failed")
                }

                override fun onResponse(call: Call<List<Model.User>>?, response: retrofit2.Response<List<Model.User>>?) {

                    val responseString = response!!.body()

                    val list= responseString!!.map { it.Text }
                    spinner_occupation.adapter =  ArrayAdapter<String>(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item, list)


                    Log.e("hi", responseString.toString())

                    toast("Success")
                }

            })


            toast("ok")
        }
        else
        {
            toast("no internet")
        }
    }

    fun isOnline() : Boolean {
        val cm = this.getSystemService(android.content.Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

}

