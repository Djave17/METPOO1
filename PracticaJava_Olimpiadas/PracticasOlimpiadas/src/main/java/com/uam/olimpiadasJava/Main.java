package com.uam.olimpiadasJava;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class SecuenciaCubos{

    //3,6,12,24,48,?

    private int[] sec;


    public int getSecuenciax2(int[] sec){

        int ultimo = sec[sec.length -1];
        int next = ultimo * 2;
        return next;



    }

    public SecuenciaCubos(){

    }

}

class Main {


    public static void main(String[] args) {

        SecuenciaCubos sec = new SecuenciaCubos();
        int[] sec1 = {3,6,12,24,48};

        System.out.println(sec.getSecuenciax2(sec1));
    }
}