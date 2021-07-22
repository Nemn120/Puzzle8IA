package com.ia2021.puzzle8.prueba;

import com.ia2021.puzzle8.algoritmos.BusquedaDFS;
import com.ia2021.puzzle8.estados.EstadoPuzzleOcho;
import com.ia2021.puzzle8.nodos.NodoDeBusqueda;

public class PruebaPuzzle8_DFS {
    public static void main(String[] args) {
        int[] a = {0, 8, 3, 2, 1, 4, 7, 6, 5};
        EstadoPuzzleOcho tab01 = new EstadoPuzzleOcho(a);
        int[] b = {1, 2, 3, 8, 0, 4, 7, 6, 5};
        EstadoPuzzleOcho tab02 = new EstadoPuzzleOcho(b);
        int[] c = {2, 8, 3, 1, 6, 4, 7, 0, 5};
        EstadoPuzzleOcho tab03 = new EstadoPuzzleOcho(c);
//        System.out.println("Estado Inicial");
//        tab01.mostrarEstado();
//        System.out.println("");

        NodoDeBusqueda inicio = new NodoDeBusqueda(tab01);
        BusquedaDFS.buscar(inicio);
    }
}
