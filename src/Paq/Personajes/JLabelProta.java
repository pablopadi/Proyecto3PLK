package Paq.Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelProta extends JLabel {
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_PERSONAJE= 100;  // píxels (igual ancho que algo)
	public static final int RADIO_ESFERA_PERSONAJE= 35;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_PERSONAJE = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del prota con su gráfico y tamaño
	 */
	public JLabelProta() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "img/.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_PERSONAJE, TAMANYO_PERSONAJE );
	}
	//Se puede hacer una opcion para elegir varios tipos de prota, cada uno con sus habilidades, pero eso para el final
}
