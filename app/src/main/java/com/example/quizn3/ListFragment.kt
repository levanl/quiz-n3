package com.example.quizn3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)
        val button = view.findViewById<Button>(R.id.button2)
        val buttonHome = view.findViewById<ImageView>(R.id.backToHome)
        val buttonPerson = view.findViewById<ImageView>(R.id.backToPerson)

        buttonPerson.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_profileFragment)
        }
        buttonHome.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_homeFragment)
        }
        button.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_homeFragment)
        }
        return view
    }

}