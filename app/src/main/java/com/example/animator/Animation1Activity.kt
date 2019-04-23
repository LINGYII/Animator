package com.example.animator

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_animation1.*

class Animation1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation1)

        setupView()
    }

    private fun setupView() {
        title = "ValueAnimator"
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
        //針對 ValueAnimator 加入監聽，將變化的數值拿來對控件做操控
//        ValueAnimator 有支持 ofFloat ofInt 等不同參數的方法，並且支持連續參數
//        比如下面的例子，就是先從 0f 到 -800f 然後再到 -0f 的動畫過程
        val animator = ValueAnimator.ofFloat(0f, -800f, 0f)
        animator.duration = 600

        animator.addUpdateListener { valueAnimator ->
            //針對 ValueAnimator 加入監聽，將變化的數值拿來對控件做操控
            val value = valueAnimator?.animatedValue as Float
            donImageView.translationY = value
        }

        animator.start()
    }

}