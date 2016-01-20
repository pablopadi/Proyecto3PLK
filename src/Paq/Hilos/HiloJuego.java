package Paq.Hilos;

import Paq.Paneles.Escenario;
import Paq.Paneles.Menu;

public class HiloJuego extends Thread {
	Menu a;
	// Fundamental poner. Variable que dice si el hilo esta activo o no
	boolean activo = true;
	// El tiempo que tarda en volver a ejecutarse el run
	long tick = 1000;

	// Constructor del hilo
	public HiloJuego(Menu a) {
		this.a =a;
	}

	public void parar() {
		activo = false;
	}

	// Lo que va ejecutar cada vez que se lance el hilo
	public void run() {
		try {
			Escenario.main(a);

			// Que espere un segundo antes de ejecutarse
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		// Lo que quiero que haga el hilo


	}

}
