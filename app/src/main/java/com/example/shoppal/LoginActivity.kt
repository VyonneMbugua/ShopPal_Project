package com.example.shoppal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.shoppal.utils.ForgotActivity
import com.example.shoppal.utils.UserProfileActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var tv_register:TextView
    lateinit var btn_login:Button
    lateinit var tv_forgot_password:TextView
    lateinit var tv_don_t_have_an_account:TextView
    lateinit var et_email:EditText
    lateinit var et_password:EditText
    lateinit var tv_signup:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        tv_register=findViewById(R.id.tv_register)
        btn_login=findViewById(R.id.btn_login)
        tv_forgot_password=findViewById(R.id.tv_forgot_password)
        et_email=findViewById(R.id.et_email)
        et_password=findViewById(R.id.et_password)
        tv_don_t_have_an_account=findViewById(R.id.tv_don_t_have_an_account)
        tv_signup=findViewById(R.id.tv_signup)
        var firebaseAuth = FirebaseAuth.getInstance()



        tv_register.setOnClickListener{
            val intent=Intent(this@LoginActivity,RegActivity::class.java)
            startActivity(intent)
        }
        tv_signup.setOnClickListener{
            val intent=Intent(this@LoginActivity,DashboardActivity::class.java)
            startActivity(intent)
        }
        btn_login.setOnClickListener{
                val Email=et_email!!.text.toString().trim()
                val Password=et_password!!.text.toString().trim()

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
                            val intent=Intent(this@LoginActivity,DashboardActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
        }

        tv_forgot_password.setOnClickListener{
            val intent=Intent(this@LoginActivity,ForgotActivity::class.java)
            startActivity(intent)
            finish()
        }
        tv_don_t_have_an_account.setOnClickListener{
                val intent=Intent(this@LoginActivity,RegActivity::class.java)
                startActivity(intent)
        }
        btn_login.setOnClickListener{
                val intent=Intent(this@LoginActivity,DashboardActivity::class.java)
                startActivity(intent)
        }




    }

}
