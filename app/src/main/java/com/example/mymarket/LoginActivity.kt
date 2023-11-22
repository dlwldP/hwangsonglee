package com.example.mymarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.login)?.setOnClickListener {
            val userEmail = findViewById<EditText>(R.id.useremail)?.text.toString()
            val password = findViewById<EditText>(R.id.password)?.text.toString()
            doLogin(userEmail, password)
        }
//        findViewById<Button>(R.id.join)?.setOnClickListener {
//            val userEmail = findViewById<EditText>(R.id.useremail)?.text.toString()
//            val password = findViewById<EditText>(R.id.password)?.text.toString()
//            val userName = findViewById<EditText>(R.id.username)?.text.toString()
//            val birth = findViewById<EditText>(R.id.birth)?.text.toString()
//            doJoin(userEmail,password,userName,birth)
//        }
    }

    private fun doLogin(userEmail: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(userEmail, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                else {
                    Log.w("LoginActivity", "signInWithEmail"); it.exception
                    Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
    }

//    private fun doJoin(userEmail: String, password: String, userName: String, birth: String) {
//        Firebase.auth.createUserWithEmailAndPassword(userEmail, password)
//            .addOnCompleteListener(this) {
//                if(it.isSuccessful) {
//                    startActivity(Intent(this, MainActivity::class.java))
//                }
//                else {
//                    Log.w("LoginActivity", "createUserWithEmail"), it.exception)
//                    Toast.makeText(this. "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
//                }
//            }
//    }
}