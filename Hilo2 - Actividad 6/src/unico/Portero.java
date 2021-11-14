package unico;

import java.util.Random;

public class Portero {

private Integer pases;
    
    public Portero(Integer pases){
        this.pases = pases;
    }
    
    public synchronized void darPase() throws InterruptedException {
        // Si no hay pases libres esperamos hasta que los haya.
        while (this.pases==0) {
            wait();
        }
        // Cuando hay pases, reducimos el número de pases libres.
        this.pases--;
    }
    
    public synchronized void soltarPase() throws InterruptedException {
        // Cuando ya ha comido el filósofo, libera el pase y notifica al portero para que lo ponga libre. 
        this.pases++;
        notify();
    }

}
