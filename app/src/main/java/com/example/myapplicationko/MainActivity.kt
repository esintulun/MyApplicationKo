package com.example.myapplicationko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setText("Hello Kotlin  - > JUST FOR FUN !")
        val p = Person("esin", "tulun", "Schuelter.", "Hamburg","12122", 58, 23);


        //tv.append("\n" + p.alter)
        val p2 = PersonKo("esin", "tulun", "Schuelter.", "Hamburg","12122", 58, 23, true);

       // val p3 = p2.copy()
        tv.append("\n" + p2.strasse)
        tv.append("\n" + JavaActivity().doit())
    }

    fun send(view : View) {

        val intent = Intent(this, Output::class.java)
        intent.putExtra("value", tv.text.toString())
        test()
        startActivity(intent)

    }
}

fun test(){

    print("Hallo")
}
