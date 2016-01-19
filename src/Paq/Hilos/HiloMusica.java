package Paq.Hilos;

import java.io.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


import sun.audio.*;
import Paq.Paneles.Escenario;


public class HiloMusica extends Thread {
	String cancion;
	// Fundamental poner. Variable que dice si el hilo esta activo o no
	boolean activo = true;
	// El tiempo que tarda en volver a ejecutarse el run
	long tick = 1000;

	// Constructor del hilo
	public HiloMusica( String cancion) {
	this.cancion= cancion;
	}

	public void parar() {
		activo = false;
	}

	// Lo que va ejecutar cada vez que se lance el hilo
	public void run() {
				try {
					FileInputStream fis= new FileInputStream(cancion);
					BufferedInputStream bis = new BufferedInputStream(fis);
					Player player = new Player(bis);
					player.play();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			// Lo que quiero que haga el hilo
			
			
	
	}
}