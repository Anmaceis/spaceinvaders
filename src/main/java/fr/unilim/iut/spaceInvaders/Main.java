package fr.unilim.iut.spaceInvaders;
import fr.unilim.iut.spaceInvaders.*;
import fr.unilim.iut.spaceInvaders.moteurjeu.DessinJeu;
import fr.unilim.iut.spaceInvaders.moteurjeu.MoteurGraphique;

public class Main {
	public static void main(String[] args) {
		SpaceInvaders spaceInvaders= new SpaceInvaders(Constante.ESPACEJEU_LONGUEUR, Constante.ESPACEJEU_HAUTEUR);
		spaceInvaders.initialiserJeu();
		DessinMonJeu dessin = new DessinMonJeu(spaceInvaders);
		
		MoteurGraphique moteur = new MoteurGraphique(spaceInvaders, dessin);
		try {
			moteur.lancerJeu(Constante.ESPACEJEU_LONGUEUR, Constante.ESPACEJEU_HAUTEUR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
