package com.ia2021.puzzle8.prueba;

import com.ia2021.puzzle8.algoritmos.BusquedaDFS;
import com.ia2021.puzzle8.algoritmos.BusquedaDFSLimitada;
import com.ia2021.puzzle8.estados.EstadoPuzzleOcho;
import com.ia2021.puzzle8.estructuradatos.ColaPrioridadSE;
import com.ia2021.puzzle8.nodos.NodoDeBusqueda;
import com.ia2021.puzzle8.nodos.NodoDeBusquedaLimitada;

public class PruebaDFSLimitada {
    public static void main(String[] args) {

		int[] a = {0, 8, 3, 2, 1, 4, 7, 6, 5};
		EstadoPuzzleOcho tab01 = new EstadoPuzzleOcho(a);
		int[] b = {1, 2, 3, 8, 0, 4, 7, 6, 5};//meta
		EstadoPuzzleOcho tab02 = new EstadoPuzzleOcho(b);
		int[] c = {2, 8, 3, 1, 6, 4, 7, 0, 5};
		EstadoPuzzleOcho tab03 = new EstadoPuzzleOcho(c);
		int[] d = {2, 8, 3, 1, 0, 4, 7, 5, 6};
		EstadoPuzzleOcho tab04 = new EstadoPuzzleOcho(d);

		NodoDeBusquedaLimitada inicio = new NodoDeBusquedaLimitada(tab01);
		BusquedaDFSLimitada.buscar(inicio,true,3);//6


		//META:	{1, 2, 3, 8, 0, 4, 7, 6, 5};
    }
  
}
