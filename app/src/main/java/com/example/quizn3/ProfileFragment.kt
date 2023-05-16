package com.example.quizn3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ProfileFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val textView: TextView = view.findViewById(R.id.display_home)
        val textView1: TextView = view.findViewById(R.id.display_home1)
        val textView2: TextView = view.findViewById(R.id.display_home2)
        val args = this.arguments
        val inputData = args?.get("name")
        val inputSurname = args?.get("surname")
        val inputGpa = args?.get("GPA")
        textView2.text = inputGpa.toString()
        textView1.text = inputSurname.toString()
        textView.text =  inputData.toString()

        return view
    }

}