package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import Paq.Paneles.Escenario;
import Paq.Paneles.PanelControles.Imagenmov;



public class Bala {
private JLabelBala miGrafico;
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	//private boolean explotar;
	private String nombre;
	Escenario a;
	public int vida=30;
	public Bala(Escenario p, String q){
		miGrafico = new JLabelBala();
		try {
			miGrafico.setIcon( new ImageIcon( JLabelBala.class.getResource( q ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		miGrafico.setVisible(true);
		a = p;
		
	}
	
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	
	public void setPosX( double posX ) {
		
		this.posX = posX; 
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	
	public void setPosY( double posY ) {
	
		this.posY = posY;
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public JLabelBala getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelBala miGrafico) {
		this.miGrafico = miGrafico;
	}
	public boolean hayChoqueconEnemigo(Enemigo miEnemigo) {
		if (miEnemigo.getPosX() + JLabelEnemigo.RADIO_ESFERA_Enemigo > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_BALA
				&& miEnemigo.getPosX() - JLabelEnemigo.RADIO_ESFERA_Enemigo < this
						.getPosX() + this.miGrafico.RADIO_ESFERA_BALA
				&& miEnemigo.getPosY() + JLabelEnemigo.RADIO_ESFERA_Enemigo > this
						.getPosY() - this.miGrafico.RADIO_ESFERA_BALA
				&& miEnemigo.getPosY() - JLabelEnemigo.RADIO_ESFERA_Enemigo < this
						.getPosY() + this.miGrafico.RADIO_ESFERA_BALA) {
			return true;

		}
		return false;
	}

	public boolean hayChoqueconBarril(Barril miBarril) {
		if (miBarril.getPosX() + JLabelBarril.RADIO_ESFERA_BARRIL > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_BALA
				&& miBarril.getPosX() - JLabelBarril.RADIO_ESFERA_BARRIL < this
						.getPosX() + this.miGrafico.RADIO_ESFERA_BALA
				&& miBarril.getPosY() + JLabelBarril.RADIO_ESFERA_BARRIL > this
						.getPosY() - this.miGrafico.RADIO_ESFERA_BALA
				&& miBarril.getPosY() - JLabelBarril.RADIO_ESFERA_BARRIL < this
						.getPosY() + this.miGrafico.RADIO_ESFERA_BALA) {
			return true;

		}
		return false;
	}
	public void lanzamiento_disparo_abajo(Escenario a){
		while (vida > 0) {
			setPosicion(posX, posY+ 5);
			getMiGrafico().repaint(); 
			try {
				Thread.sleep( 30 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Enemigo otroEnemigo : a.misEnemigos) {
				if ((this.hayChoqueconEnemigo(otroEnemigo))) {
					otroEnemigo.tocado();
					vida = 0;
					break;
				}
			}
			if (vida > 0) {
				for (Barril barril1 : a.barriles) {
					if ((this.hayChoqueconBarril(barril1))) {
						barril1.tocado();
						vida = 0;
						break;
					}
				}
			}
			vida--;
		}
		a.panelPrincipal.remove(this.getMiGrafico());
	}
	public void lanzamiento_disparo_arriba(Escenario a){
		while (vida > 0) {
			setPosicion(posX, posY- 5);
			getMiGrafico().repaint(); 
			try {
				Thread.sleep( 30 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Enemigo otroEnemigo : a.misEnemigos) {
				if ((this.hayChoqueconEnemigo(otroEnemigo))) {
					otroEnemigo.tocado();
					vida = 0;
					break;
				}
			}
			if (vida > 0) {
				for (Barril barril1 : a.barriles) {
					if ((this.hayChoqueconBarril(barril1))) {
						barril1.tocado();
						vida = 0;
						break;
					}
				}
			}
			vida--;
		}
		a.panelPrincipal.remove(this.getMiGrafico());
	}
	public void lanzamiento_disparo_derecha(Escenario a){
		while (vida > 0) {
			setPosicion(posX+5, posY);
			getMiGrafico().repaint(); 
			try {
				Thread.sleep( 30 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Enemigo otroEnemigo : a.misEnemigos) {
				if ((this.hayChoqueconEnemigo(otroEnemigo))) {
					otroEnemigo.tocado();
					vida = 0;
					break;
				}
			}
			if (vida > 0) {
				for (Barril barril1 : a.barriles) {
					if ((this.hayChoqueconBarril(barril1))) {
						barril1.tocado();
						vida = 0;
						break;
					}
				}
			}
			vida--;
		}
		a.panelPrincipal.remove(this.getMiGrafico());
	}
	public void lanzamiento_disparo_izquierda(Escenario a){
		while (vida > 0) {
			setPosicion(posX-5, posY);
			getMiGrafico().repaint(); 
			try {
				Thread.sleep( 30 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Enemigo otroEnemigo : a.misEnemigos) {
				if ((this.hayChoqueconEnemigo(otroEnemigo))) {
					otroEnemigo.tocado();
					vida = 0;
					break;
				}
			}
			if ((vida > 0)) {
				for (Barril barril1 : a.barriles) {
					if ((this.hayChoqueconBarril(barril1))) {
						barril1.tocado();
						a.panelPrincipal.remove(this.getMiGrafico());
						break;
					}
				}
			}
			vida--;
		}
		
			a.panelPrincipal.remove(this.getMiGrafico());
		
	}
}
