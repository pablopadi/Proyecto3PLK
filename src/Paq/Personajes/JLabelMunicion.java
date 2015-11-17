package Paq.Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelMunicion extends JLabel {
	
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_MUNICION= 60;  // píxels (igual ancho que algo)
	public static final int RADIO_ESFERA_MUNICION= 30;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_MUNICION = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del MUNICION con su gráfico y tamaño
	 */
	public JLabelMunicion() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "img/.jpg" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_MUNICION, TAMANYO_MUNICION );
	}

}
