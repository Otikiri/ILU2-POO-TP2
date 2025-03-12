package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peux vous trouver un libre");
			if (controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);
			}
			else {
				System.out.println("Desole "+nomVendeur+" je n'ai plus d'etal qui n'est pas deja occupe");
			}
		}
		else {
			System.out.println("Desole "+nomVendeur+" mais il faut etre un habitant dans le village pour commercer ici\n");
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfaoit, il me reste un etal pour vous \n");
		System.out.println("Il me faudrait quelques renseignement :\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre?");
		int nbprod = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		controlPrendreEtal.prendreEtal(nomVendeur, produit, nbprod);
	}
}
