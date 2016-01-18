package Paq.Personajes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelEnemigo extends JLabel{
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_Enemigo= 50;  // píxels 
	public static final int ANCHURA_Enemigo= 50;
	public static final int RADIO_ESFERA_Enemigo= 22;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_Enemigo = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	public JLabelEnemigo() {
		try {
			setIcon( new ImageIcon( JLabelEnemigo.class.getResource( "prototipo.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: .png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_Enemigo, ANCHURA_Enemigo );
		setSize(TAMANYO_Enemigo, ANCHURA_Enemigo);
	}
	@Override
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, TAMANYO_Enemigo, ANCHURA_Enemigo, null );
        if (DIBUJAR_ESFERA_Enemigo) g2.drawOval( TAMANYO_Enemigo/2-RADIO_ESFERA_Enemigo, ANCHURA_Enemigo/2-RADIO_ESFERA_Enemigo,
        		RADIO_ESFERA_Enemigo*2, RADIO_ESFERA_Enemigo*2 );
	}
}
