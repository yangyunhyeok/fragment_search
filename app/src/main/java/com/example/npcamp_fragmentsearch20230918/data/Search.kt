package com.example.npcamp_fragmentsearch20230918.data

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.Date
import java.time.*


data class Search (val meta: Meta, val documents:Documents)

data class Meta(
    val total_count:Integer,
    val pageable_count:Integer,
    val is_end:Boolean
)

data class Documents(
    val collection:String,
    val thumbnail_url:String,
    val image_url:String,
    val width:Integer,
    val height:Integer,
    val display_sitename:String,
    val doc_url:String,
    val datetime:String
)