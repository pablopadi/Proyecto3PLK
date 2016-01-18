package Paq.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;




import Paq.BD.BaseDatos;
import Paq.Personajes.Barril;
import Paq.Personajes.Barril;
import Paq.Personajes.Enemigo;
import Paq.Personajes.Municion;
import Paq.Personajes.Prota;



public class Escenario extends JFrame{
	public static Prota miProta;
	public ArrayList<Enemigo> misEnemigos = new ArrayList<>();
	public ArrayList<Municion> T_Municion = new ArrayList<>();
	public ArrayList<Barril> barriles = new ArrayList<>();
	//public Enemigo miEnemigo; // TODO Hacer array de enemigos y spawn de ellos
	public static JPanel panelPrincipal;
	public JPanel panelPuntuacion;
	private Image ImagenFondo;
	private URL fondo;
	public static JTextField puntuacion;
	public JLabel etiquetapuntuacion;
	public static JTextField nombreJugador;
	public JLabel etiquetaNombre;
	public Menu menuprincipal;
	public static HiloMovPrsonaje hilomovimiento;
	public static HiloCrearZombis hilocrearZombis;
	int numeroZombisRonda=5;
	int numeroZombisActuales=0;
	public Escenario(Menu a){

		menuprincipal=a;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//No se podra cambiar el tamaño de la ventana
		this.setResizable(false); 
		
		//Codigo para centrar la ventana
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		Dimension d = gs[0].getDefaultConfiguration().getBounds().getSize();
		int x = (int) d.getWidth()/4;
		int y = (int) d.getHeight()/4;
		this.setBounds(4*x - 2*(x + 250) , 4*y - 2*(y + 200) , (1920 + 200) /2, (1080 + 400)/2);
		//tamaño antiguo 1000*600
		
		
		
		fondo = this.getClass().getResource("ImgEscenario.png");
		ImagenFondo = new ImageIcon(fondo).getImage();
		// Creo los paneles

		panelPrincipal = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(ImagenFondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		this.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);

		panelPuntuacion = new JPanel();
		panelPuntuacion.setBackground(Color.BLACK);
		this.add(panelPuntuacion, BorderLayout.NORTH);
		panelPuntuacion.setLayout(new FlowLayout());
		
		etiquetapuntuacion = new JLabel("Puntuacion: ");
		etiquetapuntuacion.setForeground(Color.RED);
		puntuacion = new JTextField("000000");
		puntuacion.setEditable(false);
		etiquetaNombre = a.etiquetaNombre;
		etiquetaNombre.setForeground(Color.RED);
		nombreJugador = a.nombreJugador;
		nombreJugador.setEditable(false);
		puntuacion.setColumns(20);
		panelPuntuacion.add(etiquetapuntuacion);
		panelPuntuacion.add(puntuacion);
		panelPuntuacion.add(etiquetaNombre);
		panelPuntuacion.add(nombreJugador);
		
		// Añadido para que también se gestione por teclado con el KeyListener
		
		panelPrincipal.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				miProta.keyReleased(arg0);
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				miProta.keyPressed(arg0);
				
				
			}
		});
		
		
		panelPrincipal.setFocusable(true);
		panelPrincipal.requestFocus();
		panelPrincipal.addFocusListener( new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						System.out.println("Foco: "+ Escenario.this.getFocusOwner());
						panelPrincipal.requestFocus();
						
					}
				});
		
		creaPersonaje(500, 300);
		creaBarril(650,300);
		creaBarril(200, 100);
		creaMunicion(400,300);
	}
	public void creaPersonaje( int posX, int posY ) {
		// Crear y añadir el prota a la ventana
		miProta = new Prota(this);
		miProta.setPosicion( posX, posY );
		
		panelPrincipal.add( miProta.getGrafico()) ;  // Añade al panel visual
		miProta.getGrafico().setLocation(posX, posY);
		miProta.getGrafico().repaint();  // Refresca el dibujado del prota
	
		
	}
	
	public void creaBarril( int posX, int posY ) {
		// Crear y añadir el barril a la ventana
		Barril miBarril = new Barril(this,60,45);
		miBarril.setPosicion( posX, posY );
		barriles.add(miBarril);
		panelPrincipal.add( miBarril.getMiGrafico()) ; // Añade al panel visual
		miBarril.getMiGrafico().setLocation(posX, posY);
		miBarril.getMiGrafico().repaint();  // Refresca el dibujado del barril
	}
	
	public void creaMunicion( int posX, int posY ) {
		// Crear y añadir el barril a la ventana
		Municion miMunicion = new Municion(this,150,50);
		miMunicion.setPosicion( posX, posY );
		T_Municion.add( miMunicion);
		panelPrincipal.add( miMunicion.getMiGrafico() );  // Añade al panel visual
		miMunicion.getMiGrafico().setLocation(posX, posY);
		miMunicion.getMiGrafico().repaint();  // Refresca el dibujado de la municion
	}
	
	public int creaEnemigo( int posX, int posY,int n) {
		// Crear y añadir el enemigo a la ventana
		boolean p = true;
		 Enemigo	miEnemigo = new Enemigo(this, miProta);
		miEnemigo.setPosicion( posX, posY );
		for(Enemigo otroEnemigo : misEnemigos){
			if(miEnemigo.hayChoqueconEnemigo(otroEnemigo) ){
				p=false;
			}else{
			
			}
		}
		if(p==true){
			misEnemigos.add(miEnemigo);
			panelPrincipal.add( miEnemigo.getGrafico()) ;  // Añade al panel visual
			miEnemigo.getGrafico().setLocation(posX, posY);
			miEnemigo.getGrafico().repaint();  // Refresca el dibujado del prota
			return n+1;
		}
	return n;
	}
	
	
	public static void main(Menu a) {
	
		try {
			final Escenario escenario = new Escenario(a);
			
			escenario.setVisible( true );
			panelPrincipal.requestFocus();
			// Crea el hilo del juego
			escenario.hilomovimiento = escenario.new HiloMovPrsonaje();  // Sintaxis de new para clase interna
			Thread Hilomov = new Thread( escenario.hilomovimiento );
			Hilomov.start();
			escenario.hilocrearZombis= escenario.new HiloCrearZombis();  // Sintaxis de new para clase interna
			Thread HiloZombi = new Thread( escenario.hilocrearZombis );
			HiloZombi.start();
		} catch (Exception e) {
			System.exit(1);  // Error anormal
		}
		BaseDatos.crearTablaBD();
		BaseDatos.guardarBD();
	}
	public class HiloCrearZombis implements Runnable {
		boolean sigo= true;
		@Override
		public void run() {
			// Bucle principal forever hasta que se pare el juego...
			while (sigo) {	
				//Lo que hara el hilo
				panelPrincipal.repaint();
				try {
					Thread.sleep( 2000 );
					double ran =  Math.random();
					if(ran>0.75){
						numeroZombisActuales=creaEnemigo(50, 300,	numeroZombisActuales);
					
					}else if(ran>0.5){
						numeroZombisActuales=creaEnemigo(50, 260,numeroZombisActuales);
						
					}else if(ran>0.25){
						numeroZombisActuales=creaEnemigo(950, 300,numeroZombisActuales);
						
					}else{
						numeroZombisActuales=creaEnemigo(950, 260,numeroZombisActuales);
						//
					}
					
				} catch (Exception e) {
				}
				if(numeroZombisActuales==numeroZombisRonda){
					sigo= false;
					//Poner nueva ronda
				}
			}
		}
	}
	public class HiloMovPrsonaje implements Runnable {
		boolean sigo= true;
		@Override
		public void run() {
			// Bucle principal forever hasta que se pare el juego...
			while (sigo) {	
				//Lo que hara el hilo
				panelPrincipal.repaint();
				try {
					Thread.sleep( 100 );
					miProta.mover();
					for(Enemigo miEnemigo : misEnemigos){
					miEnemigo.mover();
					}
					
				} catch (Exception e) {
				}
			}
		}
		public void start() {
			// TODO Auto-generated method stub
			sigo= true;
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			sigo = false;
		}
	};
	

}