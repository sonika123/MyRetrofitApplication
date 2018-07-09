package com.example.sonika.myretrofitapplication.Model

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



// class User{
//
//
//    @SerializedName("Success")
//    var success: Boolean = false
//
//    @SerializedName("StatusCode")
//    var statusCode: String? = null
//
//    @SerializedName("Result")
//    var result: List<Result>? = null
//
//
//}
//
//class Result {
//
//    @SerializedName("Id")
//    var id : Int = 0
//
//    @SerializedName("Text")
//    var text : String? = null
//}


object Model
{
    data class User(
            var Id : String,
            var Text : String

    )

}
