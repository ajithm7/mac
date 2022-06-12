package com.example.verification

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.verification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        var email:String="ajithkumarsrce@gmail.com"
        /*${email.let { binding.verifictionMessageText.setTypeface(null, Typeface.BOLD); }}*/
        var message:String="Verification mail has been sent to \b$email.\b Please verify your email address to continue using Zoho Assist. For more details , read our"
        binding.verifictionMessageText.text=message
    }
}