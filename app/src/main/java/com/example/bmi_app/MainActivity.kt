package com.example.bmi_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var weightet :EditText
    lateinit var heightet :EditText
    lateinit var submitbt :Button
    lateinit var result :TextView
    lateinit var indicator :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weightet =findViewById(R.id.edit_wt)
        heightet =findViewById(R.id.edit_ht)
        submitbt =findViewById(R.id.btn_submit)
        indicator =findViewById(R.id.pic_indicator)
        result =findViewById(R.id.result_view)
        submitbt.setOnClickListener {v ->
           bmiResult()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
    fun bmiResult(){
        val weight =weightet.text.toString().toFloat()
        val height = heightet.text.toString().toFloat()
        val myBmi = weight /(height*height)
        result.text = myBmi.toString()
        if (myBmi<18.5){
            indicator.setImageResource(R.drawable.ic_underweight)

        }else if (myBmi >= 18.5 && myBmi < 24.9){
            indicator.setImageResource(R.drawable.ic_healthy)
        }else if (myBmi >= 24.9 && myBmi < 29.9){
            indicator.setImageResource(R.drawable.ic_overweight)
        }
        else{
            indicator.setImageResource(R.drawable.ic_obesity)
        }

    }

}