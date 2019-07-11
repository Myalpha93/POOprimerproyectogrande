package com.sanabria;

public class CuentaLargoPlazo extends Cuenta {
    public final double PENALTY_RETIRO = .05;

    public boolean retirar(double monto){
        monto += (monto* PENALTY_RETIRO);
        return super.retirar(monto);
    }
}
