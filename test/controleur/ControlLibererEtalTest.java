package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlLibererEtal ctrlLE;
	private ControlTrouverEtalVendeur ctrlTEV;
	private Village village;
	private ControlEmmenager ctrlEM; 
	private ControlPrendreEtal ctrlPE;
	
	@BeforeEach
	void setUp() throws Exception {
		village = new Village("TestVillage",10,5);
		Chef chef = new Chef("TestChef",1,village);
		village.setChef(chef);
		ctrlTEV = new ControlTrouverEtalVendeur(village);
		ctrlLE = new ControlLibererEtal(ctrlTEV);
		ctrlPE = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		ctrlEM = new ControlEmmenager(village);
	}

	@Test
	void testTrouverEtalVendeur() {
		
		ctrlEM.ajouterGaulois("TestV1", 1);
		ctrlPE.prendreEtal("TestV1", "testValue1", 10);
		
		assertTrue(ctrlLE.trouverEtalVendeur("TestV1"));
		assertFalse(ctrlLE.trouverEtalVendeur("TestV2"));
	}

	@Test
	void testLibererEtal() {
		for (int i = 0; i < 5; i++) {
			ctrlEM.ajouterGaulois("Test"+i, i+1);
		}
		for (int i = 0; i < 2; i++) {
			ctrlPE.prendreEtal("Test"+i,"Prod"+i, 2);
		}
		String[] value = ctrlLE.libererEtal("Test0");
		StringBuilder etal = new StringBuilder();
		for (int i = 0; i < value.length; i++) {
			etal.append(value[i]);
		}
		for (int i = 0; i < value.length; i++) {
			assertTrue(etal.toString().contains(value[i]));
		}
		assertNull(ctrlLE.libererEtal("Test4"));
	}
	

}
