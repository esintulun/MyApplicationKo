package com.example.myapplicationko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_show_lists.*

class ShowLists : AppCompatActivity() {

    val numbers = intArrayOf(1,2,3,4,5,6,7)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_lists)

        //aRRAY ANLEGEn
        val numbers = intArrayOf(1,2,3,4,5,6,7)
        val numbers2 = arrayOf<Int>(1,2,3,4,5)
        val values = arrayOf(1,2,3,4,5)
        val number3 = IntArray(10) {i ->  -1}  // -1 initialize
        val number4 = IntArray(5) {i ->  1*10}  // -1 initialize
        val twoDimArray = Array(10, { IntArray(10, {it + 1})}) // it keyword

        this.numbers
        val zahl1 = 123
        val zahl2 = 234

        val max = if(zahl1 > zahl2) zahl1 else zahl2


        for (array in twoDimArray) {
            for((indexa, ia ) in array.withIndex()){
                //textView.append( i.toString() + "\t")
                textView.append("$indexa : $ia ")
            }
            textView.append("\n")
        }

       // numbers.get(0)
       // numbers[0]

        button2.setOnClickListener {


            startActivity(Intent(this@ShowLists, NullSafety::class.java))
        }

        for(i in numbers2.size-1 downTo 0 step 2)
            textView.append(" : $i ")

        textView.append("\n")
        for(i in 2..100 step 2)
            textView.append(" : $i ")

        checkValue(1)

        checkValue("Hallo")


    }

    fun maxValue(zah1 : Int, zahl2: Int) = if(zah1 > zahl2 ) zah1 else zahl2


    fun maxValueJ(zah1 : Int, zahl2: Int):Int {
        return if(zah1 > zahl2 ){
            zah1
        }

        else {
            zahl2
        }


    }


    fun checkValue(zahl:Any){  // beliebiges
   // fun checkValue(zahl:Int){

        when(zahl) {

            0->textView.append("Wert ist Eins")
            in 1..17 -> textView.append("Jünger als 18")
            18, 19,20 ->textView.append("wert ist 18, 19, 20")
            "Hallo" -> textView.append("text ist hallo ")
            !in 0..100 -> textView.append("gröser als 100 ")
            else->textView.append("Wert ist Eins")// Default
        }

    }


}
