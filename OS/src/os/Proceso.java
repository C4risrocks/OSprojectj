/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.util.Scanner;

/**
 *
 * @author christiandejmorenomarin
 */
public class Proceso extends Thread {

    private int[] T;
    private float[] P;
    private int[] lleg;
    private int[] co;
    private int[] p;
    private int[] vuelta;
    private int[] E;
    private int[] procesos_originales;
    private int tamar;
    private int ttrabajo = 0;
    private int total = 0;
    private float tiempo_espera, tiempo_ida;
    private Scanner teclado;

    public void fcfs() {
        teclado = new Scanner(System.in);
        System.out.print("Ingresa el numero de procesos: ");
        tamar = teclado.nextInt();
        float P[] = new float[tamar];
        int E[] = new int[tamar];
        int p[] = new int[tamar];
        int co[] = new int[tamar];
        int es[] = new int[tamar];
        int vuelta[] = new int[tamar];
        int lleg[] = new int[tamar];
        int T[] = new int[tamar];
        for (int i = 0; i < tamar; i++) {

            System.out.print("introduza el tamanio " + "del proceso [" + (i + 1) + "] : ");
            co[i] = p[i] = teclado.nextInt();
            System.out.print("Introduzca el tiempo de llegada del proceso [" + (i + 1) + "] : ");
            lleg[i] = teclado.nextInt();
        }

        for (int i = 0; i < p.length; i++) {

            System.out.print("\nP[" + (i + 1) + "] : " + p[i] + "\t");

        }
        vuelta[0] = 0;

        for (int i = 1; i < tamar; i++) {
            vuelta[i] = vuelta[i - 1] + co[i - 1];
            total = total + vuelta[i];
        }
        for (int i = 0; i < p.length; i++) {
            es[i] = vuelta[i] + co[i];
            tiempo_espera += vuelta[i];
            tiempo_ida += es[i];

        }
        for (int i = 0; i < tamar; i++) {
            T[i] = es[i] - lleg[i];
            ttrabajo += T[i];
        }

        for (int i = 0; i < tamar; i++) {
            P[i] = T[i] / p[i];

        }
        for (int i = 0; i < tamar; i++) {
            E[i] = T[i] - p[i];
        }

        System.out.print("\nProceso\tllegada\tt\tInicio\tFin\tT\tE\tP");
        for (int i = 0; i < p.length; i++) {
            System.out.print("\np[" + (i + 1) + "] \t   " + lleg[i] + "\t  " + co[i] + "\t   " + vuelta[i] + "\t" + es[i] + "\t" + T[i] + "\t" + E[i] + "\t" + P[i]);
        }
        System.out.println();
        System.out.print("" + (tiempo_espera / tamar));
        System.out.print("" + (tiempo_ida / tamar));

    }

    @Override
    public void run() {
        this.fcfs();
    }

    
    
    public static void main(String[] args) {

        Proceso fifo = new Proceso();
        //fifo.fcfs();
        fifo.start();
    }

}
