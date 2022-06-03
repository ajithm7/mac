package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        get(requireContext())
        val sd = this
        val sdf = requireActivity()
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
    fun get(context: Activity){

    }

}