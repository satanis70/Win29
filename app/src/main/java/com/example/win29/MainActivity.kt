package com.example.win29

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {

    val list = ArrayList<String>()
    val listIv = ArrayList<ImageView>()
    var currentImage: String = ""
    private var currentIv: ImageView? = null
    var wasClicked = false
    val app_id = "714b9f14-381d-4fc4-a93c-28d480557381"
    val questionMark = "http://49.12.202.175/win29/questionmark.png"
    private lateinit var iv1: ImageView
    private lateinit var iv2: ImageView
    private lateinit var iv3: ImageView
    private lateinit var iv4: ImageView
    private lateinit var iv5: ImageView
    private lateinit var iv6: ImageView
    private lateinit var iv7: ImageView
    private lateinit var iv8: ImageView
    private lateinit var iv9: ImageView
    private lateinit var iv10: ImageView
    private lateinit var iv11: ImageView
    private lateinit var iv12: ImageView
    lateinit var buttonAgain: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getBack()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(app_id)
        iv1 = findViewById(R.id.iv_card1)
        iv2 = findViewById(R.id.iv_card2)
        iv3 = findViewById(R.id.iv_card3)
        iv4 = findViewById(R.id.iv_card4)
        iv5 = findViewById(R.id.iv_card5)
        iv6 = findViewById(R.id.iv_card6)
        iv7 = findViewById(R.id.iv_card7)
        iv8 = findViewById(R.id.iv_card8)
        iv9 = findViewById(R.id.iv_card9)
        iv10 = findViewById(R.id.iv_card10)
        iv11 = findViewById(R.id.iv_card11)
        iv12 = findViewById(R.id.iv_card12)
        listIv.add(iv1)
        listIv.add(iv2)
        listIv.add(iv3)
        listIv.add(iv4)
        listIv.add(iv5)
        listIv.add(iv6)
        listIv.add(iv7)
        listIv.add(iv8)
        listIv.add(iv9)
        listIv.add(iv10)
        listIv.add(iv11)
        listIv.add(iv12)
        for (i in listIv) {
            getImage(questionMark, i)
        }
        list.add("http://49.12.202.175/win29/watermelon.png")
        list.add("http://49.12.202.175/win29/plum.png")
        list.add("http://49.12.202.175/win29/lemon.png")
        list.add("http://49.12.202.175/win29/cherries.png")
        list.add("http://49.12.202.175/win29/bell.png")
        list.add("http://49.12.202.175/win29/apple.png")
        list.add("http://49.12.202.175/win29/watermelon.png")
        list.add("http://49.12.202.175/win29/plum.png")
        list.add("http://49.12.202.175/win29/lemon.png")
        list.add("http://49.12.202.175/win29/cherries.png")
        list.add("http://49.12.202.175/win29/bell.png")
        list.add("http://49.12.202.175/win29/apple.png")
        list.shuffle()
        onClickManager(iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12)
        buttonAgain = findViewById<Button>(R.id.button_again)
        buttonAgain.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun checkWin() {
        if (iv1.visibility == View.INVISIBLE &&
            iv2.visibility == View.INVISIBLE &&
            iv3.visibility == View.INVISIBLE &&
            iv4.visibility == View.INVISIBLE &&
            iv5.visibility == View.INVISIBLE &&
            iv6.visibility == View.INVISIBLE &&
            iv7.visibility == View.INVISIBLE &&
            iv8.visibility == View.INVISIBLE &&
            iv9.visibility == View.INVISIBLE &&
            iv10.visibility == View.INVISIBLE &&
            iv11.visibility == View.INVISIBLE &&
            iv12.visibility == View.INVISIBLE
        ) {
            findViewById<TextView>(R.id.textView_cong).visibility = View.VISIBLE
            buttonAgain.visibility = View.VISIBLE
        }
    }

    private fun onClickManager(
        iv1: ImageView,
        iv2: ImageView,
        iv3: ImageView,
        iv4: ImageView,
        iv5: ImageView,
        iv6: ImageView,
        iv7: ImageView,
        iv8: ImageView,
        iv9: ImageView,
        iv10: ImageView,
        iv11: ImageView,
        iv12: ImageView
    ) {
        iv1.setOnClickListener {
            getImage(list[0], listIv[0])
            Handler().postDelayed({
                if (!wasClicked) {
                    currentIv = iv1
                    currentImage = list[0]
                    wasClicked = true
                } else {
                    getImage(list[0], listIv[0])
                    if (currentImage == list[0]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv1.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, iv1)
                        getImage(questionMark, currentIv!!)
                        wasClicked = false
                    }
                }
            }, 1000)
        }
        iv2.setOnClickListener {
            getImage(list[1], listIv[1])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[1]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv2.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv2)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv2
                    getImage(list[1], listIv[1])
                    currentImage = list[1]
                    wasClicked = true
                }
            }, 1000)
        }
        iv3.setOnClickListener {
            getImage(list[2], listIv[2])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[2]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv3.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv3)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv3
                    getImage(list[2], listIv[2])
                    currentImage = list[2]
                    wasClicked = true
                }
            }, 1000)
        }
        iv4.setOnClickListener {
            getImage(list[3], listIv[3])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[3]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv4.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv4)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv4
                    getImage(list[3], listIv[3])
                    currentImage = list[3]
                    wasClicked = true
                }
            }, 1000)
        }
        iv5.setOnClickListener {
            getImage(list[4], listIv[4])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[4]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv5.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv5)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv5
                    getImage(list[4], listIv[4])
                    currentImage = list[4]
                    wasClicked = true
                }
            }, 1000)
        }
        iv6.setOnClickListener {
            getImage(list[5], listIv[5])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[5]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv6.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv6)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv6
                    getImage(list[5], listIv[5])
                    currentImage = list[5]
                    wasClicked = true
                }
            }, 1000)
        }
        iv7.setOnClickListener {
            getImage(list[6], listIv[6])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[6]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv7.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv7)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv7
                    getImage(list[6], listIv[6])
                    currentImage = list[6]
                    wasClicked = true
                }
            }, 1000)
        }
        iv8.setOnClickListener {
            getImage(list[7], listIv[7])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[7]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv8.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv8)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv8
                    getImage(list[7], listIv[7])
                    currentImage = list[7]
                    wasClicked = true
                }
            }, 1000)
        }
        iv9.setOnClickListener {
            getImage(list[8], listIv[8])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[8]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv9.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv9)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv9
                    getImage(list[8], listIv[8])
                    currentImage = list[8]
                    wasClicked = true
                }
            }, 1000)
        }
        iv10.setOnClickListener {
            getImage(list[9], listIv[9])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[9]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv10.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv10)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv10
                    getImage(list[9], listIv[9])
                    currentImage = list[9]
                    wasClicked = true
                }
            }, 1000)
        }
        iv11.setOnClickListener {
            getImage(list[10], listIv[10])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[10]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv11.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv11)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv11
                    getImage(list[10], listIv[10])
                    currentImage = list[10]
                    wasClicked = true
                }
            }, 1000)
        }
        iv12.setOnClickListener {
            getImage(list[11], listIv[11])
            Handler().postDelayed({
                if (wasClicked) {
                    if (currentImage == list[11]) {
                        currentIv?.visibility = View.INVISIBLE
                        iv12.visibility = View.INVISIBLE
                        currentIv = null
                        wasClicked = false
                        checkWin()
                    } else {
                        getImage(questionMark, currentIv!!)
                        getImage(questionMark, iv12)
                        wasClicked = false
                    }
                } else {
                    currentIv = iv12
                    getImage(list[11], listIv[11])
                    currentImage = list[11]
                    wasClicked = true
                }
            }, 1000)
        }
    }

    private fun getBack() {
        val constraintMain = findViewById<ConstraintLayout>(R.id.constraint_layout_main)
        Glide.with(this)
            .load("http://49.12.202.175/win29/image.jpg")
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    constraintMain.background = resource
                }
            })
    }

    private fun getImage(url: String, imageView: ImageView) {
        Glide.with(this)
            .load(url)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    imageView.setImageDrawable(resource)
                }
            })
    }
}
