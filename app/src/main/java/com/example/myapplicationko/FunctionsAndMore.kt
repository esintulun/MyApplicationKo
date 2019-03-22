package com.example.myapplicationko

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_function_more.*

class FunctionsAndMore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function_more)

        var j = 2
        j uper(3)  // geht es nicht ohne infix
        val h = (j uper 3) + 7  // geht es nicht ohne infix

     /*   val srt1:String = "A"
        val srt2:String = "A"
        val srt3:String = srt2*/

        val srt1:Node = Node("esin", "tulun")
        val srt2:Node = Node("esin", "tulun")
        val srt3:Node = srt2


        val node1 : AllOfNode = Node2("esin", "tulun")


        if(node1 is Node2 )  // instanceOf

            textView4.append("node1 ist ein NodeChild")

        j.uper(3)
        textView4.append(j.toString() + " " + j.uper(3))
        textView4.append("\n" + (srt1 == srt2)  +  "" + (srt3 == srt2))  // inhalte
        textView4.append("\n" + (srt1 === srt2)  +  "" + (srt3 === srt2))  // referenze
        textView4.append("\n" + (srt1.equals(srt2) ) +  "" + (srt3.equals(srt2)))  // referenze



    }

    infix fun Int.uper(i:Int):Int {
        return this*i
    }



}