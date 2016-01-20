package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import Paq.Personajes.Tocable;
import Paq.Paneles.Escenario;
import Paq.Paneles.Escenario.HiloMovPrsonaje;
import Paq.Paneles.PanelControles.Imagenmov;

public class Prota extends JComponent implements Tocable {
	Escenario a;// Escenario en el que juega
	int n_municion = 15;
	private JLabelProta miGrafico; // Etiqueta gráfica del coche
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	protected double destX; //
	protected double destY;
	protected String nombre; // Nombre del personaje
	protected boolean[] movimientos = new boolean[4];

	public boolean arriba = false;
	public boolean abajo = false;
	public boolean derecha = false;
	public boolean izquierda = false;
	public int vidas;//vidas
	//
	public Prota(Escenario p) {
		miGrafico = new JLabelProta();
		miGrafico.setVisible(true);
		a = p;
		// miGraficoActual.setBounds( 0, 0, TAMANYO_PERSONAJE, TAMANYO_PERSONAJE
		// );
		vidas = 5;//numero de vidas por defecto
	}
	/**
	 * @return the vidas
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * @param vidas the vidas to set
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion(double posX, double posY) {
		setPosX(posX);
		setPosY(posY);
		miGrafico.setLocation((int) posX, (int) posY);
	}

	public JLabelProta getGrafico() {
		return miGrafico;
	}

	public int getN_municion() {
		return n_municion;
	}

	public void setN_municion(int n_municion) {
		this.n_municion = n_municion;
	}

	public void setPosX(double posX) {
		if (posX - this.posX < 0) {
			// izquierda
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("ProtaIZQ.gif").toURI().toURL()));
			} catch (Exception e) {
				System.err
						.println("Error en carga de recurso: coche.png no encontrado");
				e.printStackTrace();
			}
		} else if (posX - this.posX > 0) {
			// derecha
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("ProtaDER.gif").toURI().toURL()));
			} catch (Exception e) {
				System.err
						.println("Error en carga de recurso: coche.png no encontrado");
				e.printStackTrace();
			}
		}
		this.posX = posX;
		miGrafico.setLocation((int) posX, (int) posY);
	}

	public void setPosY(double posY) {
		if (posY - this.posY < 0) {
			// arriba
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("ProtaARR.gif").toURI().toURL()));
			} catch (Exception e) {
				System.err
						.println("Error en carga de recurso: coche.png no encontrado");
				e.printStackTrace();
			}
		} else if (posY - this.posY > 0) {
			// abajo
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("ProtaABJ.gif").toURI().toURL()));
			} catch (Exception e) {
				System.err
						.println("Error en carga de recurso: coche.png no encontrado");
				e.printStackTrace();
			}
		}
		this.posY = posY;
		miGrafico.setLocation((int) posX, (int) posY);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Movimiento
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == e.VK_A) {
			movimientos[0] = true;
			arriba = false;
			abajo = false;
			derecha = false;
			izquierda = true;

		} else if (key == e.VK_D) {
			movimientos[1] = true;
			arriba = false;
			abajo = false;
			derecha = true;
			izquierda = false;
		} else if (key == e.VK_W) {
			movimientos[2] = true;
			arriba = true;
			abajo = false;
			derecha = false;
			izquierda = false;
		} else if (key == e.VK_S) {
			movimientos[3] = true;
			arriba = false;
			abajo = true;
			derecha = false;
			izquierda = false;
		} else if (key == e.VK_SPACE) {
			a. hilodeDisparo = a.new HiloDisparar();  // Sintaxis de new para clase interna
			Thread HiloDisparar = new Thread( a.hilodeDisparo );
			HiloDisparar.start();
		}

	}



	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == e.VK_A) {
			movimientos[0] = false;

		} else if (key == e.VK_D) {
			movimientos[1] = false;

		} else if (key == e.VK_W) {
			movimientos[2] = false;

		} else if (key == e.VK_S) {
			movimientos[3] = false;

		}
	}

	/**
	 * Calcula si hay choque en horizontal con los límites del mundo
	 * 
	 * @param coche
	 *            Coche cuyo choque se comprueba con su posición actual
	 * @return true si hay choque horizontal, false si no lo hay
	 */
	public boolean hayChoqueHorizontalIzquierda(Prota miProta) {
		return (miProta.getPosX() > a.panelPrincipal.getWidth() - 50
				- JLabelProta.ANCHURA_PERSONAJE / 2
				- JLabelProta.RADIO_ESFERA_PERSONAJE);
	}

	public boolean hayChoqueHorizontalDerecha(Prota miProta) {
		return (miProta.getPosX() < JLabelProta.RADIO_ESFERA_PERSONAJE + 50
				- JLabelProta.ANCHURA_PERSONAJE / 2);
	}

