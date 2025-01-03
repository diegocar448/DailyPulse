package com.diego.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform