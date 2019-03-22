package com.example.myapplicationko;

public class JavaActivity  {

    Person person = new Person("esin", "tulun", "Schuelter.", "Hamburg","12122", 58, 23);
    PersonKo personKo = new PersonKo("esin", "tulun", "Schuelter.", "Hamburg","12122", 58, 23, true);


    public String doit(){

       return personKo.toString();
    }

}
