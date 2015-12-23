package Paq.Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBala extends JLabel {
	private static final long serialVersionUID = 1L;  // Para serialización
	public static final int TAMANYO_PERSONAJE= 20;  // píxels 
	public static final int ANCHURA_PERSONAJE= 20;
	public static final int RADIO_ESFERA_PERSONAJE= 10;  // Radio en píxels del bounding circle del prota (para golpes)
	private static final boolean DIBUJAR_ESFERA_PERSONAJE = true;  // Dibujado (para depuración) del bounding circle de choque del coche
	
	/** Construye y devuelve el JLabel del prota con su gráfico y tamaño
	 */
	public JLabelBala() {
		try {
			setIcon( new ImageIcon( JLabelProta.class.getResource( "bala.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: coche.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_PERSONAJE, ANCHURA_PERSONAJE );
		setSize(TAMANYO_PERSONAJE, ANCHURA_PERSONAJE);
	}

}
