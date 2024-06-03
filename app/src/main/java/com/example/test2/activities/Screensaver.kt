package com.example.test2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.test2.R


class Screensaver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.screensaver)

        // автоматический переход на другую страницу, через 3 секунды
        supportActionBar?.hide()
        Handler().postDelayed(
            {
                val intent = Intent(this@Screensaver, MainMenu::class.java)
                startActivity(intent)
            },
            1000
        )
    }
}