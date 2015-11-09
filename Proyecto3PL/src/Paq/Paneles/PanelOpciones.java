package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PanelOpciones extends JFrame {
	public JPanel panelopciones;
	public JLabel dificultad;
	public static JComboBox<String> tiposdificultad;
	public JLabel nombreSonido;
	public JToggleButton musica;

	public PanelOpciones() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setLayout(new BorderLayout());
		this.setResizable(false); 
		// Paneles
		panelopciones = new JPanel() {
			public void paintComponent(Graphics g) {
				URL fondoBoton = this.getClass().getResource("boxhead2.jpg");
				Image ImagenFondoBoton = new ImageIcon(fondoBoton).getImage();
				g.drawImage(ImagenFondoBoton, 0, 0, getWidth(), getHeight(),
						this);
			}
		};
		this.add(panelopciones, BorderLayout.CENTER);
		panelopciones.setLayout(null);
		
	

		// Componentes
		dificultad = new JLabel("Dificultad: ");
		dificultad .setSize(100, 30);
		tiposdificultad = new JComboBox<>(new String[] { "Facil", "Medio",
				"Dificil" });
		tiposdificultad.setSize(100,30);
		nombreSonido = new JLabel("Musica: ");
		nombreSonido.setSize(100, 30);
		musica = new JToggleButton("ON");
		musica.setSize(60, 30);
		//Incluir botones
		panelopciones.add(dificultad );
		
		panelopciones.add(tiposdificultad);
		panelopciones.add(nombreSonido );
		panelopciones.add(musica );
		//Localizacion
		dificultad.setLocation((this.getWidth()/2)-(dificultad.getWidth()/2)-50,(this.getHeight()/2)-100);
		tiposdificultad.setLocation((this.getWidth()/2)-(tiposdificultad.getWidth()/2)+30,(this.getHeight()/2)-100);
		nombreSonido.setLocation((this.getWidth()/2)-(nombreSonido.getWidth()/2)-50,(this.getHeight()/2)+50);
		musica .setLocation((this.getWidth()/2)-(musica.getWidth()/2)+30,(this.getHeight()/2)+50);
		musica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		
				if (musica.getText().equals("ON")) {
					musica.setText("OF");

				} else if (musica.getText().equals("OF")) {
					musica.setText("ON");
				}

			}

		});
	}
}
