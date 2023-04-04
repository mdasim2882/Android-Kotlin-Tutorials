package com.example.mvvm_demo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class QuoteEntity(

    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val text : String,
    val author: String
)