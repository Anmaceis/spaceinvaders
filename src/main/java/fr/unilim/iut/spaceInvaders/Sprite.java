package fr.unilim.iut.spaceInvaders;

public abstract class Sprite {

	protected Position origine;
	protected Dimension dimension;
	protected int vitesse;
	
	public Sprite(Position origine, Dimension dimension, int vitesse) {
		super();
		this.origine = origine;
		this.dimension = dimension;
		this.vitesse = vitesse;
	}

	public Sprite() {
		super();
	}

	public boolean occupeLaPosition(int x, int y) {
	    return estAbscisseCouverte(x) && estOrdonneeCouverte(y);
	}

	private boolean estOrdonneeCouverte(int y) {
	   return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	private boolean estAbscisseCouverte(int x) {
	   return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int ordonneeLaPlusBasse() {
	    return this.origine.ordonnee() - this.dimension.hauteur() + 1;
	}

	public int ordonneeLaPlusHaute() {
		   return this.origine.ordonnee();
	   }

	public int abscisseLaPlusADroite() {
		   return this.origine.abscisse() + this.dimension.longueur() - 1;
	   }

	public int abscisseLaPlusAGauche() {
		   return this.origine.abscisse();
	   }

	public void seDeplacerVersLaDroite() {
		   this.origine.changerAbscisse(this.origine.abscisse() + vitesse);
	   }

	public void seDeplacerVersLaGauche() {
		   this.origine.changerAbscisse(this.origine.abscisse() - vitesse);
	   }

	public void positionner(int x, int y) {
		   this.origine.changerAbscisse(x);
		   this.origine.changerOrdonnee(y);
	   }

	public int longueur() {
		// TODO Auto-generated method stub
		return this.dimension.longueur();
	}

	public int hauteur() {
		// TODO Auto-generated method stub
		return this.dimension.hauteur();
	}

}