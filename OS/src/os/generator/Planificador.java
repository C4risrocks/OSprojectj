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
    private LinkedList<Process> colaListaExec = new LinkedList<>();
    private LinkedList<Process> countCola = new LinkedList<>();
    
    
    public void roundRobin(Generador g){
        
        colaListaExec = g.getLista_procesos();
        
    }
    
    public void prioridadCompartida(Generador g){
        int i = 0;
        
        Collections.sort(g.getLista_procesos(), Collections.reverseOrder());
        colaListaExec = g.getLista_procesos();
        
        //for(int i = 0; i <)
    }
    
    
    public  void mostrarColaExec(){
        for (int i = 0; i < colaListaExec.size(); i++) {
            System.out.println(colaListaExec.get(i));
        }
    }
    
    public void checkMemorySpace(Generador g,int tm){
        
        int tamanioMemoria = tm;
        countCola = g.getLista_procesos();
        //int ;
        
        while(g.getLista_procesos().isEmpty()){
            
            for (int i = 0; i < g.getLista_procesos().size(); i++){
                if (g.getLista_procesos().get(i).getTamanio() <= tamanioMemoria){
                    
                    colaListaExec.add(g.getLista_procesos().get(i));
                    tamanioMemoria -= g.getLista_procesos().get(i).getTamanio();
                    countCola.removeFirst();
                    
                    
                }
                else{
                    
                    break;
                }
            }
            
        }
        
        
        
        
    }
    
}
