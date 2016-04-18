/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.generator;

import java.util.Comparator;

/**
 * Proceso:
 * Todos los tiempos se simularan en milisegundo.
 * @author Elizabeth
 */
public class Process extends Thread implements Comparable<Process>{
   
    // Identificador
    private String id; 
    // Nombre del proceso
    private String nombre;
    // Tamaño
    private int tamanio;
    // Tiempo de ejecución
    private int tiempo_ejecucion;
    // Prioridad
    private int prioridad;
    // Tiempo operacion de E/S
    private final int tiempo_e_s = 0;
    // Tiempo de llegada del proceso
    private int tiempo_llegada;

    public Process(String id, String nombre, int tamanio, int tiempo_ejecucion, int prioridad, int tiempo_llegada) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tiempo_ejecucion = tiempo_ejecucion;
        this.prioridad = prioridad;
        this.tiempo_llegada = tiempo_llegada;
    }
    
    public String getProcesoId() {
        return id;
    }

    public void setProcesoId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getTiempo_ejecucion() {
        return tiempo_ejecucion;
    }

    public void setTiempo_ejecucion(int tiempo_ejecucion) {
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    /*public  int getTiempo_llegada() {
        return tiempo_llegada;
    }*/

    public void setTiempo_llegada(int tiempo_llegada) {
        this.tiempo_llegada = tiempo_llegada;
    }

    @Override
    public String toString() {
        String cadena = 
                "ID: "+id+"\n"
                + "Nombre: "+nombre+"\n"
                + "Tamaño: "+tamanio+"\n"
                + "Tiempo de ejecucion: "+tiempo_ejecucion+"\n"
                + "Prioridad: "+prioridad+"\n"
                + "Tiempo de llegada: "+tiempo_llegada+"\n";
        return cadena;
    }
    
    public void run(){
        
        System.out.println(this.toString());
        
    }
    
    
    @Override
    public int compareTo(Process o) {
        
        int comparePrioridad = o.prioridad;
		if (this.prioridad > comparePrioridad) {
			return 1;
		} else if (this.prioridad == comparePrioridad) {
			return 0;
		} else {
			return -1;
		}
    }
    

}
    

