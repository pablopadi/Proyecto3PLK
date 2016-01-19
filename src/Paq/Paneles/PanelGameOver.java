package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelGameOver extends JFrame{
	public JPanel panelPrincipal;
	private Image ImagenFondo;
	private URL fondo;
	
	public PanelGameOver() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//No se podra cambiar el tamaño de la ventana	
		this.setResizable(false);
		fondo = this.getClass().getResource("gameover.png");
		ImagenFondo = new ImageIcon(fondo).getImage();
		// Creo los paneles
		panelPrincipal = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(ImagenFondo, 0, 0, getWidth(), getHeight(), this);
				}
			};
		this.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
	}
}
