package com.sanabria;

import java.util.InputMismatchException;
import java.util.Scanner;

// los metodos estaticos estan ligados a la clase, no a un objeto
// porque son static no se necesita instanciar en el main, solo se llaman directamente
public class LectorDeDatos {
    public static int solicitarEntero(String mensaje){ //para no repetir la creacion de un
        // try en cada ingreso del
        // sistema, ademas que no se salga del sistema cada vez que ocurra un error
        Scanner lector= new Scanner(System.in);
        System.out.printf(mensaje);
        try{
            int numero= lector.nextInt();
            return numero;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarEntero(mensaje);
        }
    }

    public static double solicitarDouble(String mensaje){ //para no repetir la creacion de un
        // try en cada ingreso del
        // sistema, ademas que no se salga del sistema cada vez que ocurra un error
        Scanner lector= new Scanner(System.in);
        System.out.printf(mensaje);
        try{
            double numero1= lector.nextDouble();
            return numero1;
        }catch (InputMismatchException e){
            System.out.println("El dato ingresado no es valido");
            return solicitarDouble(mensaje);
        }
    }
}
