package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import Paq.Hilos.HiloJuego;

public class Menu extends JFrame {
	public JPanel panelPrincipal;
	public JPanel panelJugador;
	public JPanel panelBotones;
	public static JButton botonControles;
	public static JButton botonOpciones;
	public static JButton play;
	public static JTextField nombreJugador;
	public JLabel etiquetaNombre;
	private Image ImagenFondo;
	private URL fondo;
	HiloJuego hilo;
//
	
	public Menu() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setLayout(new BorderLayout());
		//No se podra cambiar el tamaño de la ventana
		this.setResizable(false); 

		//
		fondo = this.getClass().getResource("boxhead-zombie-wars.png");
		ImagenFondo = new ImageIcon(fondo).getImage();
		// Creo los paneles

		panelPrincipal = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(ImagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		this.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);

		panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		this.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout());
		
		panelJugador = new JPanel();
		panelJugador.setBackground(Color.RED);
		this.add(panelJugador, BorderLayout.NORTH);
		panelJugador.setLayout(new FlowLayout());
		//Crear componentes
		botonControles = new JButton("Controles");
		botonOpciones = new JButton("Opciones");
		play = new JButton(" Play "){
			public void paintComponent(Graphics g) {
				URL fondoBoton = this.getClass().getResource("images.jpeg");
				Image ImagenFondoBoton = new ImageIcon(fondoBoton).getImage();
				g.drawImage(ImagenFondoBoton, 0, 0, getWidth(), getHeight(), this);
			}
		};
		play.setSize(100, 50);
		etiquetaNombre = new JLabel("Nombre");
		nombreJugador = new JTextField();
		nombreJugador.setColumns(20);
		
		// Incluir botones
		panelBotones.add(botonControles);
		panelBotones.add(botonOpciones);
		
		panelJugador.add(etiquetaNombre );
		panelJugador.add(nombreJugador );
		panelPrincipal.add(play);
		play.setLocation((this.getWidth()/2)-(play.getWidth()/2),(this.getHeight()/2)+100);
		
		botonControles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Cuando lo cliquees se ponga PARAR
				PanelControles controles = new PanelControles();
				controles.setVisible(true);
			}
		});
		botonOpciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Cuando lo cliquees se ponga PARAR
				PanelOpciones opciones = new PanelOpciones();
				opciones.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
