package com.sanabria;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // MENU, CON CUESTAS Y DEMAS, NUMEROS DE CUENTA DE MANERA ALEATORIA
    public static void main(String[] args) {
        int Numero_de_cuenta=0;

        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("\tBienvenido");
        System.out.println("*************************");

        while (true){
            System.out.println("1.  Crear una cuenta");
            System.out.println("2.  Depositar");
            System.out.println("3.  Retirar");
            System.out.println("4.  Mostrar saldo de una cuenta");
            System.out.println("5.  Mostrar cuentas");
            System.out.println("6.  Salir");

            int opcion = LectorDeDatos.solicitarEntero("Ingrese una opcion:");
            switch (opcion){
                case 1:
                    System.out.println("** Creando una cuenta **");
                    Random rand = new Random();
                    int numeroCuenta = rand.nextInt(1000);
                    System.out.println("Su numero de cuenta sera: " + numeroCuenta);
                    System.out.println("Especifique el tipo de cuenta que desea crear");
                    System.out.println("\t1.Cuenta de ahorro");
                    System.out.println("\t2.Cuenta a largo plazo");
                    int tipoCuenta = LectorDeDatos.solicitarEntero("Ingrese una opcion: ");
                    double saldo = LectorDeDatos.solicitarDouble("Ingrese el saldo inicial:");
                    if (tipoCuenta == 1){
                        CuentaAhorro nuevaCuenta = new CuentaAhorro();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada!");
                    }else if (tipoCuenta == 2){
                        CuentaLargoPlazo nuevaCuenta = new CuentaLargoPlazo();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada!");
                    }else{
                        System.out.println("Tipo de cuenta no existe");
                    }

                    break;
                case 2:
                    Numero_de_cuenta=0;
                    if(cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas--");
                    } else {
                        while(Numero_de_cuenta>-1){
                            Numero_de_cuenta= LectorDeDatos.solicitarEntero("Ingrese numero de cuenta para el deposito,pero si desea salir ingrese algun numero negativo: ");
                            if(Numero_de_cuenta>0){
                                for(Cuenta c: cuentas){
                                    if(c.numCuenta==Numero_de_cuenta){
                                        double deposito= LectorDeDatos.solicitarDouble("Ingrese el deposito: ");

                                        if(c.depositar(deposito)) {
                                            System.out.println("El nuevo saldo es: " + c.saldo);
                                        }else{
                                            System.out.println("Su saldo en su cuenta es limite");
                                        }
                                    } else if(c.numCuenta!=Numero_de_cuenta){
                                        System.out.println("La cuenta que ingreso no existe");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    Numero_de_cuenta=0;
                    if(cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas--");
                    } else {
                        while(Numero_de_cuenta>-1){
                            Numero_de_cuenta= LectorDeDatos.solicitarEntero("Ingrese numero de cuenta para el retiro,pero si desea salir ingrese algun numero negativo: ");
                            if(Numero_de_cuenta>0){
                                for(Cuenta c: cuentas){
                                    if(c.numCuenta==Numero_de_cuenta){
                                        double retiro= LectorDeDatos.solicitarDouble("Ingrese cuanto desea retirar: ");
                                        if(c.retirar(retiro)){
                                            System.out.println("El nuevo saldo es: " + c.saldo);
                                        }else{
                                            System.out.println("El monto que desea retirar es mayor al saldo que tiene en su cuenta, recuerde que se le cobra al retirar una penalizacion de 5%");
                                        }

                                    } else if(c.numCuenta!=Numero_de_cuenta){
                                        System.out.println("La cuenta que ingreso no existe");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    if(cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas--");
                    } else {
                            while(Numero_de_cuenta!=-1){
                                Numero_de_cuenta= LectorDeDatos.solicitarEntero("Ingrese numero de cuenta, si desea salir ingrese negativo uno: ");
                                if(Numero_de_cuenta!=-1){
                                    for(Cuenta c: cuentas){
                                        if(c.numCuenta==Numero_de_cuenta){
                                            System.out.println("El saldo es: " + c.saldo);
                                        } else if(c.numCuenta!=Numero_de_cuenta){
                                            System.out.println("La cuenta que ingreso no existe");
                                        }
                                    }
                                }
                            }
                        }
                    break;
                case 5:
                    if(cuentas.isEmpty()){
                        System.out.println("-- No hay cuentas--");
                    }else {
                        System.out.println("-- Mostrando cuentas--");
                    }
                    for(Cuenta c: cuentas){
                        String tipo = "";
                        // instanceof es para saber si la variable c esta
                        // instanceada ya sea en cuenta a largo plazo o corto plazo
                        if(c instanceof CuentaAhorro)
                            tipo= "Cuenta de Ahorro";
                        else if (c instanceof CuentaLargoPlazo)
                            tipo= "Cuenta a Largo Plazo";

                        System.out.println(c.numCuenta + " - " + tipo);
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 6){
                break;
            }
        }

    }

        }




