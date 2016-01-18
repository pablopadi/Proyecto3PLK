package Paq.Personajes;

public class ObjetosJuego {
	
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)

	public ObjetosJuego(double posX, double posY){
		this.posX=posX;
		this.posY=posY;
	}

	public double getPosX() {
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
}
