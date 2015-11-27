package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;



public class Enemigo {
	protected Imagenmov miGraficoActual;
	protected Imagenmov ImagenPersonajeUP;
	protected Imagenmov ImagenPersonajeDOWN;
	protected Imagenmov ImagenPersonajeDERECHA;
	protected Imagenmov ImagenPersonajeIZQUIERDA;
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)

//Metodo de imagen
	public static final int TAMANYO_PERSONAJE = 100;  // píxels (igual ancho que algo)
	public static final int RADIO_ESFERA_PERSONAJE = 35;  // Radio en píxels del bounding circle del coche (para choques)
	private static final boolean DIBUJAR_ESFERA_PERSONAJE = true;  // Dibujado (para depuración) del bounding circle de choque del coche
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
	//
	
	public Enemigo(){
		ImagenPersonajeUP = new Imagenmov("error.png");
		ImagenPersonajeUP.setSize(50,50 );
		ImagenPersonajeDOWN = new Imagenmov("error.png");
		ImagenPersonajeDOWN.setSize(50,50 );
		ImagenPersonajeDERECHA = new Imagenmov("error.png");
		ImagenPersonajeDERECHA.setSize(50,50 );
		ImagenPersonajeIZQUIERDA = new Imagenmov("error.png");
		ImagenPersonajeIZQUIERDA.setSize(50,50 );
		miGraficoActual= ImagenPersonajeDOWN;
		miGraficoActual.setVisible(true);
		//miGraficoActual.setBounds( 0, 0, TAMANYO_PERSONAJE, TAMANYO_PERSONAJE );
		
		
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
		if(posX-this.posX<0){
			miGraficoActual= ImagenPersonajeDERECHA;
		}else if(posX-this.posX>0){
			miGraficoActual= ImagenPersonajeIZQUIERDA;
		}
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		if(posY-this.posY<0){
			miGraficoActual= ImagenPersonajeDOWN;
		}else if(posY-this.posY>0){
			miGraficoActual= ImagenPersonajeUP;
		}
		this.posY = posY; 
	
	}
	
	public Imagenmov getGraficoActual() {
		return miGraficoActual;
	}
}


