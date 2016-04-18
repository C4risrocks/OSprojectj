/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.generator;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author christiandejmorenomarin
 */
public class Planificador {

    //private LinkedList<Process> colaPListos = new LinkedList<>();
    // Cola de lista de procesos en ejecución
    private LinkedList<Process> colaListaExec = new LinkedList<>();
    
    // Cola de la lista de procesos
    private LinkedList<Process> processQueue = new LinkedList<>(); 

    public void roundRobin(Generador g) {

        colaListaExec = g.getLista_procesos();

    }

    public void prioridadCompartida(Generador g) {
        int i = 0;

        Collections.sort(g.getLista_procesos(), Collections.reverseOrder());
        colaListaExec = g.getLista_procesos();

        //for(int i = 0; i <)
    }

    public void mostrarColaExec() {
        for (int i = 0; i < colaListaExec.size(); i++) {
            System.out.println(colaListaExec.get(i));
        }
    }

    /**
     * Verifica si el espacio en memoria soporta los procesos en la cola de
     * Procesos.
     * @param g Generador
     * @param tamanioMemoria El tamaño de la memoria del Planificador
     * @return 
     */
    public boolean checkMemorySpace(Generador g, int tamanioMemoria) {
        System.out.println("Check Memory Space");
        System.out.println("Tamaño de la memoria: "+tamanioMemoria);
        processQueue = g.getLista_procesos();
        boolean memory, process;
        memory = process = true;
        while(process && memory){
            for (Process p : processQueue) {
                if(p.getTamanio()<=tamanioMemoria){
                    tamanioMemoria -= p.getTamanio();
                    System.out.println("Tamaño de la memoria: "+tamanioMemoria);
                }else{
                    System.out.println("No hay suficiente espacio en memoria");
                    return false;
                }
            }
            process = false;
        }
        return true;
    }

}
