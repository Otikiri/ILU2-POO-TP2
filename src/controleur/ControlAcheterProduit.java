package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	
	public String[] listeVendeur() {
		String[] donneMarche = village.donnerEtatMarche();
		int sizeliste = village.donnerNbEtal();
		String[] listeV = new String[sizeliste];
		int pos = 0; 
		for (int i = 0; i < donneMarche.length; i+=3) {
			listeV[pos] = donneMarche[i];
			pos++;
			
		}
		return listeV;
	}
	
	public int acheterProduit(String nomVendeur,int vendu) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int nbProduit = etal.getQuantite();
		if (nbProduit==0) {
			return -1;
		}
		if (nbProduit<vendu) {
			int venduR = vendu-nbProduit;
			etal.acheterProduit(venduR);
			return nbProduit;
		}
		else {
			etal.acheterProduit(vendu);
			return 0;
		}
	}
}
