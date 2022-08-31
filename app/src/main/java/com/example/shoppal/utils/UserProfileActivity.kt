package com.example.shoppal.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.shoppal.R

class UserProfileActivity : AppCompatActivity() {

    lateinit var et_first_name:EditText
    lateinit var et_last_name:EditText
    lateinit var et_email:EditText
    lateinit var et_mobile_number:EditText
    lateinit var btn_submit:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        et_first_name=findViewById(R.id.et_first_name)
        et_last_name=findViewById(R.id.et_last_name)
        et_email=findViewById(R.id.et_email)
        et_mobile_number=findViewById(R.id.et_mobile_number)
        btn_submit=findViewById(R.id.btn_submit)



    }
}