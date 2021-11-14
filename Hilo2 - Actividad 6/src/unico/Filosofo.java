package unico;

import java.util.Random;

public class Filosofo extends Thread{

	private Integer idFilosofo;
    private String estado;   
    private Tenedor tenedor_i;
    private Tenedor tenedor_d;
    private Portero portero;
    
    public Filosofo(Integer id, Tenedor tenedor_i, Tenedor tenedor_d, Portero portero) {
        this.idFilosofo = id;
        this.estado = "Pensando";
        this.tenedor_i = tenedor_i;
        this.tenedor_d = tenedor_d;
        this.portero = portero;
    }
    
    @Override
    public void run()  {
        while(true) {
            try {
                this.sentarse();
                this.comer();
                this.pensar();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void sentarse() throws InterruptedException {
        // Comprobamos si hay sitio en la mesa. Si lo hay, el portero nos da un pase.
        this.portero.darPase();
        this.estado = "Sentado";
        System.out.println("El filósofo " + idFilosofo + " se ha sentado.");
    }
    
    private void comer() throws InterruptedException {
        // Cogemos los tenedores, si no están libres, esperamos a que lo estén.
        this.tenedor_i.cogerTenedor(idFilosofo);
        this.tenedor_d.cogerTenedor(idFilosofo);
        
        // Una vez tenemos ambos tenedores, comemos. Tarda 3 segundos en comer.
        this.estado = "Comiendo";
        System.out.println("El filósofo " + idFilosofo + " está comiendo.");
        sleep(3000);
        
        // Soltamos los tenedores para que otro filósofo los pueda usar.
        this.tenedor_i.soltarTenedor(idFilosofo);
        this.tenedor_d.soltarTenedor(idFilosofo);
    }
    
    private void pensar() throws InterruptedException {
        // Cuando hemos comido, el portero nos saca de la mesa y libera un pase para que otro filósofo pueda pedirlo y el filósofo se queda pensando.
        this.portero.soltarPase();
        this.estado = "Pensando";
        System.out.println("El filósofo " + idFilosofo + " está pensando.");
    }
}
