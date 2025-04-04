package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private ControlTrouverEtalVendeur ctrlTEV; 
	private Village village; 
	
	@BeforeEach
	void setUp() throws Exception {
		village = new Village("testVillage",10,5);
		Chef chef = new Chef("Chief",10,village);
		village.setChef(chef);
		ctrlTEV = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlEmmenager ctrlEM = new ControlEmmenager(village);
		ControlPrendreEtal ctrlPE = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		for (int i = 0; i < 5; i++) {
			ctrlEM.ajouterGaulois("Test"+i, i+1);
		}
		ctrlPE.prendreEtal("Test0", "p0", 10);
		ctrlPE.prendreEtal("Test1", "p1", 10);
		assertNotNull(ctrlTEV.trouverEtalVendeur("Test0"));
		assertNotNull(ctrlTEV.trouverEtalVendeur("Test1"));
		assertNull(ctrlTEV.trouverEtalVendeur("Test2"));
	}

}
