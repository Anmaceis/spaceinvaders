package fr.unilim.iut.spaceInvaders;

public class Missile extends Sprite {
	Dimension dimension;
	Position position;
	int vitesse;
	
	public Missile(Dimension dimensionMissile, Position positionOrigineMissile, int vitesseMissile) {
		this.dimension = dimensionMissile;
		this.position = positionOrigineMissile;
		this.vitesse = vitesseMissile;
	}

}
