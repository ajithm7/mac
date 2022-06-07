package com.example.contact

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contact.database.Contact
import com.example.contact.database.ContactDao
import com.example.contact.database.ContactDatabase
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

class AddContactViewModel(application: Application) : AndroidViewModel(application) {
    var contactdatabase = ContactDatabase.getInstance(application)
    var contactDao: ContactDao = contactdatabase.contactDao()
    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    private val _number = MutableLiveData<String>()
    val number: LiveData<String>
        get() = _number

//  fun setData(contactName:String,contactNumber:String){
//      _name.value=contactName
//      _number.value = contactNumber
//  }

     fun saveContact(contactName: String, contactNumber: String) {
        val date: String =
            SimpleDateFormat("EEE, dd MMM yy", Locale.getDefault()).format(Date())

        val contact = Contact(0, contactName, contactNumber, date)
        GlobalScope.launch {
            contactDao.insert(contact)

        }

    }
}


