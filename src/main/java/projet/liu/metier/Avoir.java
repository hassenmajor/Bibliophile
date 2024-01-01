package projet.liu.metier;

public class Avoir {
	
	private String titre;
	private String nom;
	
	public Avoir(String titre, String nom) {
		super();
		this.titre = titre;
		this.nom = nom;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
