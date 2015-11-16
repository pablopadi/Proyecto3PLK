package Paq.Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBarril extends JLabel {
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_BARRIL= 50;  // píxels (igual ancho que algo)
	public static final int RADIO_ESFERA_BARRIL= 30;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_BARRIL = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del barril con su gráfico y tamaño
	 */
	public JLabelBarril() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "img/.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_BARRIL, TAMANYO_BARRIL );
	}
	
}
