package com.example.dota2.util

import android.util.Log

class AndroidLogImpl: AndroidLog {
   override fun e(tag: String, msg: String?) {
        Log.e(tag,msg)
    }
   override fun d(tag: String, msg: String) {
        Log.d(tag,msg)
    }
}