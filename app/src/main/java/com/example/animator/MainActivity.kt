package com.example.animator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

//ValueAnimator - 實現動畫
//ObjectAnimator - 實作動畫
//AnimatorSet - 實現組合動畫

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = MainAdapter { position:Int ->
            tapHandler(position)
        }

    }

    private fun tapHandler(position:Int) {
        when(position){
            0 -> {
                val intent = Intent(this, Animation1Activity::class.java)
                startActivity(intent)
            }

            1 -> {
                val intent = Intent(this, Animation2Activity::class.java)
                startActivity(intent)
            }

            2 -> {
                val intent = Intent(this, Animation3Activity::class.java)
                startActivity(intent)
            }

            3 -> {
                val intent = Intent(this, Animation4Activity::class.java)
                startActivity(intent)
            }


        }
    }

}