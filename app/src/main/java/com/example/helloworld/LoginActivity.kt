package com.example.helloworld
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateLogin(username, password)) {
                val homeIntent = Intent(this, HomeActivity::class.java)
                homeIntent.putExtra("username" , username)
                startActivity(homeIntent)
                finish()
            } else {
                Toast.makeText(this, "Geçersiz kullanıcı adı veya parola", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateLogin(username: String, password: String): Boolean {
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val savedPassword = sharedPref.getString(username ,"impossible")
        return savedPassword == password
    }
}