package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
		
		//Codigo para centrar la ventana
		
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				GraphicsDevice[] gs = ge.getScreenDevices();
				Dimension d = gs[0].getDefaultConfiguration().getBounds().getSize();
				int x = (int) d.getWidth()/4;
				int y = (int) d.getHeight()/4;
				this.setBounds(4*x - 2*(x + 250) , 4*y - 2*(y + 200) , (1920 + 200) /2, (1080 + 400)/2);

				
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
