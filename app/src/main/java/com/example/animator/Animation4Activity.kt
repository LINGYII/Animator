package com.example.animator

import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_animation4.*

//Interpolator 用來修飾動畫的執行效果。
//這裡有一系列繼承自 BaseInterpolator 的加速器。
//https://developer.android.com/reference/android/view/animation/Interpolator.html
//只需要給 animator 指定 Interpolator 的實例就可以了。


class Animation4Activity : AppCompatActivity() {

    private lateinit var animator:ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation4)
        setupView()
    }

    private fun setupView() {
        title = "AnimatorSet"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //繼承自 ValueAnimator 的 ObjectAnimator
        animator = ObjectAnimator.ofFloat(donImageView, "translationX", 0f, 600f, 0f)
        animator.duration = 1500

        // set Listener
        button1.setOnClickListener(button1ClickHandler)
        button2.setOnClickListener(button2ClickHandler)
        button3.setOnClickListener(button3ClickHandler)
        button4.setOnClickListener(button4ClickHandler)
        button5.setOnClickListener(button5ClickHandler)
        button6.setOnClickListener(button6ClickHandler)
        button7.setOnClickListener(button7ClickHandler)
        button8.setOnClickListener(button8ClickHandler)
        button9.setOnClickListener(button9ClickHandler)

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

    //只需要給 animator 指定 Interpolator 的實例就可以了。
    private val button1ClickHandler = View.OnClickListener { view ->
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()

        if (view.tag == R.id.button1) {
            println("點了 button 1")
        }
    }


    private val button2ClickHandler = View.OnClickListener { view ->
        animator.interpolator = AnticipateOvershootInterpolator()
        animator.start()

        if (view.tag == R.id.button2) {
            println("點了 button 1")
        }
    }

    private val button3ClickHandler = View.OnClickListener { view ->
        animator.interpolator = BounceInterpolator()
        animator.start()
    }

    private val button4ClickHandler = View.OnClickListener { view ->
        animator.interpolator = OvershootInterpolator()
        animator.start()
    }

    private val button5ClickHandler = View.OnClickListener { view ->
        animator.interpolator = AccelerateInterpolator()
        animator.start()
    }

    private val button6ClickHandler = View.OnClickListener { view ->
        animator.interpolator = LinearInterpolator()
        animator.start()
    }

    private val button7ClickHandler = View.OnClickListener { view ->
        animator.interpolator = AnticipateInterpolator()
        animator.start()
    }

    private val button8ClickHandler = View.OnClickListener { view ->
        animator.interpolator = DecelerateInterpolator()
        animator.start()
    }

    private val button9ClickHandler = View.OnClickListener { view ->
        animator.interpolator = CycleInterpolator(2.0f)
        animator.start()
    }
}