package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private ControlAfficherVillage ctrlAV; 
	
	private Village village;
	
	
	@BeforeEach
	void initControlAfficherVillage() {
		village = new Village("Village", 10, 5);
		ctrlAV = new ControlAfficherVillage(village);
		Chef chief = new Chef("Chief", 10,village);
		village.setChef(chief);
	}

	@Test
	void testNomVillage() {
		assertEquals(ctrlAV.donnerNomVillage(),"Village");
	}
	@Test
	void testControlAfficherVillage() {
		assertEquals(ctrlAV.donnerNbEtals(),5);
	}
	@Test
	void testDonnerNomVillageois() {
		ControlEmmenager ctrlEM = new ControlEmmenager(village);
		for (int i = 1; i < 5; i++) {
			ctrlEM.ajouterGaulois("Gau"+i, i);
		}
		ctrlEM.ajouterDruide("druide1", 1, 1, 5);
		String[] nomVill = ctrlAV.donnerNomsVillageois();
		assertNotNull(nomVill);
		for (int i = 1; i < nomVill.length-1; i++) {
			assertEquals(nomVill[i], "Gau"+i);
		}
		assertEquals(nomVill[5], "druide1");
		
	}
	
}
