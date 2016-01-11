package Paq.Personajes;

import Paq.Paneles.Escenario;

public class  Bala extends ObjetosJuego{
	private JLabelBala miGrafico;
	Escenario a;//Escenario en el que juega
	
	public Bala(Escenario p, double posX, double posY){
		super(posX,posY);
		miGrafico= new JLabelBala();
		miGrafico.setVisible(true);
		a=p;
	}

	public JLabelBala getMiGrafico() {
		return miGrafico;
	}

	public void setMiGrafico(JLabelBala miGrafico) {
		this.miGrafico = miGrafico;
	}

	public double getPosX(double posX) {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public Escenario getA() {
		return a;
	}

	public void setA(Escenario a) {
		this.a = a;
	}
	
	public boolean hayChoqueHorizontalIzquierda( Bala mibala) {
		return (mibala.getPosX() > a.panelPrincipal.getWidth() - 50
				- JLabelBala.ANCHURA_BALA / 2
				- JLabelBala.RADIO_ESFERA_BALA);
	}

	public boolean hayChoqueHorizontalDerecha( Bala mibala) {
		return (mibala.getPosX() < JLabelProta.RADIO_ESFERA_PERSONAJE + 50
				- JLabelBala.ANCHURA_BALA / 2);
	}
	
	public boolean hayChoqueVerticalAbajo(Prota miProta) {
		return (miProta.getPosY() > a.panelPrincipal.getHeight() - 50
				- JLabelBala.TAMANYO_BALA / 2
				- JLabelBala.RADIO_ESFERA_BALA);
	}

	public boolean hayChoqueVerticalArriba(Prota miProta) {
		return (miProta.getPosY() < JLabelProta.RADIO_ESFERA_PERSONAJE + 50
				- JLabelBala.TAMANYO_BALA / 2);
	}

}
