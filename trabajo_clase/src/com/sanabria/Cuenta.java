package com.sanabria;

public abstract class Cuenta {
    //una clase abstracta no se puede instanciar, solo con su clases hijos
    // retirar(double): boolean
    // depositar(double): boolean
    public int numCuenta;
    public double saldo;
    public final double SALDOMAX= 10_000_000;

    public boolean retirar(double monto){
        if((saldo - monto) <= 0){
            return false;
        }
        this.saldo -= monto;
        return true;
    }

    public boolean depositar(double monto){
        if ((saldo + monto) > SALDOMAX){
            return false;
        }
        this.saldo += monto;
        return true;
    }

}
