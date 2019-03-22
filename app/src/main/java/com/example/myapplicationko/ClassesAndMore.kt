package com.example.myapplicationko

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

private val name_global:String = "Hallo"

val name_for_all : String= "welt"
internal val name_for_all_in_Modul : String= "hallo welt"  // auch modul ebene sichtbar


//protected val name2:String = "Hallo"   nicht ok


enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {


    // funktion besitzen, Interface implementieren
    PLUS {
        override fun apply(t: Int, u: Int): Int = t+u

    },
    MINUS {
        override fun apply(t: Int, u: Int): Int = t-u
    },

    MAL {
        override fun apply(t: Int, u: Int): Int = t*u
    },

    GETEILT {

        override fun apply(t: Int, u: Int): Int = t / u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)




}



interface MyInterface{

    val prop1:Int

    get() = 11
    val prop2:Int

    fun bar() {
        print("A")
    }
    fun foo()
}

interface MyInterface2{

    val prop1:Int
       // get() = 110
    val prop2:Int

    fun bar() {
        print("A")
    }
    fun foo() {
        print("BB")
    }
}

class Parent1: MyInterface, MyInterface2 {







    protected val name2:String = "Hallo"   // eine ebene tiefe

    override fun bar(){

        super<MyInterface>.bar()
    }

    override val prop1: Int=29
    override val prop2: Int= 12

    var prop3: Int=1
         get() = field
         set(value) { field = value }


    override fun foo() {
        super<MyInterface>.prop1 + prop1


    }

}

open class A{

   open fun doIt(value : String = "Default String ") {
        print(value)
    }


    fun setParams(str:String, b1:Boolean=true, b2:Boolean=true, b3:Boolean=true, b4:Boolean=true, str2:String="" ){}

}

class B  : A(){

    override fun doIt(value : String) {
        print(value + "... ")

        A().doIt()

        A().setParams("hallo", b2 = false, str2 = "aaa")
    }

}