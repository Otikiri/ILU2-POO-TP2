package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private ControlTrouverEtalVendeur ctrlTEV;
	private Village village;
	
	@BeforeEach
	void setUp() throws Exception {
		village = new Village("TestVillage",10,5);
		Chef chef = new Chef("ChiefTest",10,village);
		ctrlTEV = new ControlTrouverEtalVendeur(village);
		village.setChef(chef);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
