package unico;

public class Tenedor {

	private Integer idTenedor;
    private Boolean disponible;
   
    public Tenedor(Integer id) {
        this.idTenedor = id;
        this.disponible  = true;
    }
    
    public synchronized void cogerTenedor(Integer idFilosofo) throws InterruptedException {
        // Si el tenedor no está disponible, esperamos a que lo esté.
        while(!this.disponible) {
            wait();
        }
        // Una vez está disponible, se lo asignamos al filósofo y lo ponemos no disponible.
        this.disponible = false;
        System.out.println("El filósofo " + idFilosofo + " ha cogido el tenedor " + this.idTenedor + ".");
    }
    
    public synchronized void soltarTenedor(Integer idFilosofo) {
        // Cuando el filósofo termina de comer, ponemos el tenedor en disponible para que lo pueda utilizar otro filósofo.
        this.disponible = true;
        // Y notificamos a los que están esperando que ya está disponible.
        notify();
        System.out.println("El filósofo " + idFilosofo + " ha cogido el tenedor " + this.idTenedor + ".");
    }
}
