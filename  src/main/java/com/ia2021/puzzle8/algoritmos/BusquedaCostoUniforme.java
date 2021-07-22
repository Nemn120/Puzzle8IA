package com.ia2021.puzzle8.algoritmos;

import com.ia2021.puzzle8.estados.Estado;
import com.ia2021.puzzle8.estados.EstadoPuzzleOcho;
import com.ia2021.puzzle8.estructuradatos.ColaPrioridadSE;
import com.ia2021.puzzle8.nodos.NodoDeBusquedaC;

import java.util.ArrayList;
import java.util.Stack;

public class BusquedaCostoUniforme {

    public static void buscar(NodoDeBusquedaC raiz) {
        ColaPrioridadSE<NodoDeBusquedaC> cola =
                new ColaPrioridadSE<NodoDeBusquedaC>();
        cola.entrar(raiz);
        realizarBusqueda(cola);
    }

    public static void realizarBusqueda(ColaPrioridadSE<NodoDeBusquedaC> cola) {
        int contadorBusqueda = 1;

        while (!cola.estaVacia()) {
            NodoDeBusquedaC nodoTemp = cola.salir();
            System.out.println("Sale de la Cola:");
            nodoTemp.getEstadoActual().mostrarEstado();
            System.out.println();
            if (nodoTemp.getEstadoActual().esMeta()) {
                Stack<NodoDeBusquedaC> caminoSolucion =
                        new Stack<NodoDeBusquedaC>();
                caminoSolucion.push(nodoTemp);
                nodoTemp = nodoTemp.getPadre();

                while (nodoTemp != null && nodoTemp.getPadre() != null) {
                    caminoSolucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getPadre();
                }

                if (nodoTemp != null && nodoTemp.getPadre() == null)
                    caminoSolucion.push(nodoTemp);

                int iteraciones = caminoSolucion.size();

                System.out.println("Solución");
                for (int i = 0; i < iteraciones; i++) {
                    nodoTemp = caminoSolucion.pop();
                    nodoTemp.getEstadoActual().mostrarEstado();
                    System.out.println("\n");
                }
                System.out.println("Número de nodos examinados: " +
                        contadorBusqueda);
                System.exit(0);
            } else {
                //costo acumulado del padre
                double costoAcumPadre = nodoTemp.getCosto();

                ArrayList<Estado> sucesoresTemp =
                        nodoTemp.getEstadoActual().generarSucesores();

                for (int i = 0; i < sucesoresTemp.size(); i++) {
                    double costoCambio = 0;

                    costoCambio = ((EstadoPuzzleOcho) nodoTemp.getEstadoActual()).
                            costoCambio((EstadoPuzzleOcho) sucesoresTemp.get(i));

                    double costoAcumSucesor = costoAcumPadre + costoCambio;

                    NodoDeBusquedaC nuevoNodo = new NodoDeBusquedaC(nodoTemp,
                            sucesoresTemp.get(i), costoAcumSucesor);

                    if (!revisarRepetidos(nuevoNodo)) {
                        cola.entrar(nuevoNodo);
                    }
                }
            }
            contadorBusqueda++;
        }
    }

    public static boolean revisarRepetidos(NodoDeBusquedaC n) {
        boolean resultado = false;
        NodoDeBusquedaC nodoRevisado = n;
        while (n.getPadre() != null && !resultado) {
            if (n.getPadre().getEstadoActual().igual(nodoRevisado.getEstadoActual())) {
                resultado = true;
            }
            n = n.getPadre();
        }
        return resultado;
    }
}
