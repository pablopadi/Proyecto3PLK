package Paq.Personajes;

import Paq.Personajes.Objetos.Imagenmov;

public class Barril extends Objetos{
	
	private boolean explotar;

	public Barril(String nombre,Imagenmov nombreimagen,boolean explotar) {
		super(nombre, nombreimagen);
		Imagenmov Imagencontrolsmov = new Imagenmov("barril.png");
		Imagencontrolsmov.setSize(420/3,420/3 );
	}
	
	
	private boolean explosion() {
		// terminar metodo explotar cuando tengamos "metodo disparar"
		//allahu akbar
		return true;
		
	}


}
