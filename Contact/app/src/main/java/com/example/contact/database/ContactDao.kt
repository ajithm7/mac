package com.example.contact.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
@Dao
interface ContactDao {
    @Insert
    fun insert(contact:Contact)
    @Update
    fun update(contact:Contact)
    @Query("DELETE FROM contact_table")
    fun clear()
    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    fun getAllContacts(): LiveData<List<Contact>>

}