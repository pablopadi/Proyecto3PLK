package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import Paq.Paneles.Escenario;
import Paq.Paneles.PanelControles.Imagenmov;

public class Prota extends JComponent {
	Escenario a;// Escenario en el que juega

	private JLabelProta miGrafico; // Etiqueta gráfica del coche
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	protected double destX; //
	protected double destY;
	protected String nombre; // Nombre del personaje

	public static final int TAMANYO_PERSONAJE = 100; // píxels (igual ancho que
														// algo)
	public static final int RADIO_ESFERA_PERSONAJE = 35; // Radio en píxels del
															// bounding circle
															// del coche (para
															// choques)
	private static final boolean DIBUJAR_ESFERA_PERSONAJE = true; // Dibujado
																	// (para
																	// depuración)
																	// del
																	// bounding
																	// circle de
																	// choque
																	// del coche

	//
	public Prota(Escenario p) {
		miGrafico = new JLabelProta();
		miGrafico.setVisible(true);
		a = p;
		// miGraficoActual.setBounds( 0, 0, TAMANYO_PERSONAJE, TAMANYO_PERSONAJE
		// );

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

	public void setPosX(double posX) {
		if (posX - this.posX < 0) {
			// izquierda
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("error.png").toURI().toURL()));
			} catch (Exception e) {
				System.err
						.println("Error en carga de recurso: coche.png no encontrado");
				e.printStackTrace();
			}
		} else if (posX - this.posX > 0) {
			// derecha
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("error.png").toURI().toURL()));
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
						.getResource("prototipo.png").toURI().toURL()));
			} catch (Exception e) {
				System.err
						.println("Error en carga de recurso: coche.png no encontrado");
				e.printStackTrace();
			}
		} else if (posY - this.posY > 0) {
			// abajo
			try {
				miGrafico.setIcon(new ImageIcon(JLabelProta.class
						.getResource("barril.png").toURI().toURL()));
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
		if (key == e.VK_LEFT) {
			if (hayChoqueHorizontalDerecha(this) == false) {
				destX = -10;
				mover();
			}
		} else if (key == e.VK_RIGHT) {
			if (hayChoqueHorizontalIzquierda(this) == false) {
				destX = 10;
				mover();
			}
		} else if (key == e.VK_UP) {
			if (hayChoqueVerticalArriba(this) == false) {
				destY = -10;
				mover();
			}
		} else if (key == e.VK_DOWN) {
			if (hayChoqueVerticalAbajo(this) == false)
				destY = 10;
			{
				mover();
			}
		}
		setDestX(0);
		setDestY(0);
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

	public void mover() {
		if ((!hayChoqueVerticalAbajo(this)) || (!hayChoqueVerticalArriba(this))
				|| (!hayChoqueHorizontalDerecha(this))
				|| (!hayChoqueHorizontalIzquierda(this))) {
			this.setPosX(posX + destX);
			this.setPosY(posY + destY);
			for (Enemigo miEnemigo : a.misEnemigos) {
				if (hayChoqueconEnemigo(miEnemigo)) {
						this.setPosX(posX - destX);
						this.setPosY(posY - destY);
						break;
				}
			}

		}
	}
}