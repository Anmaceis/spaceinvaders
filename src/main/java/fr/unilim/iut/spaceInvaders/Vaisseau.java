package fr.unilim.iut.spaceInvaders;

public class Vaisseau {

	int x;
	int y;
	int longueur;
	int hauteur;

	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}

    public Vaisseau(int longueur, int hauteur, int x, int y) {
	   this.longueur=longueur;
	   this.hauteur=hauteur;
	   this.x = x;
	   this.y = y;
    }

	public boolean occupeLaPosition(int x, int y) {
	     return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
    }

	private boolean estOrdonneeCouverte(int y) {
		return ordonneeLaPlusBasse(y) && ordonneeLaPlusHaute(y);
	}

	private boolean ordonneeLaPlusHaute(int y) {
		return y<=this.y;
	}

	private boolean ordonneeLaPlusBasse(int y) {
		return this.y-this.hauteur+1<=y;
	}

	private boolean estAbscisseCouverte(int x) {
		return (absicissLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	private int abscisseLaPlusADroite() {
		return this.x+this.longueur-1;
	}

	public void seDeplacerVersLaDroite() {
		this.x = this.x + 1;
		
	}
	
	public void seDeplacerVersLaGauche() {
		this.x = this.x - 1;
		
	}
	public int absicissLaPlusAGauche() {
		return this.x;
	}

	public void positionner(int x, int y) {
	    this.x = x;
	    this.y = y;
    }

	public int absicissLaPlusADroite() {
		return this.x;
	}


	

}