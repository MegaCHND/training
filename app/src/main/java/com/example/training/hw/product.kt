package com.example.muffins.api

data class Product(
    val id:Int,
    val name:String,
    val price:Float,
    val description:String,
    val imageUrl:String,
    val rating:Float
)
