package Paq.Personajes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBala extends JLabel {
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_BALA= 20;  // píxels 
	public static final int ANCHURA_BALA= 20;
	public static final int RADIO_ESFERA_BALA= 10;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_BALA = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del prota con su gráfico y tamaño
	 */
	public JLabelBala() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "bala.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_BALA, ANCHURA_BALA );
		setSize(TAMANYO_BALA, ANCHURA_BALA);
	}
	
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, TAMANYO_BALA, ANCHURA_BALA, null );
        if (DIBUJAR_ESFERA_BALA) g2.drawOval( TAMANYO_BALA/2-RADIO_ESFERA_BALA, ANCHURA_BALA/2-RADIO_ESFERA_BALA,
        		RADIO_ESFERA_BALA*2, RADIO_ESFERA_BALA*2 );
	}

}
