package com.example.myapplicationko

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_nullsafety.*
import java.io.Closeable
import java.io.Serializable

class NullSafety : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nullsafety)

        var a: String = "abc"  // variable
        a = "code"

        // a= null // laufzeit kann nicht passieren
        var b: String? = "abc"
        b = null
        val l = a.length
        var length: Int? = if (b != null) b.length else -1

        //length = b!!.length  // b - nullPE
        length = b?.length
        length?.compareTo(2)   // wenn

        val listWithNulls: List<String?> = listOf("hallo", null, "welt")
        val stringList : List<String>  = listWithNulls.filterNotNull()



        for (item in listWithNulls) {

            item?.let {
                // nur getreten wenn ... nicht null ist
                // textView2.append("$item.length mit länge ${item.length}")
                textView2.append("\n$it   mit länge ${it.length} \n")
            }
        }


        for (itm in stringList) {

            textView2.append("$itm mit länge ${itm.length}")


        }

        b = foo(Node("FUN", "Frank"))
        val c: Int = b?.length ?: -1
        textView2.append("\n\n $b")

       /* var int :Int? = null
        var byte:String? = int as String  // cast
        var bb:Boolean = byte is String*/


        val str = "123444L"
        val int:Int? = str as? Int   // NULL
        //val int:Int? = str.toInt()    // NullPointerException
         //val str : String="abc"
        //val int : Int = str as Int  // castExc
        //val int : Int? = str as? Int

        textView2.append(int.toString())

       /* val runner = Runnable {
            Log.d("A", "Thread läuft")
        }

        Thread(runner).start()*/




        Thread(Runnable {
            Log.d("AA", "Thread läuft")
            Thread.sleep(5000)
            Log.d("AA", "Thread läuft immer noch ")

        }).start()

        val a_num = 4
        val b_num = 10

         var arithmetics :IntArithmetics = IntArithmetics.PLUS
         Log.d("AA", "Aus dem UI Thread")
         textView2.append("$arithmetics($a_num, $b_num) =  ${arithmetics.applyAsInt(a_num, b_num)}")


         button3.setOnClickListener {
             startActivity(Intent(this, FunctionsAndMore::class.java))
         }
    }


    fun foo(node: Node): String? {

        val parent = node.parent ?: return null
        val name = node.name ?: throw IllegalArgumentException()



        return name
    }
}


interface AllOfNode



data class Node(val parent: String?, val name: String?): NodeChild(null, null) {  //

   // constructor(): this( null, null)
   // constructor(name:String): this(null, name)

}

data class Node2(val parent: String?, val name: String?, val Ort: String? = null): AllOfNode {  //

   fun fromNode(node: Node):Node2 = Node2(node.parent, node.name)

}

open class NodeChild(strasse: String?, ort: String?) :  Serializable, Closeable {
    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

/*
   class NodeChild(parent: String?, name: String?) :  Serializable, Closeable {
        override fun close() {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }*/

}



