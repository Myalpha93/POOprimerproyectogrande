package com.sanabria;

public class CuentaAhorro extends Cuenta {
    public final double SALDOMINIMOBONO= 50_000;
    public final double INTERES_BONO=.01;

    public boolean depositar(double monto){
        if(monto > SALDOMINIMOBONO){
            monto += (monto*INTERES_BONO);
        }
        return super.depositar(monto);
    }
}
