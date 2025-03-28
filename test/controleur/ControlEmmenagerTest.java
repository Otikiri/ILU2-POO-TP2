package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager ctlEm;
	
	@BeforeEach
	public void initializeSetUp(){
		System.out.println("Init test 1...");
		Village village = new Village("village test",10,5);
		ctlEm = new ControlEmmenager(village);
		Chef chief = new Chef("Chief",10,village); 
		village.setChef(chief);
	}

	@Test
	public void testIsHabitant() {
		ctlEm.ajouterGaulois("Bone", 1);
		assertTrue(ctlEm.isHabitant("Bone"));
		assertFalse(ctlEm.isHabitant("Greg"));
		ctlEm.ajouterDruide("Abra", 5, 1, 5);
		assertTrue(ctlEm.isHabitant("Abra"));
	}
	
	@Test
	public void testAjouterGaulois() {
		for (int i = 1; i < 13; i++) {
			ctlEm.ajouterGaulois("Gau"+i, i);
		}
		assertTrue(ctlEm.isHabitant("Gau2"));
		assertTrue(ctlEm.isHabitant("Gau10")); 
		assertFalse(ctlEm.isHabitant("Gau13"));
	}
	
	
	@Test
	public void testChefisHab() {
		assertTrue(ctlEm.isHabitant("Chief"));
	}
}
