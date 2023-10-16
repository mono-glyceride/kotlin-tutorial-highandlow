package com.example.monoglyceride.highandlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.monoglyceride.highandlow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var missCount = 0
    private var gameStart = false
    private var answerd = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
