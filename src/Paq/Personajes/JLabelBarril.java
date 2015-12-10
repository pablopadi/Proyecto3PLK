package Paq.Personajes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBarril extends JLabel {
	private static final long serialVersionUID = 1L;  // Para serializaci�n
	public static final int TAMANYO_BARRIL= 50;  // p�xels (igual ancho que algo)
	public static final int ANCHURA_BARRIL= 50;  // p�xels (igual ancho que algo)
	public static final int RADIO_ESFERA_BARRIL= 22;  // Radio en p�xels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_BARRIL = true;  // Dibujado (para depuraci�n) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del barril con su gr�fico y tama�o
	 */
	public JLabelBarril() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "barril.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_BARRIL, ANCHURA_BARRIL );
		setSize(TAMANYO_BARRIL, ANCHURA_BARRIL);
	}
	// Redefinici�n del paintComponent para que se escale 
				@Override
				protected void paintComponent(Graphics g) {
//					super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
					Image img = ((ImageIcon)getIcon()).getImage();
					Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
					// Escalado m�s fino con estos 3 par�metros:
					g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
			        // Dibujado de la imagen
			        g2.drawImage( img, 0, 0, TAMANYO_BARRIL, ANCHURA_BARRIL, null );
			        if (DIBUJAR_ESFERA_BARRIL) g2.drawOval( TAMANYO_BARRIL/2-RADIO_ESFERA_BARRIL, ANCHURA_BARRIL/2-RADIO_ESFERA_BARRIL,
			        		RADIO_ESFERA_BARRIL*2, RADIO_ESFERA_BARRIL*2 );
				}
}
