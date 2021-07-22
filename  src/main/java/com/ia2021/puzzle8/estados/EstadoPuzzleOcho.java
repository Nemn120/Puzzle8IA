package com.ia2021.puzzle8.estados;

import java.util.ArrayList;
import java.util.Arrays;

public class EstadoPuzzleOcho implements Estado {
    private final int TAM_PUZZLE = 9;
    private final int[] META = {1, 2, 3, 8, 0, 4, 7, 6, 5};
    private final int[] tableroActual;

    public EstadoPuzzleOcho(int[] tablero) {
        this.tableroActual = tablero;
    }

    private int[] getTableroActual() {
        return tableroActual;
    }

    private int getEspacio() {
        int indiceEspacio = -1;

        for (int i = 0; i < TAM_PUZZLE; i++) {
            if (tableroActual[i] == 0)
                indiceEspacio = i;
        }
        return indiceEspacio;
    }

    @Override
    public boolean esMeta() {
        return Arrays.equals(tableroActual, META);
    }

    @Override
    public boolean igual(Estado e) {
        return Arrays.equals(tableroActual, ((EstadoPuzzleOcho) e).getTableroActual());
    }

    @Override
    public void mostrarEstado() {
        System.out.println(tableroActual[0] + " | " + tableroActual[1] + " | " +
                tableroActual[2]);
        System.out.println(tableroActual[3] + " | " + tableroActual[4] + " | " +
                tableroActual[5]);
        System.out.println(tableroActual[6] + " | " + tableroActual[7] + " | " +
                tableroActual[8]);
    }

    /*
     * Hace una copia del arreglo pasado a este
     */
    private int[] copiarTablero(int[] estado) {
        int[] resultado = new int[TAM_PUZZLE];
        for (int i = 0; i < TAM_PUZZLE; i++) {
            resultado[i] = estado[i];
        }
        return resultado;
    }

    /*
     * Cambia los datos en los índices d1 y d2, en una copia del tablero
     * actual y crea un nuevo estado basado en este nuevo tablero y lo
     * agrega a s.
     */
    private void intercambiarYGuardar(int d1, int d2, ArrayList<Estado> suc) {
        int[] copiaMod = copiarTablero(tableroActual);
        int temp = copiaMod[d1];
        copiaMod[d1] = tableroActual[d2];
        copiaMod[d2] = temp;
        suc.add((new EstadoPuzzleOcho(copiaMod)));
    }

    public double costoCambio(EstadoPuzzleOcho otro) {
        double costoCambio = Math.abs(this.getEspacio() - otro.getEspacio());
        return costoCambio;
    }

    @Override
    public ArrayList<Estado> generarSucesores() {
        ArrayList<Estado> sucesores = new ArrayList<Estado>();

        //Operadores:
        //1) Mover espacio a la izquierda
        //2) Mover espacio a la derecha
        //3) Mover espacio arriba
        //4) Mover espacio abajo

        int espacio = getEspacio();

        // mover el espacio a la izquierda
        if (espacio != 0 && espacio != 3 && espacio != 6) {
            intercambiarYGuardar(espacio - 1, espacio, sucesores);
        }

        //mover espacio a la derecha
        if (espacio != 2 && espacio != 5 && espacio != 8) {
            intercambiarYGuardar(espacio + 1, espacio, sucesores);
        }

        //mover espacio hacia arriba
        if (espacio != 0 && espacio != 1 && espacio != 2) {
            intercambiarYGuardar(espacio - 3, espacio, sucesores);
        }

        //mover espacio hacia abajo
        if (espacio != 6 && espacio != 7 && espacio != 8) {
            intercambiarYGuardar(espacio + 3, espacio, sucesores);
        }
        return sucesores;
    }

}
