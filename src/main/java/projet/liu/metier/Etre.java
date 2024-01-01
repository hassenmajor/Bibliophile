package projet.liu.metier;

public class Etre {
	
	private String titre;
	private String domaine;
	
	public Etre(String titre, String domaine) {
		super();
		this.titre = titre;
		this.domaine = domaine;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	
}
