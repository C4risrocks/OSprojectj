/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.generator;

/**
 * Main
 * @author Elizabeth
 */
public class Main {
    public static void main(String[] args) {
       Generador generador = new Generador();
       generador.captura();
       generador.mostrarCola();
       Planificador planificador = new Planificador();
       //planificador.prioridadCompartida(generador);
       //planificador.mostrarCola();
       
       planificador.checkMemorySpace(generador, 2048);
       
       
    }
}
