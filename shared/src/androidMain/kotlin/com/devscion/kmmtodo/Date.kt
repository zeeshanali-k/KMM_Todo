package com.devscion.kmmtodo

class AndroidDate : Date {
    override fun getTodayDate(): String = java.util.Date(System.currentTimeMillis())
        .toString()
}

actual fun getPlatformTodayDate() : Date = AndroidDate()