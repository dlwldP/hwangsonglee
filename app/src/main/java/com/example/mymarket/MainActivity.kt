package com.example.mymarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        auth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.login)?.setOnClickListener {
        val userEmail = findViewById<EditText>(R.id.useremail)?.text.toString()
        val password = findViewById<EditText>(R.id.password)?.text.toString()
        doLogin(userEmail, password)
    }
    findViewById<Button>(R.id.join)?.setOnClickListener {
        startActivity(Intent(this, JoinActivity::class.java))
    }
}

private fun doLogin(userEmail: String, password: String) {
    Firebase.auth.signInWithEmailAndPassword(userEmail, password)
        .addOnCompleteListener(this) {
            if (it.isSuccessful) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Log.w("LoginActivity", "signInWithEmail", it.exception)
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
}
}