package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import Paq.Paneles.Escenario;
import Paq.Paneles.PanelControles.Imagenmov;



public class Barril extends ObjetosJuego {
	
	private JLabelBarril miGrafico;
	private boolean explotar;
	private String nombre;
	Escenario a;
	public Barril(Escenario p, double posX, double posY){
		super(posX,posY);
		miGrafico = new JLabelBarril();
		try {
			miGrafico.setIcon( new ImageIcon( JLabelProta.class.getResource( "barril.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		miGrafico.setVisible(true);
		a = p;
		
	}
	

	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	
	public void setPosX( double posX ) {
		
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
	
		this.posY = posY;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public JLabelBarril getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelBarril miGrafico) {
		this.miGrafico = miGrafico;
	}

	private boolean explosion() {
		// terminar metodo explotar cuando tengamos "metodo disparar"
		
		return true;
		
	}


}
