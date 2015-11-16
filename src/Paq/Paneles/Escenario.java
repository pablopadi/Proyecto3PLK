package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Paq.Personajes.Prota;


public class Escenario extends JFrame{
	public Prota miProta;
	public JPanel panelPrincipal;
	public JPanel panelPuntuacion;
	private Image ImagenFondo;
	private URL fondo;
	public static JTextField puntuacion;
	public JLabel etiquetapuntuacion;
	public static JTextField nombreJugador;
	public JLabel etiquetaNombre;
	public Menu menuprincipal;
	public Escenario(Menu a){

		menuprincipal=a;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//No se podra cambiar el tamaño de la ventana
		this.setResizable(false); 
		
		//Codigo para centrar la ventana
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		Dimension d = gs[0].getDefaultConfiguration().getBounds().getSize();
		int x = (int) d.getWidth()/4;
		int y = (int) d.getHeight()/4;
		this.setBounds(4*x - 2*(x + 250) , 4*y - 2*(y + 200) , (1920 + 200) /2, (1080 + 400)/2);
		//tamaño antiguo 1000*600
		
		this.setVisible(true);
		
		fondo = this.getClass().getResource("ImgEscenario.png");
		ImagenFondo = new ImageIcon(fondo).getImage();
		// Creo los paneles

		panelPrincipal = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(ImagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		this.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);

		panelPuntuacion = new JPanel();
		panelPuntuacion.setBackground(Color.BLACK);
		this.add(panelPuntuacion, BorderLayout.NORTH);
		panelPuntuacion.setLayout(new FlowLayout());
		
		etiquetapuntuacion = new JLabel("Puntuacion: ");
		etiquetapuntuacion.setForeground(Color.RED);
		puntuacion = new JTextField("000000");
		puntuacion.setEditable(false);
		etiquetaNombre = a.etiquetaNombre;
		etiquetaNombre.setForeground(Color.RED);
		nombreJugador = a.nombreJugador;
		nombreJugador.setEditable(false);
		puntuacion.setColumns(20);
		panelPuntuacion.add(etiquetapuntuacion);
		panelPuntuacion.add(puntuacion);
		panelPuntuacion.add(etiquetaNombre);
		panelPuntuacion.add(nombreJugador);
		
		creaPersonaje(500, 300);
	}
	public void creaPersonaje( int posX, int posY ) {
		// Crear y añadir el coche a la ventana
		miProta = new Prota();
		miProta.setPosicion( posX, posY );
		
		panelPrincipal.add( miProta.getGraficoActual() );  // Añade al panel visual
		miProta.getGraficoActual().setLocation(posX, posY);
		miProta.getGraficoActual().repaint();  // Refresca el dibujado del coche
	}
}
