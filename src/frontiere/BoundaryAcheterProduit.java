package frontiere;


import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit,ControlVerifierIdentite controlVerifierIdentite) {
		this.controlAcheterProduit = controlAcheterProduit;
		this.controlVerifierIdentite = controlVerifierIdentite;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			System.out.println("je suis desolee "+nomAcheteur+"...");
		}
		
		String nomProduits = Clavier.entrerChaine("Quel produits voulez vous acheter?\n");
		String[] listeV = controlAcheterProduit.listeVendeur();
		int pos= 0;
		for (int i = 0; i < listeV.length; i++) {
			System.out.println((pos+1)+" - "+listeV[i]);
			
			
		}
		int idVendeur = Clavier.entrerEntier("Chez quel commercant voulez-vous acheter des "+nomProduits);
		if (controlVerifierIdentite.verifierIdentite(listeV[idVendeur-1])) {
			System.out.println("je suis desolee "+listeV[idVendeur-1]+"...");
		}
		
		System.out.println(nomAcheteur+" se deplace jusqu'a l'etal du vendeur "+listeV[idVendeur-1]);
		
		int nbproduit = Clavier.entrerEntier("Combien de "+nomProduits+" voulez vous acheter?");
		int retour = controlAcheterProduit.acheterProduit(nomProduits, nbproduit);
		if (retour ==-1) {
			System.out.println(nomAcheteur+"veut acheter "+nbproduit+" mais il n'y en a plus.");
		}
		if (retour>0) {
			System.out.println(nomAcheteur+"veut acheter "+nbproduit+" mais"+listeV[idVendeur-1]+"n'a que "+retour+" il achete tt le stock");
		}
		if (retour==0) {
			System.out.println(nomAcheteur+"veut acheter "+nbproduit+" "+nomProduits+" a "+listeV[idVendeur-1]);
		}
	}
}
