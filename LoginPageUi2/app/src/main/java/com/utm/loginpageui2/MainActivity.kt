package com.malkinfo.loginpageui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import com.utm.loginpageui2.R


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUp = findViewById<TextView>(R.id.signUp)
        val signIn = findViewById<TextView>(R.id.signIn)
        val logIn = findViewById<TextView>(R.id.logIn)
        val signUpLayout = findViewById<LinearLayout>(R.id.signUpLayout)
        val logInLayout = findViewById<LinearLayout>(R.id.logInLayout)

        signUp.setOnClickListener {
            signUp.background = resources.getDrawable(R.drawable.switch_tricks,null)
            signUp.setTextColor(resources.getColor(R.color.textcolor,null))
            logIn.background = null
            signUpLayout.visibility = View.VISIBLE
            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.pinkcolor,null))
        }
        logIn.setOnClickListener {
            signUp.background = null
            signUp.setTextColor(resources.getColor(R.color.pinkcolor,null))
            logIn.background = resources.getDrawable(R.drawable.switch_tricks,null)
            signUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            logIn.setTextColor(resources.getColor(R.color.textcolor,null))
        }
        signIn.setOnClickListener {
            startActivity(Intent(this@MainActivity,NewActivity::class.java))
        }
    }
}