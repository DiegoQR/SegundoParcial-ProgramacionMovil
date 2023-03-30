package com.example.segundoparcialmovil

class ConstantsRestApi {
    companion object {
        const val URL_BASE = "https://jsonplaceholder.typicode.com"
        const val POSTS ="/posts"
    }
}

data class Post(val userId: Int, val id: Int, val title: String, val body: String)
