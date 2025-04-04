package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private ControlAfficherMarche ctrlMarche; 
	private Village village;
	@BeforeEach
	void setUp() {
		village = new Village("TestVillage",10,5);
		ctrlMarche = new ControlAfficherMarche(village);
		Chef chief = new Chef("TestChef",1,village);
		village.setChef(chief);
	}

	@Test
	void testValeurRetourne() {
		Gaulois test1 = new Gaulois("test1",1);
		village.ajouterHabitant(test1);
		village.installerVendeur(test1,"testValue", 2);
		assertNotNull(ctrlMarche.donnerInfoMarche());
	}

}
