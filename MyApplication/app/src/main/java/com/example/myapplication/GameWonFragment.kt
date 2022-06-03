package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentGameBinding
import com.example.myapplication.databinding.FragmentScoreBinding


class GameWonFragment : Fragment() {
    lateinit var viewModel: GameViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScoreBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_score,container,false)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]
//        viewModel.winner.observe(viewLifecycleOwner, Observer {
//            binding.winnerText.text=it
//
//        })
        return binding.root
    }

}