package bowling;

public class PartieMultiJoueurs implements IPartieMultiJoueurs {
	
	//attributs
	private String[] nomsDesJoueurs;
	private PartieMonoJoueur[] parties;
	private int indiceJoueurActuel;
	
	
	/**
	 * Démarre une nouvelle partie pour un groupe de joueurs
	 * @param nomsDesJoueurs un tableau des noms de joueurs (il faut au moins un joueur)
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 1, boule n° 1"
	 * @throws java.lang.IllegalArgumentException si le tableau est vide ou null
	 */
	public String demarreNouvellePartie(String[] nomsDesJoueurs){
		if (nomsDesJoueurs == null ||  nomsDesJoueurs.length == 0){
			throw new IllegalArgumentException( "Il faut au moins un joueur.");
		}
		else {
			//on créait la partie multijoueurs
			parties = new PartieMonoJoueur[ nomsDesJoueurs.length ];
			for (int i = 0; i < nomsDesJoueurs.length; i++){
				parties[0] = new PartieMonoJoueur();
			}
			
		}
		indiceJoueurActuel = 0;
		return "Prochain tir : joueur " + nomsDesJoueurs[0] + "tour n° " + parties[0].numeroTourCourant() +" boule n° " + parties[0].numeroProchainLancer();
	} 

	/**
	 * Enregistre le nombre de quilles abattues pour le joueur courant, dans le tour courant, pour la boule courante
	 * @param nombreDeQuillesAbattues : nombre de quilles abattue à ce lancer
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 2",
	 * ou bien "Partie terminée" si la partie est terminée.
	 * @throws java.lang.IllegalStateException si la partie n'est pas démarrée.
	 */
	public String enregistreLancer(int nombreDeQuillesAbattues){
		
		if (nombreDeQuillesAbattues <= 0){
			throw new IllegalArgumentException( "Pas de nb de quilles négatif ou nul.");
		}
		
		else {
			
			int indiceProchainJoueur = 0;
		
			if ( !parties[indiceJoueurActuel].enregistreLancer(  nombreDeQuillesAbattues ) ){ //l'instruction s'execute dans le if

				if (indiceJoueurActuel + 1 <= parties.length){
					indiceProchainJoueur = indiceJoueurActuel + 1;

				}
			
			}
		
			else{
				indiceProchainJoueur = indiceJoueurActuel;
			}


			indiceJoueurActuel = indiceProchainJoueur;
		
			return "Prochain tir : joueur " + nomsDesJoueurs[indiceJoueurActuel] + "tour n° " + parties[indiceJoueurActuel].numeroTourCourant() +" boule n° " + parties[indiceJoueurActuel].numeroProchainLancer();

		}
	} 

	/**
	 * Donne le score pour le joueur playerName
	 * @param nomDuJoueur le nom du joueur recherché
	 * @return le score pour ce joueur
	 * @throws IllegalArgumentException si nomDuJoueur ne joue pas dans cette partie
	 */
	public int scorePour(String nomDuJoueur){
		int indiceJoueurRecherche = 0;
		for(int i = 0; i < nomsDesJoueurs.length; i++){
			if (nomDuJoueur.equals(nomsDesJoueurs[i]) ){
				return parties[indiceJoueurRecherche].score();
			}
		}
		throw new IllegalArgumentException("Le nom n'est pas dans la liste des joueurs");

	}
	
	//Getters
	public String[] getNomsDesJoueurs() {
		return nomsDesJoueurs;
	}
	
	
 



}
