package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    var scoreOne: Int = 0
    var scoreTwo: Int = 0
    lateinit var viewModel: GameViewModel
    lateinit var player1Image: ImageView
    lateinit var player2Image: ImageView
    lateinit var name1: String
    lateinit var name2: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        Log.i("Ajith","OnCreatView in game")
        val binding: FragmentGameBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        lateinit var winner: String
        player1Image = binding.imageView3
        player2Image = binding.imageView2
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
//        viewModel.playerOneName.observe(viewLifecycleOwner, Observer {
//            name1 = it
//            binding.PlayerOneName.text = it
//        })
//        viewModel.playerTwoName.observe(viewLifecycleOwner, Observer {
//            name2 = it
//            binding.playerTwoName.text = it
//        })
        binding.playButton.setOnClickListener {
            scoreOne = (viewModel.scoreOne.value)!!.toInt()
            scoreTwo = (viewModel.scoreTwo.value)!!.toInt()



            if (scoreOne <= 10 && scoreTwo <= 10) {
                viewModel.playing()
                var image1 = when (viewModel.imageOne) {
                    1 -> R.drawable.paperpng
                    2 -> R.drawable.scissorpng
                    else -> R.drawable.stonepng
                }
                binding.scoreOneText.text = scoreOne.toString()

                player1Image.setImageResource(image1)
                var image2 = when (viewModel.imageTwo) {
                    1 -> R.drawable.paperpng
                    2 -> R.drawable.scissorpng
                    else -> R.drawable.stonepng
                }
                binding.scoreTwoText.text = scoreTwo.toString()
                player2Image.setImageResource(image2)
                if (scoreOne > scoreTwo) {
                    winner = name1
                    Log.i("Ajith", "from if- if $winner")
                } else {
                    winner = name2
                    Log.i("Ajith", "from if-else $winner")
                }
            } else {
                Log.i("Ajith", "from else $winner")
                viewModel.setWinner(winner)
                binding.playButton.text = "Finish"
                binding.playButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_to_scoreFragment))
            }

        }


        return binding.root
    }
}