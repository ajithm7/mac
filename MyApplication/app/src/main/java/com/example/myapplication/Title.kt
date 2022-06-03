package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.FragmentTitleBinding

class Title : Fragment() {
    lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setHasOptionsMenu(true)
//        Log.i("Ajith","On CreateView in title ")
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        binding.startButton.setOnClickListener { view: View ->
            var name1: String = binding.player1Name.text.toString()
            name1 = (if (name1.isEmpty()) "Player 1" else name1).toString()
            var name2 = binding.player2Name.text.toString()
            name2 = (if (name2.isEmpty()) "Player 2" else name2).toString()
            viewModel.assignName(name1, name2)
            view.findNavController().navigate(R.id.action_title2_to_gameFragment)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_fragment -> navigateAbout(item)
//            R.id.dark->
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateAbout(item: MenuItem) {
        requireView().findNavController()
            .navigate(R.id.action_title2_to_aboutFragment)
    }

//        val toggle: ToggleButton = findViewById(R.id.togglebutton)
//        toggle.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                // The toggle is enabled
//            } else {
//                // The toggle is disabled
//            }
//    }

}


