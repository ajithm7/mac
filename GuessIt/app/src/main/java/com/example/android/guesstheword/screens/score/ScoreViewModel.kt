package com.example.android.guesstheword.screens.score

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.screens.game.GameFragment

class ScoreViewModel (finalScore:Int): ViewModel() {
    init{
        Log.i("Ajith","final score is $finalScore")
    }
}
