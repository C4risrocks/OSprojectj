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


class SaludoSleep extends Thread{
    
    private int tiempo;
    public SaludoSleep(int t){
        tiempo = t;
        
    }
    
    public void run(){
    System.out.println("Soy el hilo " + getName());
    try{
        sleep(tiempo);
    }catch(InterruptedException e){}
    System.out.println("Soy " + getName() + "despues de dormir: " + tiempo);
    }

}


