package com.example.ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var cnt: Int = 0
    var sign: Char = '+'
    var first: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("cnt", cnt)
    }

    fun onClickSign(view: View) {
        first = tt.text as String
        tt.text = "0"
        when ( view?.id ) {
            b_plus.id -> {
                sign = '+'
            }
            b_min.id -> {
                sign = '-'
            }
            b_mul.id -> {
                sign = '*'
            }
            b_div.id -> {
                sign = '/'
            }
        }
    }

    fun onClickCalc(view: View){
        var ff:Int = first.toInt()
        var ss1:String = tt.text as String
        var ss:Int = ss1.toInt()
        if (sign=='+'){
            ff+=ss
            tt.text = ff.toString()
        }else if (sign=='-'){
            ff-=ss
            tt.text = ff.toString()
        }else if (sign=='/'){
            if(ss==0){
                tt.text = "Math error"
            }else {
                ff /= ss
                tt.text = ff.toString()
            }
        }else if (sign=='*'){
            ff*=ss
            tt.text = ff.toString()
        }
    }

    fun onClickNumber(view: View) {
        var str: String = tt.text as String
        when ( view?.id ){
            b_del.id -> {
                str = "0"
            }
            b1.id -> {
                if (str=="0"){
                    str = "1"
                }else{
                    str+="1"
                }
            }
            b2.id -> {
                if (str=="0"){
                    str = "2"
                }else{
                    str+="2"
                }
            }
            b3.id -> {
                if (str=="0"){
                    str = "3"
                }else{
                    str+="3"
                }
            }
            b4.id -> {
                if (str=="0"){
                    str = "4"
                }else{
                    str+="4"
                }
            }
            b5.id -> {
                if (str=="0"){
                    str = "5"
                }else{
                    str+="5"
                }
            }
            b6.id -> {
                if (str=="0"){
                    str = "6"
                }else{
                    str+="6"
                }
            }
            b7.id -> {
                if (str=="0"){
                    str = "7"
                }else{
                    str+="7"
                }
            }
            b8.id -> {
                if (str=="0"){
                    str = "8"
                }else{
                    str+="8"
                }
            }
            b9.id -> {
                if (str=="0"){
                    str = "9"
                }else{
                    str+="9"
                }
            }
            b0.id -> {
                if (str!="0"){
                    str += "0"
                }
            }
        }
        tt.text = str
    }

}