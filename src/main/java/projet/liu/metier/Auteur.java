package projet.liu.metier;

public class Auteur {
	
	private String nom;
	private String langue;
	private String photo;
	
	public Auteur(String nom, String langue, String photo) {
		super();
		this.nom = nom;
		this.langue = langue;
		this.photo = photo;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
