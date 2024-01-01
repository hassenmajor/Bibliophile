package projet.liu.metier;

public class Discipline {
	
	private String domaine;
	private String wiki;
	
	public Discipline(String domaine, String wiki) {
		super();
		this.domaine = domaine;
		this.wiki = wiki;
	}

	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getWiki() {
		return wiki;
	}
	public void setWiki(String wiki) {
		this.wiki = wiki;
	}
	
}
