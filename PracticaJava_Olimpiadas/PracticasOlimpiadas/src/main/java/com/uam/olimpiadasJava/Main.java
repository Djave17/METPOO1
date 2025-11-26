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

class Convert{

    public Convert(){
    }
    public double toFarenheit(double a){


        return (a * 9/5) + 32;
    }
}

class Mayor{


    public Mayor(){
    }

    public int getMayor(){
        int[] nums = {5, 17, 2, 30, 14};
        int mayor = 0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[i] > mayor){

                mayor = nums[i];
            }

        }
        return mayor;


    }
}


class Suma {

    public Suma(){
    }


    public int getSuma(int n){
        int suma = 0;
        for(int i = 0; i <= n; i++){
            suma +=i ;
        }

        return suma;
    }

}




class Main {


    public static void main(String[] args) {

        SecuenciaCubos sec = new SecuenciaCubos();
        int[] sec1 = {3,6,12,24,48};

        System.out.println(sec.getSecuenciax2(sec1));
    }
}

