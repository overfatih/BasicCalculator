package com.profplay.basiccalculatorwithkotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.profplay.basiccalculatorwithkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }    
    fun toplaAction(view: View) { islem('+') }
    fun carpAction(view: View)  { islem('x') }
    fun cikarAction(view: View) { islem('-') }
    fun bolAction(view: View)   { islem('/') }
    fun islem(char: Char) {
        var valid: Array<Any> = validateNumber()
        var result: Double = 0.0
        if(valid[2].toString().toBoolean()){
            when(char){
                '+'-> result = valid[0].toString().toDouble() + valid[1].toString().toDouble()
                '-'-> result = valid[0].toString().toDouble() - valid[1].toString().toDouble()
                'x'-> result = valid[0].toString().toDouble() * valid[1].toString().toDouble()
                '/'-> result = valid[0].toString().toDouble() / valid[1].toString().toDouble()
            }
            binding.resultText.text=result.toString()
        }
    }
    fun validateNumber(): Array<Any> {
        var result :Array<Any> = arrayOf(1,1,false)
        var num1 = binding.number1EditText.text.toString().toIntOrNull()
        var num2 = binding.number2EditText.text.toString().toIntOrNull()
        if(num1 != null && num2 != null) {
            result = arrayOf(num1!!, num2!!, true)
        } else{
            binding.resultText.text= "Hata: Lütfen sayı giriniz"
        }
        binding.validateView.text=result[2].toString()
        return result
    }
}
