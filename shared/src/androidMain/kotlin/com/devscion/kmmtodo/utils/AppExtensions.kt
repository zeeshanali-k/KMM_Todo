package com.devscion.kmmtodo.utils

import android.util.Log


infix fun java.lang.Exception.logAll(tag : String){
    Log.d(tag, "logAll: $localizedMessage")
    Log.d(tag, "logAll: $message")
    Log.d(tag, "logAll: $cause")
}

infix fun Exception.logAllJava(tag : String){
    Log.d(tag, "logAll: $localizedMessage")
    Log.d(tag, "logAll: $message")
    Log.d(tag, "logAll: $cause")
}