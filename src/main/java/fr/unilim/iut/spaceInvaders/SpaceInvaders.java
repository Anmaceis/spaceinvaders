package fr.unilim.iut.spaceInvaders;
import fr.unilim.iut.spaceInvaders.utils.*;
import fr.unilim.iut.spaceInvaders.moteurjeu.*;


public class SpaceInvaders implements Jeu{

	    
		int longueur;
	    int hauteur;
	    Missile missile;
	    Vaisseau vaisseau;


	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	   }

		public String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
				}
				espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
			}
			return espaceDeJeu.toString();
		}
	   

		public void deplacerVaisseauVersLaDroite() {
			if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
				vaisseau.seDeplacerVersLaDroite();
				if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
					vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
				}
			}
		}

		public void deplacerVaisseauVersLaGauche() {
			if (0 < vaisseau.abscisseLaPlusAGauche())
				vaisseau.seDeplacerVersLaGauche();
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
			}
		}
		
		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}
		
		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}
		
		public boolean aUnVaisseau() {
			return vaisseau!=null;
		}
		
		private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
			return this.aUnMissile() && missile.occupeLaPosition(x, y);
		}
		
		public boolean aUnMissile() {
			return missile!=null;
		}
	    
		private char recupererMarqueDeLaPosition(int x, int y) {
			char marque;
			if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
				marque = Constante.MARQUE_VAISSEAU;
			else if (this.aUnMissileQuiOccupeLaPosition(x, y))
					marque = Constante.MARQUE_MISSILE;
			else marque = Constante.MARQUE_VIDE;
			return marque;
		}
		
		
		public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {
			
			int x = position.abscisse();
			int y = position.ordonnee();
			
			if (!estDansEspaceJeu(x, y))
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

			int longueurVaisseau = dimension.longueur();
			int hauteurVaisseau = dimension.hauteur();
			
			if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
			if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

			vaisseau = new Vaisseau(dimension,position,vitesse);
		}

		@Override
		public void evoluer(Commande commandeUser) {
			// TODO Auto-generated method stub
			if(commandeUser.gauche) {
				vaisseau.seDeplacerVersLaGauche();
			}
			if(commandeUser.droite) {
				vaisseau.seDeplacerVersLaDroite();
			}
		}

		@Override
		public boolean etreFini() {
			// TODO Auto-generated method stub
			return false;
		}

		public void initialiserJeu() {
			Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
			Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
			positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
		 }

		public Vaisseau recupererVaisseau() {
			// TODO Auto-generated method stub
			return this.vaisseau;
		}

		public void tirerUnMissile(Dimension dimension, int vitesse) {
			this.missile = this.vaisseau.tirerUnMissile(dimension,vitesse);
		}
   }