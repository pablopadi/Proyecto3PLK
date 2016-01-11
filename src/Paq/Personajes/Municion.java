package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import Paq.Paneles.Escenario;


public class Municion extends ObjetosJuego {
	
	private JLabelMunicion miGrafico;
	private String nombre;
	private Escenario a;
	

	public Municion(Escenario p, double posX, double posY){
		super(posX,posY);
		miGrafico = new JLabelMunicion();
		try {
			miGrafico.setIcon( new ImageIcon( JLabelProta.class.getResource( "municion.gif" ).toURI().toURL() ) );
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
	
		this.posX= posX; 
	}
	
	public void setPosY( double posY ) {
		
		this.posY= posY;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public JLabelMunicion getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelMunicion miGrafico) {
		this.miGrafico = miGrafico;
	}
	
	}


