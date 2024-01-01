package projet.liu.dao;

import projet.liu.metier.*;

public class Something {
	
	public static String[] SQL_DROP_TABLES = new String[] {
			"DROP TABLE Avoir;",
			"DROP TABLE Etre;",
			"DROP TABLE Livre;",
			"DROP TABLE Auteur;",
			"DROP TABLE Discipline;",
	};
	public static String[] SQL_CREATE_TABLES = new String[] {
			"CREATE TABLE Livre( titre VARCHAR(100), soustitre VARCHAR(200), annee SMALLINT, image VARCHAR(400), lien VARCHAR(400), PRIMARY KEY(titre) );",
			"CREATE TABLE Auteur( nom VARCHAR(50), nation VARCHAR(50), photo VARCHAR(400), PRIMARY KEY(nom) );",
			"CREATE TABLE Discipline( domaine VARCHAR(50), wiki VARCHAR(400), PRIMARY KEY(domaine) );",
			"CREATE TABLE Avoir( titre VARCHAR(100), nom VARCHAR(50), PRIMARY KEY(titre, nom), FOREIGN KEY(titre) REFERENCES Livre(titre), FOREIGN KEY(nom) REFERENCES Auteur(nom) );",
			"CREATE TABLE Etre( titre VARCHAR(100), domaine VARCHAR(50), PRIMARY KEY(titre, domaine), FOREIGN KEY(titre) REFERENCES Livre(titre), FOREIGN KEY(domaine) REFERENCES Discipline(domaine) );",
	};
	public static String SQL_SET_TIMEZONE = "SET time_zone = '+00:00';";
	public static Livre DEFAULT_BOOK = new Livre("", "Sous-titre ou description", 0, "http://url_image", "http://url_document");
	
	public static Livre[] ORIGINAL_BOOKS = new Livre[] {
			new Livre("Hagakure", "Le livre secret des Samouraïs", 1716, "https://products-images.di-static.com/image/jocho-yamamoto-hagakure/9782857071440-475x500-1.jpg", "http://sylvainniavlys.free.fr/vox/Japon/Jocho%20Yamamoto%20-%20Hagakure%20-%20Le%20livre%20secret%20des%20Samoura%EFs.pdf"),
			new Livre("Ainsi parlait Zarathoustra", "Un livre pour tous et pour personne", 1885, "https://m.media-amazon.com/images/I/41emAgcO6dL._AC_UF1000,1000_QL80_.jpg", "https://philosophie-pedagogie.web.ac-grenoble.fr/sites/default/files/media-fichiers/2021-07/nietzsche_zarathoustra.pdf"),
			new Livre("Traité des cinq roues", "J'ai voulu exprimer, pour la première fois la voie de ma tactique.", 1645, "https://servimg.eyrolles.com/static/media/0276/9782382390276_internet_w290.jpg", "http://www.budokan-vernier.ch/livrespdf/TRAITE%20DES%20CINQ%20ROUES.pdf"),
			new Livre("Le Kybalion", "Les lèvres de la Sagesse sont closes, excepté aux oreilles de la Raison.", 1908, "https://images.epagine.fr/975/9791041815975_1_75.jpg", "https://coach-ngo.com/wp-content/uploads/2018/05/kybalionFr.pdf"),
			new Livre("Pensées pour moi-même", "Pour moi, j'ai en ce moment ce que la commune nature veut que j'aie à ce moment, et je fais ce que ma nature exige qu'à ce moment je fasse.", -170, "https://images.epagine.fr/923/9782322223923_1_75.jpg", "http://ugo.bratelli.free.fr/MarcAurele/MarcAurelePensees.pdf"),
			new Livre("Discours de la méthode", "Pour bien conduire sa raison et chercher la vérité dans les sciences", 1637, "https://images.epagine.fr/412/9782253067412_1_75.jpg", "https://philosophie.cegeptr.qc.ca/wp-content/documents/Discours-de-la-m%C3%A9thode.pdf"),
			new Livre("Aphorismes sur la sagesse dans la vie", "Le bonheur n’est pas chose aisée : il est très difficile de le trouver en nous, et impossible de le trouver ailleurs.", 1851, "https://www.schopenhauer.fr/oeuvres/images/aphorismes.jpg", "https://www.schopenhauer.fr/oeuvres/fichier/aphorismes-sur-la-sagesse-dans-la-vie.pdf"),
			new Livre("L'Art de la guerre", "Connais ton ennemi et connais-toi toi-même ; eussiez-vous cent guerres à soutenir, cent fois vous serez victorieux.", -300, "https://m.media-amazon.com/images/I/81n+Og9CkSL._AC_UF1000,1000_QL80_.jpg", "http://www.taopratique.fr/wp-content/uploads/Art_de_la_guerre.pdf"),
			/*new Livre("Rues Barbares", "Survivre en ville", 2012, "https://m.media-amazon.com/images/I/71Wd+gFOsuL._AC_UF1000,1000_QL80_.jpg", "https://www.fichier-pdf.fr/2019/04/17/rues-barbares-piero-san-giorgio/rues-barbares-piero-san-giorgio.pdf"),*/
	};
	
}
