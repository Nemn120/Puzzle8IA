package com.ia2021.puzzle8.nodos;

import com.ia2021.puzzle8.estados.Estado;

/*

 */
public class NodoDeBusquedaC implements Comparable<NodoDeBusquedaC> {

    private final Estado estadoActual;
    private final NodoDeBusquedaC padre;
    private final double costo; //costo acumulado del nodo

    /**
     * Constructor para la raíz NodoDeBusqueda
     *
     * @param e el estado pasado
     */
    public NodoDeBusquedaC(Estado e) {
        estadoActual = e;
        padre = null;
        costo = 0.0;
    }

    /**
     * Constructor para todos los otros NodoDeBusqueda
     *
     * @param padre el nodo padre
     * @param e     el estado
     */
    public NodoDeBusquedaC(NodoDeBusquedaC padre, Estado e, double c) {
        this.padre = padre;
        estadoActual = e;
        costo = c;
    }

    /**
     * @return el estadoActual
     */
    public Estado getEstadoActual() {
        return estadoActual;
    }

    /**
     * @return el padre
     */
    public NodoDeBusquedaC getPadre() {
        return padre;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public int compareTo(NodoDeBusquedaC otro) {
        if (this.getCosto() > otro.getCosto()) return 1;
        else if (this.getCosto() < otro.getCosto()) return -1;
        else return 0;
    }
}
