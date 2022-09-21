package com.devscion.kmmtodo

interface Date {
    fun getTodayDate() : String
}

expect fun getPlatformTodayDate() : Date