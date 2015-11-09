package Paq.Hilos;

public class HiloJuego extends Thread {

	// Fundamental poner. Variable que dice si el hilo esta activo o no
	boolean activo = true;
	// El tiempo que tarda en volver a ejecutarse el run
	long tick = 1000;

	// Constructor del hilo
	public HiloJuego() {

	}

	public void parar() {
		activo = false;
	}

	// Lo que va ejecutar cada vez que se lance el hilo
	public void run() {
		while (activo) {
			try {
				// Que espere un segundo antes de ejecutarse
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			// Lo que quiero que haga el hilo

		}
	}

}
