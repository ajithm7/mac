package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.contact.database.Contact
import com.example.contact.database.ContactDao
import com.example.contact.database.ContactDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class AddContact : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var number: EditText
    private lateinit var save: Button
    lateinit var nameText: String
    lateinit var numberText: String
    lateinit var viewModel: AddContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)
        setUI()
        viewModel = ViewModelProvider(this)[AddContactViewModel::class.java]
        save.setOnClickListener {
            nameText = name.text.toString()
            numberText = number.text.toString()
            if (validate()) {
               viewModel.saveContact(nameText,numberText)
                onBackPressed()
            }
        }
    }


    fun validate(): Boolean {
        if (nameText.trim().isBlank() || numberText.trim().isBlank()) {
            Toast.makeText(this, "please enter title and description", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun setUI() {
        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        save = findViewById(R.id.save)

    }
}