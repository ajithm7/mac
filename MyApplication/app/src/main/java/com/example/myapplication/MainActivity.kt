package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       // Log.i("Ajith","OnCreat in main")
        @Suppress("UNUSED_VARIABLE")
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        drawerLayout=binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController,drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navController)
        val actionBar=supportActionBar
        actionBar!!.title="Stone Scissor"


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        if(findNavController(R.id.myNavHostFragment).currentDestination?.id==R.id.title2){
            Log.i("Ajith","Inside destination")
            return NavigationUI.navigateUp(navController,drawerLayout)
        }else{
            Log.i("Ajith",R.id.title2.toString())
            Log.i("Ajith",findNavController(R.id.myNavHostFragment).currentDestination?.id.toString())
            Log.i("Ajith","Inside upButton")
        restartActivity(this)
            return navController.navigateUp()
        }
    }
    fun restartActivity(act: Activity) {
        val intent = Intent()
        intent.setClass(act, act.javaClass)
        act.startActivity(intent)
        act.finish()
    }


}