package com.example.animator

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_animation2.*

class Animation2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation2)

        setupView()
    }

    private fun setupView() {
        title = "ObjectAnimator"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        button6.setOnClickListener(goButtonClickHandler)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

    }

    private val goButtonClickHandler = View.OnClickListener { view ->

//        為了不通過對 ValueAnimator 進行監聽來實現動畫，後來增加了一個繼承自 ValueAnimator 的 ObjectAnimator 類
//        只需要幾行代碼就能實現 donImageView 針對 Y 軸的旋轉。

        val animator = ObjectAnimator.ofFloat(donImageView, "rotationY", 0.0f, 360.0f)
        animator.duration = 600
        animator.start()

    }

}