package com.example.animator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_animation3.*


//通過 AnimatorSet 我們可以同時或接連著做幾個動畫，常用的幾個方法有 .with / .before / .after / .playTogether

class Animation3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation3)
        setupView()
    }

    private fun setupView() {
        title = "AnimatorSet"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        button1.setOnClickListener(button1ClickHandler)
        button2.setOnClickListener(button2ClickHandler)

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

    // play animation one by one
    private val button1ClickHandler = View.OnClickListener { view ->
        //繼承自 ValueAnimator 的 ObjectAnimator
        val animator1 = ObjectAnimator.ofFloat(donImageView1,"translationY",0f, -800f, 0f)
        val animator2 = ObjectAnimator.ofFloat(donImageView2,"translationY",0f, 800f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.duration = 600
        animatorSet.play(animator1).after(animator2)
        animatorSet.start()
    }

    // play animation at same time
    private val button2ClickHandler = View.OnClickListener { view ->
        //繼承自 ValueAnimator 的 ObjectAnimator
        val animator1 = ObjectAnimator.ofFloat(donImageView1,"translationY",0f, -800f, 0f)
        val animator2 = ObjectAnimator.ofFloat(donImageView2,"translationY",0f, 800f, 0f)

        val animatorSet = AnimatorSet()
        animatorSet.duration = 600
        animatorSet.playTogether(animator1, animator2)
        animatorSet.start()
    }
}