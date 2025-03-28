package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite ctrlID; 
	private Village vill;
	
	@BeforeEach
	void setUp(){
		vill = new Village("Village", 10, 5);
		ctrlID = new ControlVerifierIdentite(vill);
		Chef chief = new Chef("Chief", 0, vill);
		vill.setChef(chief);
	}

	@Test
	void testVerifierIdentite() {
		//TODO
	}

}
