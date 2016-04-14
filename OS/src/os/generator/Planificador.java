/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.generator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


/**
 *
 * @author christiandejmorenomarin
 */
public class Planificador {
    
    private LinkedList<Process> colaPListos = new LinkedList<>();
    private LinkedList<Process> colaListaExec = new LinkedList<>();
    
    public void roundRobin(Generador g){
        
        colaPListos = g.getLista_procesos();
        
    }
    
    public void prioridadCompartida(Generador g){
        
        colaPListos = g.getLista_procesos();
        Collections.sort(colaPListos);
        
        
    }
    
    
    public  void mostrarCola(){
        for (int i = 0; i < colaPListos.size(); i++) {
            System.out.println(colaPListos.get(i));
        }
    }
    
    public static void checkMemorySpace(){
        
        int tamanioMemoria;
        
        
        
    }
    
}
