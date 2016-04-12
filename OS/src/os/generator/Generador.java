/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.generator;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Generador de Procesos.
 * @author AElizabeth
 */
public class Generador {
    
    private Scanner teclado;
    private int num_procesos;
    private LinkedList<Process> lista_procesos = new LinkedList<>();
            
    public void captura() {
        teclado = new Scanner(System.in);
        System.out.print("Ingresa el numero de procesos: ");
        num_procesos = teclado.nextInt();
        
        int i;
        for (i=0; i<num_procesos;i++){
            System.out.println("Generando proceso "+i);
            Process p = generar_proceso();
            agregar_proceso(p);
        }
        
    }

    public Process generar_proceso(){
        teclado.nextLine();
        String id;
        System.out.println("Ingresar el ID del proceso: ");
        id = teclado.nextLine();
         
        //Compara que los ID no sean iguales
        while (seRepiteID(id)) { 
            System.out.println("El ID ya está en uso...");
            System.out.println("Ingresar otro ID");
            id = teclado.nextLine();
        }
        
        String nombre;
        System.out.println("Ingresar el nombre del proceso: ");
        nombre = teclado.nextLine();
        
        int tamanio;
        System.out.println("Ingresar el tamaño del proceso: ");
        tamanio = teclado.nextInt();
        
        int tiempo_ejecucion;
        System.out.println("Ingresar el tiempo de ejecucion del proceso: ");
        tiempo_ejecucion = teclado.nextInt();
        
        int prioridad;
        System.out.println("Ingresar la prioridad del proceso: ");
        prioridad = teclado.nextInt();
        
        int tiempo_llegada;
        System.out.println("Ingresar el tiempo de llegada del proceso: ");
        tiempo_llegada= teclado.nextInt();
        
        Process proceso = new Process(id, nombre, tamanio, tiempo_ejecucion, prioridad, tiempo_llegada);
        return proceso;
    }
    
    public void agregar_proceso(Process process){
        lista_procesos.add(process);
    }
    
    
    public void mostrarCola(){
        for (int i = 0; i < num_procesos; i++) {
            System.out.println(lista_procesos.get(i));
        }
    }
    
    public boolean seRepiteID(String id){
        for (int i = 0; i < lista_procesos.size(); i++) {
            if(id.equals(lista_procesos.get(i).getProcesoId())){
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de procesos:
     * @return Lista de Procesos
     */
    public LinkedList<Process> getLista_procesos() {
        return lista_procesos;
    }
    
}
