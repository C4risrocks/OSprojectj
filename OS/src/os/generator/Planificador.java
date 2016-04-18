/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.generator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

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

    public void roundRobin(Generador g,int tamanioMemoria, int quantum) {
        // Verificar el espacio en memoria
        checkMemorySpace(g,tamanioMemoria);
        int tiempo_restante;
        System.out.println("Ejecutando Round Robin\n");
        
        ListIterator<Process> iterator = (ListIterator<Process>) colaListaExec.iterator();
        while (iterator.hasNext()) {
            Process process = iterator.next();
            System.out.println("Tiempo ejecucion: "+process.getTiempo_ejecucion());
            //System.out.println("RESTANTE: "+ (process.getTiempo_ejecucion()- quantum) );
            // Verificar que tamaño del processo - quantum
            int i;
            for (i = process.getTiempo_ejecucion(); i > (process.getTiempo_ejecucion()-quantum); i--) {
                //System.out.println("i = "+i);
                System.out.println("["+process.getProcesoId()+"] en ejecución "+(i-1)+" ms");
            }
            process.setTiempo_ejecucion(i);
            //System.out.println("Proceso tiempo restante "+process.getTiempo_ejecucion());
            if(process.getTiempo_ejecucion()!=0){
                iterator.remove();
                //colaListaExec.add(process);
                iterator.add(process);
                System.out.println("Proceso <"+ process.getProcesoId()+ "> agregado a la cola");
                mostrarColaExec();
            }else{
                iterator.remove();
                System.out.println("["+process.getProcesoId()+"] "+process.getName()+ " Proceso Terminado");
                mostrarColaExec();
            }   
        }
    }

    public void prioridadCompartida(Generador g) {
        int i = 0;

        Collections.sort(g.getLista_procesos(), Collections.reverseOrder());
        colaListaExec = g.getLista_procesos();

        //for(int i = 0; i <)
    }

    public void mostrarColaExec() {
        System.out.println("\nMostrando cola de ejecución... \n");
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
                    // Agregamos a la cola de procesos de ejecucion
                    colaListaExec.add(p); 
                }else{
                    System.out.println("No hay suficiente espacio en memoria");
                    return false;
                }

}
