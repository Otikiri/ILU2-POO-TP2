package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					controlEmmenager.ajouterGaulois(nomVisiteur, choixUtilisateur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide"+nomVisiteur);
		StringBuilder question = new StringBuilder(); 
		question.append("Quelle est votre force?\n");
		int force = -1;
		while (force <0) {
			force = Clavier.entrerEntier(question.toString());
		}
		int effetPotionMax= -1,effetPotionMin=0;
		while (effetPotionMax<effetPotionMin) {
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produiser?"); 
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe dans le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
