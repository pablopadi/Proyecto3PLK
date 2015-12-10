package Paq.Personajes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;



import Paq.Paneles.Escenario;



public class Enemigo {
	private JLabelEnemigo miGrafico;
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	Escenario a;//Escenario en el que juega
//Metodo de imagen 
	
	Random ran ;
	
	public Enemigo(Escenario p){
		miGrafico = new JLabelEnemigo();
		miGrafico.setVisible(true);
		a = p;
		//miGraficoActual.setBounds( 0, 0, TAMANYO_PERSONAJE, TAMANYO_PERSONAJE );
		
		
	}
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	public JLabelEnemigo getGrafico() {
		return miGrafico;
	}
	public void setPosX( double posX ) {
		if(posX-this.posX<0){
			try {
				miGrafico.setIcon( new ImageIcon( JLabelProta.class.getResource( "error.png" ).toURI().toURL() ) );
			} catch (Exception e) {
				System.err.println( "Error en carga de recurso: coche.png no encontrado" );
				e.printStackTrace();
			}
		}else if(posX-this.posX>0){
			try {
				miGrafico.setIcon( new ImageIcon( JLabelProta.class.getResource( "error.png" ).toURI().toURL() ) );
			} catch (Exception e) {
				System.err.println( "Error en carga de recurso: coche.png no encontrado" );
				e.printStackTrace();
			}
		}
		this.posX = posX; 
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	
	public void setPosY( double posY ) {
		if(posY-this.posY<0){
			//arriba
			try {
				miGrafico.setIcon( new ImageIcon( JLabelProta.class.getResource( "prototipo.png" ).toURI().toURL() ) );
			} catch (Exception e) {
				System.err.println( "Error en carga de recurso: coche.png no encontrado" );
				e.printStackTrace();
			}
		}else if(posY-this.posY>0){
			//abajo
			try {
				miGrafico.setIcon( new ImageIcon( JLabelProta.class.getResource( "prototipo.png" ).toURI().toURL() ) );
			} catch (Exception e) {
				System.err.println( "Error en carga de recurso: coche.png no encontrado" );
				e.printStackTrace();
			}
		}
		this.posY = posY; 
		miGrafico.setLocation( (int)posX, (int)posY );
	}
	/** Calcula si hay choque en horizontal con los límites del mundo
	 * @param coche	Coche cuyo choque se comprueba con su posición actual
	 * @return	true si hay choque horizontal, false si no lo hay
	 */
	public boolean hayChoqueHorizontalIzquierda( Enemigo zombi ) {
		return ( zombi.getPosX()>a.panelPrincipal.getWidth()-50-JLabelEnemigo.ANCHURA_Enemigo/2-JLabelEnemigo.RADIO_ESFERA_Enemigo );
	}
	public boolean hayChoqueHorizontalDerecha( Enemigo zombi ) {
		return (zombi.getPosX() < JLabelEnemigo.RADIO_ESFERA_Enemigo+50-JLabelEnemigo.ANCHURA_Enemigo/2 
				 );
	}
	
	/** Calcula si hay choque en vertical con los límites del mundo
	 * @param coche	Coche cuyo choque se comprueba con su posición actual
	 * @return	true si hay choque vertical, false si no lo hay
	 */
	public boolean hayChoqueVerticalAbajo  (Enemigo zombi ) {
		return ( zombi.getPosY()>a.panelPrincipal.getHeight()-50-JLabelEnemigo.TAMANYO_Enemigo/2-JLabelEnemigo.RADIO_ESFERA_Enemigo );
	}
	public boolean hayChoqueVerticalArriba(  Enemigo zombi ) {
		return (zombi.getPosY() < JLabelEnemigo.RADIO_ESFERA_Enemigo+50-JLabelEnemigo.TAMANYO_Enemigo/2  );
	}
	public boolean hayChoqueconProta(Prota miProta) {
		if ( miProta.getPosX() + JLabelProta.RADIO_ESFERA_PERSONAJE  > this.getPosX() - this.miGrafico.RADIO_ESFERA_Enemigo
				&& miProta.getPosX() - JLabelProta.RADIO_ESFERA_PERSONAJE  < this.getPosX() + this.miGrafico.RADIO_ESFERA_Enemigo
				&& miProta.getPosY() + JLabelProta.RADIO_ESFERA_PERSONAJE > this.getPosY() - this.miGrafico.RADIO_ESFERA_Enemigo
				&& miProta.getPosY() - JLabelProta.RADIO_ESFERA_PERSONAJE  < this.getPosY() + this.miGrafico.RADIO_ESFERA_Enemigo
				){
			return true;
			
		}
		return false;
	}
	public boolean hayChoqueconEnemigo(Enemigo miEnemigo) {
		if (miEnemigo.getPosX() + JLabelEnemigo.RADIO_ESFERA_Enemigo > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_Enemigo
				&& miEnemigo.getPosX() - JLabelEnemigo.RADIO_ESFERA_Enemigo < this
						.getPosX() + this.miGrafico.RADIO_ESFERA_Enemigo
				&& miEnemigo.getPosY() + JLabelEnemigo.RADIO_ESFERA_Enemigo > this
						.getPosY() - this.miGrafico.RADIO_ESFERA_Enemigo
				&& miEnemigo.getPosY() - JLabelEnemigo.RADIO_ESFERA_Enemigo < this
						.getPosY() + this.miGrafico.RADIO_ESFERA_Enemigo) {
			return true;

		}
		return false;
	}	
		
	public boolean hayChoqueconBarril(Barril miBarril) {
		if (miBarril.getPosX() + JLabelBarril.RADIO_ESFERA_BARRIL > this
				.getPosX() - this.miGrafico.RADIO_ESFERA_Enemigo
				&& miBarril.getPosX() - JLabelBarril.RADIO_ESFERA_BARRIL< this
						.getPosX() + this.miGrafico.RADIO_ESFERA_Enemigo
				&& miBarril.getPosY() + JLabelBarril.RADIO_ESFERA_BARRIL> this
						.getPosY() - this.miGrafico.RADIO_ESFERA_Enemigo
				&& miBarril.getPosY() - JLabelBarril.RADIO_ESFERA_BARRIL< this
						.getPosY() + this.miGrafico.RADIO_ESFERA_Enemigo) {
			return true;

		}
		return false;
	}	
	
	public void mover() {
		int k;
		boolean p = true;
		double poxProta = a.miProta.getPosX();
		double poyProta = a.miProta.getPosY();
		if (!hayChoqueconProta(a.miProta)) {
			if (Math.abs(poxProta - posX) < Math.abs(poyProta - posY)) {
				if (poyProta > posY) {
					
					if ((!hayChoqueVerticalAbajo(this))) {
						setPosY(posY + 5);
						//choque con barril
						for (Barril barril : a.barriles) {
							if ((hayChoqueconBarril(barril ))){
								setPosY(posY - 5);
								p=false;
								//Rodear barril
								if (!hayChoqueHorizontalIzquierda(this)&&!hayChoqueHorizontalDerecha(this)) {
									setPosX(posX - 5);
									for (Enemigo otroEnemigo1 : a.misEnemigos) {
										if (hayChoqueconEnemigo(otroEnemigo1)
												&& (otroEnemigo1 != this)) {
											
											setPosX(posX + 5);
											
											break;
										}
									}
								}
								break;
						}else{
							
						}
							
						}
					
						
					if(p)	{
						for (Enemigo otroEnemigo : a.misEnemigos) {
							if ((hayChoqueconEnemigo(otroEnemigo))
									&& (otroEnemigo != this)) {
								setPosY(posY - 5);
								//Rodear personaje
								if (!hayChoqueHorizontalIzquierda(this)&&!hayChoqueHorizontalDerecha(this)) {
									
									setPosX(posX - 5);
									boolean t = false;
									for (Enemigo otroEnemigo1 : a.misEnemigos) {
										for (Barril barril1 : a.barriles) {
											if ((hayChoqueconBarril(barril1 ) )||(hayChoqueconEnemigo(otroEnemigo1)
													&& (otroEnemigo1 != this))){
												setPosX(posX + 5);
												t = true;
												break;
												
											}
										}
									if(t){
										break;
									}
										
									}
								}
								//

								break;
							}
						}
					
					}
					}

				} else {
					if (!hayChoqueVerticalArriba(this)) {
						setPosY(posY - 5);
						for (Barril barril : a.barriles) {
							if ((hayChoqueconBarril(barril ))){
								setPosY(posY + 5);
								p=false;
								//Rodear barril
								if (!hayChoqueHorizontalDerecha(this)&&!hayChoqueHorizontalIzquierda(this)) {
									setPosX(posX + 5);
									for (Enemigo otroEnemigo1 : a.misEnemigos) {
										if (hayChoqueconEnemigo(otroEnemigo1)
												&& (otroEnemigo1 != this)) {
											setPosX(posX - 5);
											break;
										}
									}
								}
								break;
						}else{
							
						}
							
						}
						if(p)	{
							for (Enemigo otroEnemigo : a.misEnemigos) {
								if (hayChoqueconEnemigo(otroEnemigo)
										&& (otroEnemigo != this)) {
									setPosY(posY + 5);
									//Rodear personaje
									if (!hayChoqueHorizontalDerecha(this)&&!hayChoqueHorizontalIzquierda(this)) {
										setPosX(posX + 5);
										boolean t = false;
										for (Enemigo otroEnemigo1 : a.misEnemigos) {
											for (Barril barril1 : a.barriles) {
												if ((hayChoqueconBarril(barril1 ) )||(hayChoqueconEnemigo(otroEnemigo1)
														&& (otroEnemigo1 != this))){
													setPosX(posX -5);
													t = true;
													break;
													
												}
											}
										if(t){
											break;
										}
											
										}
									}

									break;
								}
							}
						}
						
					}

				}
				//
			} else {
				if (poxProta > posX) {
					if (!hayChoqueHorizontalIzquierda(this)) {
						setPosX(posX + 5);
						for (Barril barril : a.barriles) {
							if ((hayChoqueconBarril(barril ))){
								setPosX(posX - 5);
								p=false;
								//rodear barril
								if (!hayChoqueVerticalArriba(this)) {
									setPosY(posY - 5);
									for (Enemigo otroEnemigo1 : a.misEnemigos) {
										if (hayChoqueconEnemigo(otroEnemigo1)
												&& (otroEnemigo1 != this)) {
											setPosY(posY + 5);

											break;
										}
									}
								}
								break;
						}else{
							
						}
							
						}
						if(p)	{
							for (Enemigo otroEnemigo : a.misEnemigos) {
								if (hayChoqueconEnemigo(otroEnemigo)
										&& (otroEnemigo != this)) {
									setPosX(posX - 5);
									//Rodear personaje
									if (!hayChoqueVerticalArriba(this)) {
										setPosY(posY - 5);
										boolean t = false;
										for (Enemigo otroEnemigo1 : a.misEnemigos) {
											for (Barril barril1 : a.barriles) {
												if ((hayChoqueconBarril(barril1 ) )||(hayChoqueconEnemigo(otroEnemigo1)
														&& (otroEnemigo1 != this))){
													setPosY(posY + 5);
													t = true;
													break;
													
												}
											}
										if(t){
											break;
										}
											
										}
									}

									break;
								}
							}
						
						}
						
					}

				} else {
					if (!hayChoqueHorizontalDerecha(this)) {
						setPosX(posX - 5);
						for (Barril barril : a.barriles) {
							if ((hayChoqueconBarril(barril ))){
								setPosX(posX + 5);
								p=false;
								//Rodear barril
								if (!hayChoqueVerticalAbajo(this)) {
									setPosY(posY + 5);
									for (Enemigo otroEnemigo1 : a.misEnemigos) {
										if (hayChoqueconEnemigo(otroEnemigo1)
												&& (otroEnemigo1 != this)) {
											setPosY(posY - 5);
											break;
										}
									}
								}
								break;
						}else{
							
						}
							
						}
						if(p)	{
							for (Enemigo otroEnemigo : a.misEnemigos) {
								if (hayChoqueconEnemigo(otroEnemigo)
										&& (otroEnemigo != this)) {
									setPosX(posX + 5);
									//Rodear personaje
									if (!hayChoqueVerticalAbajo(this)) {
										setPosY(posY + 5);
										boolean t = false;
										for (Enemigo otroEnemigo1 : a.misEnemigos) {
											for (Barril barril1 : a.barriles) {
												if ((hayChoqueconBarril(barril1 ) )||(hayChoqueconEnemigo(otroEnemigo1)
														&& (otroEnemigo1 != this))){
													setPosY(posY - 5);
													t = true;
													break;
													
												}
											}
										if(t){
											break;
										}
											
										}
									}
									break;
								}
							}
						}
						
					}

				}

			}
		} else {
			// Si toca al prota
		}
	}

}


