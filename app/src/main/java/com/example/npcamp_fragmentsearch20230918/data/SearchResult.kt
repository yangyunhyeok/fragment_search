package com.example.npcamp_fragmentsearch20230918.data

data class SearchResult(
    var title:String,
    var dateTime:String,
    var uri:String,
    var like:Boolean = false
)