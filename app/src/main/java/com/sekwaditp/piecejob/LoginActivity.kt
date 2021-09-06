package com.sekwaditp.piecejob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun login(v: View?){
        val toMain = Intent(this,MainActivity::class.java)
        startActivity(toMain)
        finish()
    }
}