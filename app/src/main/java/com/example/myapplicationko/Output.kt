package com.example.myapplicationko

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_output.*

class Output : AppCompatActivity() {

    var tmpText : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val value  = intent.getStringExtra("value")

        ausgabe.text = "Die Ausgabe von Seite 1 ist : $value, fertig ist der text"

    }

    fun clear(view: View) {

        tmpText = ausgabe.text.toString()
        ausgabe.text = ""

        val msb = Snackbar.make(constraintLayout, "Löschen Rückgängig", Snackbar.LENGTH_LONG)
        msb.setAction("UNDO", MyUndoListener())
        msb.show()
        //val x:MyUndoListener = MyUndoListener()

    }


    fun next(view: View) {

        startActivity(Intent(this, ShowLists::class.java))
    }

    inner class MyUndoListener: View.OnClickListener{
        override fun onClick(view: View?) {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            ausgabe.text = tmpText
            Toast.makeText(this@Output, "löschen wurde rückgänging gemacht", Toast.LENGTH_LONG).show()

        }

    }
}
