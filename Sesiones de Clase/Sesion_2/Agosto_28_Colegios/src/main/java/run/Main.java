package run;

import java.util.Scanner;
import models.Carrera;

import javax.swing.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Carrera isi = new Carrera("Ingeniería en Sistemas de Información", "001", 10000);

        //Instanciar un objeto de la clase Carrera
        Carrera nuevaCarrera = new Carrera();

        nuevaCarrera.setNombre("Ingeniería en Inteligencia Artificial");
        nuevaCarrera.setCodigo("002");
        nuevaCarrera.setPrecio(15000);

        //Imprimir el objeto creado
        System.out.println(isi);
        System.out.println(nuevaCarrera);


        JOptionPane.showMessageDialog(null, nuevaCarrera);



    }






}
