package com.example.win29

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getBack()
        val iv1 = findViewById<ImageView>(R.id.iv_card1)
        val iv2 = findViewById<ImageView>(R.id.iv_card2)
        val iv3 = findViewById<ImageView>(R.id.iv_card3)
        val iv4 = findViewById<ImageView>(R.id.iv_card4)
        val iv5 = findViewById<ImageView>(R.id.iv_card5)
        val iv6 = findViewById<ImageView>(R.id.iv_card6)
        val iv7 = findViewById<ImageView>(R.id.iv_card7)
        val iv8 = findViewById<ImageView>(R.id.iv_card8)
        val iv9 = findViewById<ImageView>(R.id.iv_card9)
        val iv10 = findViewById<ImageView>(R.id.iv_card10)
        val iv11 = findViewById<ImageView>(R.id.iv_card11)
        val iv12 = findViewById<ImageView>(R.id.iv_card12)
        
    }

    fun getBack(){
        val constraintMain = findViewById<ConstraintLayout>(R.id.constraint_layout_main)
        Glide.with(this)
            .load("http://49.12.202.175/win29/image.jpg")
            .into(object : SimpleTarget<Drawable?>(){
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    constraintMain.background = resource
                }

            })
    }
}