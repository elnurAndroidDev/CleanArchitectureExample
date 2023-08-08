package com.isayevapps.cleanarchitectureexample.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.isayevapps.cleanarchitectureexample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)

        viewModel.nameLive.observe(this) {
            dataTextView.text = it
        }

        saveButton.setOnClickListener {
            val name = dataEditText.text.toString()
            viewModel.save(name)
        }

        getButton.setOnClickListener {
            viewModel.load()
        }
    }
}