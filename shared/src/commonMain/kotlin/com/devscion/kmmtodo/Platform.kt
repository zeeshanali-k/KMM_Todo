package com.devscion.kmmtodo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform