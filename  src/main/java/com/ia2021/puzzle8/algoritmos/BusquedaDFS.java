package com.ia2021.puzzle8.algoritmos;

import com.ia2021.puzzle8.estados.Estado;
import com.ia2021.puzzle8.nodos.NodoDeBusqueda;

import java.util.ArrayList;
import java.util.Stack;

public class BusquedaDFS {
    public static void buscar(NodoDeBusqueda raiz) {
        Stack<NodoDeBusqueda> cola =
                new Stack<NodoDeBusqueda>();
        cola.push(raiz);
        realizarBusqueda(cola);
    }

    public static void realizarBusqueda(Stack<NodoDeBusqueda> cola) {
        int contadorBusqueda = 1;

        while (!cola.isEmpty()) {
            NodoDeBusqueda nodoTemp = cola.pop();
            System.out.println("Sale de la Cola:");
            nodoTemp.getEstadoActual().mostrarEstado();
            System.out.println();
            if (nodoTemp.getEstadoActual().esMeta()) {
                Stack<NodoDeBusqueda> caminoSolucion =
                        new Stack<NodoDeBusqueda>();
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
                ArrayList<Estado> sucesoresTemp =
                        nodoTemp.getEstadoActual().generarSucesores();
                for (int i = sucesoresTemp.size() - 1; i >= 0; i--) {
                    NodoDeBusqueda nuevoNodo = new NodoDeBusqueda(nodoTemp,
                            sucesoresTemp.get(i));
                    if (!revisarRepetidos(nuevoNodo)) {
                        cola.push(nuevoNodo);
                    }
                }
            }
            contadorBusqueda++;
        }
    }

    public static boolean revisarRepetidos(NodoDeBusqueda n) {
        boolean resultado = false;
        NodoDeBusqueda nodoRevisado = n;
        while (n.getPadre() != null && !resultado) {
            if (n.getPadre().getEstadoActual().igual(nodoRevisado.getEstadoActual())) {
                resultado = true;
            }
            n = n.getPadre();
        }
        return resultado;
    }

}
