package com.example.roomdatabaseexample

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


// Each entity represents a table in Database
@Entity(tableName = "contact")

data class ContactEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phone: String,
    val createdDate : Date
)