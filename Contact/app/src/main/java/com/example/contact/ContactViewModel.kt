package com.example.contact

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.contact.database.Contact
import com.example.contact.database.ContactDao
import com.example.contact.database.ContactDatabase
import kotlinx.coroutines.*

@SuppressLint("StaticFieldLeak")
class ContactViewModel(application: Application) : AndroidViewModel(application) {

//    private val viewModelJob = Job()
    private val uiScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
 //   private var _contactList = MutableLiveData<List<Contact>>()
 //   val contactList:LiveData<List<Contact>>
//    get()=_contactList
    var job:Job? = null
    val database:ContactDatabase=ContactDatabase.getInstance(application)
    val contactDao:ContactDao=database.contactDao()

    fun getData(): LiveData<List<Contact>> {
//        database operation should not be in main thread. so use coroutine
//        val list=noteDao?.getAllNotes()
//        var contacts: LivedataList<Contact>? = null
        return contactDao.getAllContacts()

//            setContactValue(contactDao.getAllContacts())

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    private fun setContactValue(contactList: List<Contact>): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            "ass"
           // _contactList.value = contactList
        }
    }
}