package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiPlayerGameTest {
	
	private PartieMultiJoueurs partie;
	@BeforeEach
	public void setUp() {
		
		partie = new PartieMultiJoueurs( );
	}
	
	@Test
	void testCreationPartieListeJoueursVide() {
		
		String[] listeNomsJoueurs = new String[0];
		try {
			partie.demarreNouvellePartie( listeNomsJoueurs);
		} catch (Exception e) {
			
		}
	}
	@Test
	void testLancerNbQuillesNegatifOuNul() {
		int nbQuilles = -1;
		try {
			partie.enregistreLancer( nbQuilles);
		}catch (Exception e) {
			
		}
		
	}
	@Test
	void testNomPasDansListeJoueurs() {
		try {
			partie.scorePour("Bertrand");
		}catch (Exception e) {
		}
	}
	@Test
	void testDemarragePartie() {
		String[] listeJoueurs = new String[3];
		listeJoueurs[0] = "Valentin";
		listeJoueurs[1] = "Jules";
		listeJoueurs[2] = "Arthur";
		boolean fonctionne = true;
		partie.demarreNouvellePartie( listeJoueurs);
		if ( partie.getNomsDesJoueurs() != null ){
			fonctionne = false;
		}
		else{
			if(partie.getNomsDesJoueurs().length != 0){
				fonctionne = false;
			}
		}
		assertTrue( fonctionne );
	}
	
	
	
}

