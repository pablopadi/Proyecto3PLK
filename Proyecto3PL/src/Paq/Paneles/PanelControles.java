package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelControles extends JFrame {
	JPanel panelControles;
	public static JLabel controlesmov;
	public static JLabel contrdisparar;
	public static JLabel cambiararmas;

	// Imagen de controles
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

	public PanelControles() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400, 500);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		// Paneles
		panelControles = new JPanel() {
			public void paintComponent(Graphics g) {
				URL fondoBoton = this.getClass().getResource("9304.jpg");
				Image ImagenFondoBoton = new ImageIcon(fondoBoton).getImage();
				g.drawImage(ImagenFondoBoton, 0, 0, getWidth(), getHeight(),
						this);
			}
		};
		this.add(panelControles, BorderLayout.CENTER);
		panelControles.setLayout(null);
		// Componentes
		controlesmov = new JLabel("MOVIMIENTO: ");
		controlesmov.setSize(80, 10);
		controlesmov.setForeground(Color.WHITE);
		contrdisparar= new JLabel("DISPARAR: ");
		contrdisparar.setSize(80, 10);
		contrdisparar.setForeground(Color.WHITE);
		cambiararmas= new JLabel("CAMBIAR ARMA: ");
		cambiararmas.setSize(100, 10);
		cambiararmas.setForeground(Color.WHITE);
		Imagenmov Imagencontrolsmov = new Imagenmov("Controls.png");
		Imagenmov Imagencontroldisp = new Imagenmov("controlesclic.png");
		
		Imagencontroldisp.setSize(100, 100);
		Imagenmov Imagencontrolcamb_arma= new Imagenmov("tecla-r.png");
		Imagencontrolcamb_arma.setSize(80, 80);
		// Añadir componentes
		panelControles.add(controlesmov);
		panelControles.add(Imagencontrolsmov);
		panelControles.add(contrdisparar);
		panelControles.add(Imagencontroldisp);
		panelControles.add(cambiararmas);
		panelControles.add(Imagencontrolcamb_arma);
		//Posicion
		controlesmov.setLocation((this.getWidth()/2)-(controlesmov.getWidth()/2)-30,(this.getHeight()/2)-150);
		Imagencontrolsmov.setLocation((this.getWidth()/2)-(Imagencontrolsmov.getWidth()/2)+80,(this.getHeight()/2)-200);
		contrdisparar.setLocation((this.getWidth()/2)-(contrdisparar.getWidth()/2)-30,(this.getHeight()/2)-50);
		Imagencontroldisp.setLocation((this.getWidth()/2)-(Imagencontroldisp.getWidth()/2)+80,(this.getHeight()/2)-50);
		cambiararmas.setLocation((this.getWidth()/2)-(cambiararmas.getWidth()/2)-10,(this.getHeight()/2)+80);
		Imagencontrolcamb_arma.setLocation((this.getWidth()/2)-(Imagencontrolcamb_arma.getWidth()/2)+80,(this.getHeight()/2)+80);
	}
}
