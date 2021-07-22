package com.ia2021.puzzle8.prueba;

import com.ia2021.puzzle8.algoritmos.BusquedaCostoUniforme;
import com.ia2021.puzzle8.estados.EstadoPuzzleOcho;
import com.ia2021.puzzle8.nodos.NodoDeBusquedaC;

public class PruebaPuzzle8_CosUni {
    public static void main(String[] args) {
        int[] a = {0, 8, 3, 2, 1, 4, 7, 6, 5};
        EstadoPuzzleOcho tab01 = new EstadoPuzzleOcho(a);
        int[] b = {1, 2, 3, 8, 0, 4, 7, 6, 5};
        EstadoPuzzleOcho tab02 = new EstadoPuzzleOcho(b);
        int[] c = {2, 8, 3, 1, 6, 4, 7, 0, 5};
        EstadoPuzzleOcho tab03 = new EstadoPuzzleOcho(c);

        NodoDeBusquedaC inicio = new NodoDeBusquedaC(tab03);
        BusquedaCostoUniforme.buscar(inicio);
    }
}
