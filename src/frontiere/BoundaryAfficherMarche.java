package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] donneMarche = controlAfficherMarche.donnerInfoMarche();
		if (donneMarche.length==0) {
			System.out.println("le marche est vide revenez plus tard");
		}
		else {
			System.out.println(nomAcheteur+", vous trouverez au marche : ");
			for (int i = 0; i < donneMarche.length; i+=3) {
				System.out.println("-"+donneMarche[i]+" qui vend "+donneMarche[i+1]+" "+donneMarche[i+2]);
			}
		}
	}
}
		