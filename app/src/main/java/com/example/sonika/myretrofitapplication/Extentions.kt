package com.example.sonika.myretrofitapplication

import android.content.Context
import android.os.Message
import android.widget.Toast
import java.time.Duration

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT)
{
    Toast.makeText(this, message, duration).show()
}