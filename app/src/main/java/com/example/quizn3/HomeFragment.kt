package com.example.quizn3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.button)
        val sendBtn = view.findViewById<Button>(R.id.button_to_profile)

        val editText: EditText = view.findViewById(R.id.name_id)
        val editText2: EditText = view.findViewById(R.id.surname_id)
        val editText3: EditText = view.findViewById(R.id.GPA_id)

        val editTextList = listOf(editText, editText2, editText3)

        for (editTextItem in editTextList) {
            editTextItem.setOnLongClickListener {
                editTextItem.text.clear()
                return@setOnLongClickListener true
            }
        }

        sendBtn.setOnClickListener {
            val input = editText.text.toString()
            val input2 = editText2.text.toString()
            val input3 = editText3.text.toString().toIntOrNull() ?: 0



            val bundle = Bundle()
            bundle.putString("name",input )
            bundle.putString("surname",input2)
            bundle.putInt("GPA",input3)

            val fragment = ProfileFragment()
            fragment.arguments = bundle

//            Set up long-press action to clear all EditText fields
//            val editTextList = listOf(editText, editText2, editText3)
//            for (editTextItem in editTextList) {
//                editTextItem.setOnLongClickListener {
//                    editTextItem.text.clear()
//                    true
//                }
//            }
            requireActivity().supportFragmentManager.beginTransaction()?.replace(R.id.fragment, fragment)?.commit()
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listFragment)
        }

        return view
    }

}