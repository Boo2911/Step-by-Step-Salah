package com.example.projectone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.projectone.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    var genderList = arrayOf("Gender", "Muslim", "Muslimah");

    var thoughtsList = arrayOf("School of thought", "Hanfi", "Shafi");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //for gender

        var arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genderList);
        binding.spinnerGender.adapter = arrayAdapter;

        binding.spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "item: "+genderList[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //for school of thoughts

        var arrayAdapterThoughts = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, thoughtsList);
        binding.spinnerSchoolOfThoughts.adapter = arrayAdapterThoughts;

        binding.spinnerGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, "item: "+thoughtsList[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}