	/**
	 * Calcula si hay choque en vertical con los límites del mundo
	 * 
	 * @param coche
	 *            Coche cuyo choque se comprueba con su posición actual
	 * @return true si hay choque vertical, false si no lo hay
	 */
	public boolean hayChoqueVerticalAbajo(Prota miProta) {
		return (miProta.getPosY() > a.panelPrincipal.getHeight() - 50
				- JLabelProta.TAMANYO_PERSONAJE / 2
				- JLabelProta.RADIO_ESFERA_PERSONAJE);
	}

	public boolean hayChoqueVerticalArriba(Prota miProta) {
		return (miProta.getPosY() < JLabelProta.RADIO_ESFERA_PERSONAJE + 50
				- JLabelProta.TAMANYO_PERSONAJE / 2);
	}

	public double getDestX() {
		return destX;
	}

	public void setDestX(double destX) {
		this.destX = destX;
	}

	public double getDestY() {
		return destY;
	}

	public void setDestY(double destY) {
		this.destY = destY;
	}

	public boolean hayChoqueconEnemigo(Enemigo miEnemigo) {
		if (miEnemigo.getPosX() + JLabelEnemigo.RADIO_ESFERA_Enemigo > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& miEnemigo.getPosX() - JLabelEnemigo.RADIO_ESFERA_Enemigo < this
						.getPosX() + this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& miEnemigo.getPosY() + JLabelEnemigo.RADIO_ESFERA_Enemigo > this
						.getPosY() - this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& miEnemigo.getPosY() - JLabelEnemigo.RADIO_ESFERA_Enemigo < this
						.getPosY() + this.miGrafico.RADIO_ESFERA_PERSONAJE) {
			return true;

		}
		return false;
	}

	public boolean hayChoqueconMunicion(Municion miMunicion) {
		if (miMunicion.getPosX() + JLabelMunicion.RADIO_ESFERA_MUNICION > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& miMunicion.getPosX() - JLabelMunicion.RADIO_ESFERA_MUNICION < this
						.getPosX() + this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& miMunicion.getPosY() + JLabelMunicion.RADIO_ESFERA_MUNICION > this
						.getPosY() - this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& miMunicion.getPosY() - JLabelMunicion.RADIO_ESFERA_MUNICION < this
						.getPosY() + this.miGrafico.RADIO_ESFERA_PERSONAJE) {
			return true;

		}
		return false;
	}

	public boolean hayChoqueconBarril(Barril barril) {
		if (barril.getPosX() + JLabelBarril.RADIO_ESFERA_BARRIL > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& barril.getPosX() - JLabelBarril.RADIO_ESFERA_BARRIL < this
						.getPosX() + this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& barril.getPosY() + JLabelBarril.RADIO_ESFERA_BARRIL > this
						.getPosY() - this.miGrafico.RADIO_ESFERA_PERSONAJE
				&& barril.getPosY() - JLabelBarril.RADIO_ESFERA_BARRIL < this
						.getPosY() + this.miGrafico.RADIO_ESFERA_PERSONAJE) {
			return true;

		}
		return false;
	}

	public void mover() {
		if (movimientos[0]) {
			if (!hayChoqueHorizontalDerecha(this))
				destX = -10;
		}
		if (movimientos[1]) {
			if (!hayChoqueHorizontalIzquierda(this))
				destX = +10;
		}
		if (movimientos[2]) {
			if (!hayChoqueVerticalArriba(this))
				destY = -10;
		}
		if (movimientos[3]) {
			if (!hayChoqueVerticalAbajo(this))
				destY = +10;
		}

		this.setPosX(posX + destX);
		this.setPosY(posY + destY);

		for (Municion miMunicion : a.T_Municion) {
			if (hayChoqueconMunicion(miMunicion)) {
				miMunicion.getMiGrafico().setVisible(false);
				a.remove(miMunicion.getMiGrafico());
				a.T_Municion.remove(miMunicion);
				n_municion= n_municion+3;
			}
		}
		for (Enemigo miEnemigo : a.misEnemigos) {
			if (hayChoqueconEnemigo(miEnemigo)) {
				this.setPosX(posX - destX);
				this.setPosY(posY - destY);
				break;
			}
		}
		for (Barril barril : a.barriles) {
			if (hayChoqueconBarril(barril)) {
				this.setPosX(posX - destX);
				this.setPosY(posY - destY);
				break;
			}
		}

		setDestX(0);
		setDestY(0);
	}

	public void tocado() {
		// TODO Auto-generated method stub
		this.setVidas(vidas - 1);
	}
}