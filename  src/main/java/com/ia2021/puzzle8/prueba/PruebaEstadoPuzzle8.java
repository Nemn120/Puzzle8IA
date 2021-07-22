package com.ia2021.puzzle8.prueba;

import com.ia2021.puzzle8.estados.Estado;
import com.ia2021.puzzle8.estados.EstadoPuzzleOcho;

import java.util.ArrayList;

public class PruebaEstadoPuzzle8 {
    public static void main(String[] args) {
        int[] a = {7, 2, 4, 5, 0, 6, 8, 3, 1};
        EstadoPuzzleOcho tab01 = new EstadoPuzzleOcho(a);
        System.out.println("Estado");
        tab01.mostrarEstado();
        System.out.println();
//        System.out.println(tab01.getEspacio());
//        
//        int[] b = {5,0,4,6,1,8,7,3,2};
//        EstadoPuzzleOcho tab02 = new EstadoPuzzleOcho(b);
//        
//        EstadoPuzzleOcho tab03 = new EstadoPuzzleOcho(a);
//        
//        int[] c = {1,2,3,8,0,4,7,6,5};
//        EstadoPuzzleOcho tab04 = new EstadoPuzzleOcho(c);
//        
//        System.out.println(tab01.igual(tab02));
//        
//        System.out.println(tab01.igual(tab03));
//        
//        System.out.println("Es meta tab 01:"+tab01.esMeta());
//        System.out.println("Es meta tab 04:"+tab04.esMeta());
//        
//        int[] d = tab02.copiarTablero(b);
//        for (int x : d)
//            System.out.print(x + " ");
//        System.out.println("");

        System.out.println("Sucesores\n");
        ArrayList<Estado> suc = tab01.generarSucesores();
        for (Estado x : suc) {
            x.mostrarEstado();
            System.out.println();
        }

    }

}
