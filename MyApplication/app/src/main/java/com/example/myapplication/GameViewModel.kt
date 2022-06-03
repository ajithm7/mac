package com.example.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.StoneDatabase
import com.example.myapplication.database.StoneScissor
import kotlin.random.Random


class GameViewModel(application: Application) : AndroidViewModel(application) {
    // lateinit var stoneScissor: StoneScissor
    val db = StoneDatabase.getInstance(application)
    val dao = db.stoneDatabaseDao
    private val _game = MutableLiveData<List<StoneScissor>>()
    val game: LiveData<List<StoneScissor>>
        get() = _game
    var scoreOne = MutableLiveData<Int>()
    var scoreTwo = MutableLiveData<Int>()

    //    var playerOneName=MutableLiveData<String>()
//    var playerTwoName=MutableLiveData<String>()
//    var winner=MutableLiveData<String>()
    var imageOne = 0
    var imageTwo = 0

    init {
        scoreOne.value = 0
        scoreTwo.value = 0
    }

    fun playing() {
        imageOne = randomNum()
        imageTwo = randomNum()
        if (imageOne > imageTwo) {
            scoreOne.value = scoreOne.value?.plus(1)
        } else if (imageTwo > imageOne) {
            scoreTwo.value = scoreTwo.value?.plus(1)
        }
    }

    fun randomNum(): Int = Random.nextInt(1, 4)
    fun assignName(name1: String, name2: String) {
        val stoneScissor: StoneScissor = StoneScissor()
//        playerOneName.value=name1
//        playerTwoName.value=name2
        stoneScissor.playerOneName = name1
        stoneScissor.playerTwoName = name2
    }

    fun setWinner(name: String) {
//        winner.value=name
        val stoneScissor: StoneScissor = StoneScissor()
        stoneScissor.winnerName = name
        dao.insert(stoneScissor)
//        Log.i("Ajith","winner in viewModel ${winner.value}")
    }

    fun getAllData() {
        _game.value = dao.getAllGames()
    }


}