package com.devscion.kmmtodo

import platform.Foundation.NSDate

class IOSDate : Date {
    override fun getTodayDate(): String {
        return NSDate().toString()
    }
}

actual fun getPlatformTodayDate() : Date = IOSDate()