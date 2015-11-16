package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import Paq.Paneles.PanelControles.Imagenmov;



public class Barril {
	
	protected Imagenmov Imagenbarril;
	protected Imagenmov miGraficoActual;
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	private boolean explotar;
	private String nombre;
	
	public static final int TAMANYO_BARRIL = 50;  // píxels (igual ancho que algo)
	public static final int RADIO_ESFERA_BARRIL = 30;  // Radio en píxels del bounding circle del coche (para choques)
	private static final boolean DIBUJAR_ESFERA_BARRIL = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	public class Imagenmov extends javax.swing.JPanel {
		
		private String nombreimagen;
	
		public Imagenmov(String nombreimagen) {
		this.setSize(150, 150); // se selecciona el tamaño del panel
		this.nombreimagen= nombreimagen;
	}

	// Se crea un método cuyo parámetro debe ser un objeto Graphics

	public void paint(Graphics grafico) {
		Dimension height = getSize();

		// Se selecciona la imagen que tenemos en el paquete de la //ruta
		// del programa

		ImageIcon Img = new ImageIcon(getClass()
				.getResource(nombreimagen));

		// se dibuja la imagen que tenemos en el paquete Images //dentro de
		// un panel

		grafico.drawImage(Img.getImage(), 0, 0, height.width,
				height.height, null);

		setOpaque(false);
		super.paintComponent(grafico);
	}
	}

	public Barril() {
		Imagenbarril = new Imagenmov("barril.png");
		Imagenbarril.setSize(40,40 );
		miGraficoActual= Imagenbarril;
		miGraficoActual.setVisible(true);
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
	}
	
	public void setPosX( double posX ) {
		miGraficoActual= Imagenbarril;
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		miGraficoActual= Imagenbarril;
		this.posY = posY;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Imagenmov getGraficoActual() {
		return miGraficoActual;
	}

	private boolean explosion() {
		// terminar metodo explotar cuando tengamos "metodo disparar"
		
		return true;
		
	}


}
