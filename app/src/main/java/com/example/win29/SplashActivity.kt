package com.example.win29

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getBack()
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    private fun getBack() {
        val constraintSplash = findViewById<ConstraintLayout>(R.id.constraintSplash)
        Glide.with(this)
            .load("http://49.12.202.175/win29/image.jpg")
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    constraintSplash.background = resource
                }
            })
    }
}