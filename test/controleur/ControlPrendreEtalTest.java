package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	ControlVerifierIdentite ctrlVI;
	ControlPrendreEtal ctrlPE;
	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Test1",10,5);
		ctrlVI = new ControlVerifierIdentite(village);
		ctrlPE = new ControlPrendreEtal(ctrlVI, village);
		Chef chief = new Chef("TestChief",1,village);
		village.setChef(chief);
	}

	@Test
	void testResteEtals() {
		
		assertTrue(ctrlPE.resteEtals());
		ControlEmmenager ctrlEM = new ControlEmmenager(village);
		for (int i = 1; i <= 5; i++) {
			ctrlEM.ajouterGaulois("Test"+i, i);
			ctrlPE.prendreEtal("Test"+i,"Produit"+i, i);
		}
		assertFalse(ctrlPE.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlEmmenager ctrlEM = new ControlEmmenager(village);
		for (int i = 0; i < 5; i++) {
			ctrlEM.ajouterGaulois("Test"+i, i+1);
			assertTrue(ctrlPE.prendreEtal("Test"+i,"Produit"+i, i+1)>=0);
		}
	}

	@Test
	void testVerifierIdentite() {
		ControlEmmenager ctrlEM = new ControlEmmenager(village);
		for (int i = 0; i < 5; i++) {
			ctrlEM.ajouterGaulois("Test"+i, i+1);
		}
		assertTrue(ctrlPE.verifierIdentite("Test0"));
		assertTrue(ctrlPE.verifierIdentite("Test4"));
		assertFalse(ctrlPE.verifierIdentite("AAAAAAA"));
	}

}
