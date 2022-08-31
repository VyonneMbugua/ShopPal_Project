package com.example.shoppal.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.shoppal.R
import com.google.firebase.auth.FirebaseAuth

class ForgotActivity : AppCompatActivity() {

    lateinit var btn_submit:Button
    lateinit var et_email :EditText
    lateinit var et_password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        btn_submit = findViewById(R.id.btn_submit)
        et_password=findViewById(R.id.et_password)
        et_email=findViewById(R.id.et_email)
        var firebaseAuth = FirebaseAuth.getInstance()


        btn_submit.setOnClickListener {
            val intent=Intent(this@ForgotActivity,UserProfileActivity::class.java)
            startActivity(intent)
            finish()
        }



        btn_submit.setOnClickListener {
            val Email=et_email.text.toString().trim()
            val Password=et_password.text.toString().trim()

            if (Password.length<6){
                et_password.setError("Password must be 6 characters and above")
                et_password.requestFocus()
            }

            else if (Email.isEmpty()){
                et_email.setError("Please fill in this field")
                et_email.requestFocus()
            }else{
                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent=Intent(this@ForgotActivity,UserProfileActivity::class.java)
                        startActivity(intent)
                    }
            }

        }
    }
    }



}







