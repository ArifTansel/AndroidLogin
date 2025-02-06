package com.example.helloworld

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var etText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        etText = findViewById(R.id.textView)
        val username = intent.getStringExtra("username")
        etText.text = username

    }
}