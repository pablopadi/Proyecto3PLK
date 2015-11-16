package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Objetos extends JPanel{
	
	public Objetos(String nombre, Imagenmov nombreimagen ) {
		this.nombre=nombre;
	}
	
	protected String nombre;

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
}
