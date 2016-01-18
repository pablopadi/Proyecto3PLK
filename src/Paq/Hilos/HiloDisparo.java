package Paq.Hilos;

import Paq.Personajes.JLabelProta;
import Paq.Personajes.Prota;

public class HiloDisparo extends Thread {
	JLabelProta miGrafico;
	int x;
	int y;
	// Fundamental poner. Variable que dice si el hilo esta activo o no
	boolean activo = true;
	// El tiempo que tarda en volver a ejecutarse el run
	long tick = 1000;

	// Constructor del hilo
	public HiloDisparo(Prota p) {
		this.x= p.getX();
		this.y=p.getY();
		miGrafico=p.getGrafico();
	}

	public void parar() {
		activo = false;
	}

	// Lo que va ejecutar cada vez que se lance el hilo
	public void run() {
			try {
				if(miGrafico.equals("ProtaABJ.gif")){
					
				}else if(miGrafico.equals("ProtaARR.gif")){
					
				}else if(miGrafico.equals("ProtaDER.gif")){
					
				}else if(miGrafico.equals("ProtaIZQ.gif")){
					
				}
			} catch (Exception e) {
			}

			// Lo que quiero que haga el hilo
			
		
	}

}