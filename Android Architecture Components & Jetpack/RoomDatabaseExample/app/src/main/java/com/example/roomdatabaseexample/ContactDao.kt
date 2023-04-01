package com.example.roomdatabaseexample

import androidx.lifecycle.LiveData
import androidx.room.*
/*
* Dao is an interface that contains set of methods to perform CRUD operations
* There can be multiple Dao Interfaces, where each represent CRUD operation on specific table
* All the implementation of CRUD operation methods are handled by ROOM Database only.
* */
@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact:ContactEntity)

    @Update
    suspend fun updateContact(contact:ContactEntity)

    @Delete
    suspend fun deleteContact(contact:ContactEntity)

    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<ContactEntity>>

    @Query("Update contact set name=:name where id = :pos")
    suspend  fun updateName(pos:Int, name:String)

}
