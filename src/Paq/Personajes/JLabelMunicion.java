package Paq.Personajes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelMunicion extends JLabel {
	
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_MUNICION= 30;  // píxels 
	public static final int ANCHURA_MUNICION= 30;  // píxels 
	public static final int RADIO_ESFERA_MUNICION= 15;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_MUNICION = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del MUNICION con su gráfico y tamaño
	 */
	public JLabelMunicion() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "municion.jpg" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_MUNICION, ANCHURA_MUNICION );
		setSize(TAMANYO_MUNICION, ANCHURA_MUNICION);
	}
	// Redefinición del paintComponent para que se escale 
			@Override
			protected void paintComponent(Graphics g) {
//				super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
				Image img = ((ImageIcon)getIcon()).getImage();
				Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
				// Escalado más fino con estos 3 parámetros:
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		        // Dibujado de la imagen
		        g2.drawImage( img, 0, 0, TAMANYO_MUNICION, ANCHURA_MUNICION, null );
//		        if (DIBUJAR_ESFERA_MUNICION) g2.drawOval( TAMANYO_MUNICION/2-RADIO_ESFERA_MUNICION, ANCHURA_MUNICION/2-RADIO_ESFERA_MUNICION,
//		        		RADIO_ESFERA_MUNICION*2, RADIO_ESFERA_MUNICION*2 );
			}
}
