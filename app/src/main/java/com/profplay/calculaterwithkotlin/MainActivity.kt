package com.profplay.calculaterwithkotlin

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.profplay.calculaterwithkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun getCalculate(operator: Char){
        var result:String =""
        val firstNumber = binding.firstNumber.text.toString().toDoubleOrNull()
        val secondNumber = binding.secondNumber.text.toString().toDoubleOrNull()
        if (firstNumber != null && secondNumber != null){
            when(operator){
                '+' -> result = (firstNumber + secondNumber).toString()
                '-' -> result = (firstNumber - secondNumber).toString()
                '*' -> result = (firstNumber * secondNumber).toString()
                '/' -> result = (firstNumber / secondNumber).toString()
            }
        }else{ result = "Lutfen sayi giriniz" }
        binding.resultText.text = result
    }
    fun plusAction (view:View){     getCalculate('+') }
    fun minusAction (view:View){    getCalculate('-') }
    fun multipyAction (view:View){  getCalculate('*') }
    fun divideAction (view:View){   getCalculate('/') }
}