package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite ctrlID; 
	private Village vill;
	
	@BeforeEach
	void setUp(){
		vill = new Village("Village", 10, 5);
		ctrlID = new ControlVerifierIdentite(vill);
		Chef chief = new Chef("Chief", 1, vill);
		vill.setChef(chief);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois test = new Gaulois("test1",2);
		Druide testD = new Druide("testD1",2,1,5);
		vill.ajouterHabitant(test);
		vill.ajouterHabitant(testD);
		assertTrue(ctrlID.verifierIdentite("Chief"));
		assertTrue(ctrlID.verifierIdentite("test1")); 
		assertTrue(ctrlID.verifierIdentite("testD1"));
		assertFalse(ctrlID.verifierIdentite("test2"));
		assertFalse(ctrlID.verifierIdentite("testD2"));
	}

}
