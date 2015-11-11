package Paq.Paneles;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Escenario extends JFrame{
	public JPanel panelPrincipal;
	public JPanel panelPuntuacion;
	public Escenario(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//No se podra cambiar el tamaño de la ventana
		this.setResizable(false); 
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
