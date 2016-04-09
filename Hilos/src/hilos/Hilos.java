/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author christiandejmorenomarin
 */
public class Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        SaludoSleep S1 = new SaludoSleep (100);
        SaludoSleep S2 = new SaludoSleep (2000);
        SaludoSleep S3 = new SaludoSleep (4000);
        
        S1.start();
        S2.start();
        S3.start();
        
        System.out.println("Termina el hilo principal");
    }
    
}
