package com.example.monoglyceride.highandlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hitBtn.setOnClickListener{
            if ((gameStart && !answerd)){
                highAndLow('h')
            }
        }
        binding.lowBtn.setOnClickListener{
            if ((gameStart && !answerd)){
                highAndLow('l')
            }
        }
        binding.nextBtn.setOnClickListener {
            if(gameStart){
                drawCard()
            }
        }
    }

    private fun highAndLow(answer:Char){
        showDroidCard()
        answerd = true
        val balance = droidCard - yourCard
        if(balance == 0){
            // when even do nothing
        } else if((balance > 0 && answer == 'h')){
            hitCount++
            binding.hitText.text = getString(R.string.hit_text) + hitCount
        } else if((balance < 0 && answer == 'l')){
            hitCount++
            binding.hitText.text = getString(R.string.hit_text) + hitCount
        } else {
            missCount++
            binding.missText.text = getString(R.string.miss_text) + missCount
        }
        if (hitCount == 5){
            binding.resultText.text = getString(R.string.win_text)
            gameStart = false
        } else if (missCount == 5){
            binding.resultText.text = getString(R.string.lose_text)
            gameStart = false
        } else {
            // do nothing
        }
    }
    private fun showDroidCard(){
        when(droidCard){
            1 -> binding.droidCardImage.setImageResource(R.drawable.s1)
            2 -> binding.droidCardImage.setImageResource(R.drawable.s2)
            3 -> binding.droidCardImage.setImageResource(R.drawable.s3)
            4 -> binding.droidCardImage.setImageResource(R.drawable.s4)
            5 -> binding.droidCardImage.setImageResource(R.drawable.s5)
            6 -> binding.droidCardImage.setImageResource(R.drawable.s6)
            7 -> binding.droidCardImage.setImageResource(R.drawable.s7)
            8 -> binding.droidCardImage.setImageResource(R.drawable.s8)
            9 -> binding.droidCardImage.setImageResource(R.drawable.s9)
            10 -> binding.droidCardImage.setImageResource(R.drawable.s10)
            11 -> binding.droidCardImage.setImageResource(R.drawable.s11)
            12 -> binding.droidCardImage.setImageResource(R.drawable.s12)
            13 -> binding.droidCardImage.setImageResource(R.drawable.s13)
        }
    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        missCount = 0
        binding.hitText.text = getString(R.string.hit_text)
        binding.missText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard()
    }

    private fun drawCard() {
        binding.youtCardImage.setImageResource(R.drawable.trannpu)
        binding.droidCardImage.setImageResource(R.drawable.trannpu_black)

        // IntRange.random()で乱数を生成
        yourCard = (1..13).random()
        Log.d(tag, "You:" + yourCard)
        when(yourCard){
            1 -> binding.youtCardImage.setImageResource(R.drawable.d1)
            2 -> binding.youtCardImage.setImageResource(R.drawable.d2)
            3 -> binding.youtCardImage.setImageResource(R.drawable.d3)
            4 -> binding.youtCardImage.setImageResource(R.drawable.d4)
            5 -> binding.youtCardImage.setImageResource(R.drawable.d5)
            6 -> binding.youtCardImage.setImageResource(R.drawable.d6)
            7 -> binding.youtCardImage.setImageResource(R.drawable.d7)
            8 -> binding.youtCardImage.setImageResource(R.drawable.d8)
            9 -> binding.youtCardImage.setImageResource(R.drawable.d9)
            10 -> binding.youtCardImage.setImageResource(R.drawable.d10)
            11 -> binding.youtCardImage.setImageResource(R.drawable.d11)
            12 -> binding.youtCardImage.setImageResource(R.drawable.d12)
            13 -> binding.youtCardImage.setImageResource(R.drawable.d13)
        }
        droidCard = (1..13).random()
        Log.d(tag, "droid:"+droidCard)
        answerd = false
    }
}
