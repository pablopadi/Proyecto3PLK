package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelProta extends JLabel {
	private static final long serialVersionUID = 1L;  // Para serializaci�n
	public static final int TAMANYO_PERSONAJE= 50;  // p�xels 
	public static final int ANCHURA_PERSONAJE= 50;
	public static final int RADIO_ESFERA_PERSONAJE= 22;  // Radio en p�xels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_PERSONAJE = true;  // Dibujado (para depuraci�n) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del prota con su gr�fico y tama�o
	 */
	public JLabelProta() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "prototipo.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_PERSONAJE, ANCHURA_PERSONAJE );
		setSize(TAMANYO_PERSONAJE, ANCHURA_PERSONAJE);
	}
	
	// Redefinici�n del paintComponent para que se escale 
		@Override
		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
			Image img = ((ImageIcon)getIcon()).getImage();
			Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
			// Escalado m�s fino con estos 3 par�metros:
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
	        // Dibujado de la imagen
	        g2.drawImage( img, 0, 0, TAMANYO_PERSONAJE, ANCHURA_PERSONAJE, null );
//	        if (DIBUJAR_ESFERA_PERSONAJE) g2.drawOval( TAMANYO_PERSONAJE/2-RADIO_ESFERA_PERSONAJE, ANCHURA_PERSONAJE/2-RADIO_ESFERA_PERSONAJE,
//	        		RADIO_ESFERA_PERSONAJE*2, RADIO_ESFERA_PERSONAJE*2 );
		}
}
