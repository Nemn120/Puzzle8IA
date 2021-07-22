package com.ia2021.puzzle8.prueba;

import com.ia2021.puzzle8.estructuradatos.ColaPrioridadSE;

public class PruebaColaPrioridad {

    public static void main(String[] args) {
        ColaPrioridadSE<Integer> cola = new ColaPrioridadSE<Integer>();
        cola.entrar(15);
        cola.entrar(7);
        cola.entrar(30);
        for (Integer x : cola) {
            System.out.println(x);
        }
    }
}
