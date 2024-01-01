package projet.liu.metier;

public class Livre {
	
	private String titre;
	private String soustitre;
	private int annee;
	private String image;
	private String lien;
	
	public Livre(String titre, String soustitre, int annee, String image, String lien) {
		super();
		this.titre = titre;
		this.soustitre = soustitre;
		this.annee = annee;
		this.image = image;
		this.lien = lien;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSoustitre() {
		return soustitre;
	}
	public void setSoustitre(String soustitre) {
		this.soustitre = soustitre;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", annee=" + annee + ", soustitre=" + soustitre + "]";
	}
	
}
