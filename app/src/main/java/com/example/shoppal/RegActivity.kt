package com.example.shoppal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.example.shoppal.utils.UserProfileActivity
import com.google.firebase.auth.FirebaseAuth

class RegActivity : AppCompatActivity() {

    lateinit var et_first_name:EditText
    lateinit var et_last_name:EditText
    lateinit var et_email:EditText
    lateinit var et_password:EditText
    lateinit var tv_login:EditText
    lateinit var already_have_an_account:EditText
    lateinit var btn_register: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        et_first_name=findViewById(R.id.et_first_name)
        et_last_name=findViewById(R.id.et_last_name)
        et_email=findViewById(R.id.et_email)
        et_password=findViewById(R.id.et_password)
        tv_login=findViewById(R.id.tv_login)
        btn_register=findViewById(R.id.btn_register)
        already_have_an_account=findViewById(R.id.already_have_an_account)
        var firebaseAuth = FirebaseAuth.getInstance()


        btn_register.setOnClickListener{
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
                        val intent= Intent(this@RegActivity, UserProfileActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        tv_login.setOnClickListener{
            val intent=Intent(this@RegActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_register.setOnClickListener {
            val intent=Intent(this@RegActivity,UserProfileActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}