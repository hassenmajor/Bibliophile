package projet.liu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import projet.liu.metier.*;
import projet.liu.jdbc.*;

public class LivreDao implements Dao<Livre> {
	private Connection connection;
	public LivreDao() {
		try {
			connection = DBConnection.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Livre get(String id) {
		Livre livre = null;
		String query = "SELECT * FROM Livre WHERE titre = ?";
		System.out.println();
		System.out.println(query);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				String titre = result.getString("titre");
				String soustitre = result.getString("soustitre");
				int annee = result.getInt("annee");
				String image = result.getString("image");
				String lien = result.getString("lien");
				livre = new Livre(titre, soustitre, annee, image, lien);
				System.out.println(livre.toString());
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... élément introuvable");
			e.printStackTrace();
		}
		return livre;
	}
	@Override
	public List<Livre> getAll() {
		Livre livre = null;
		ArrayList<Livre> arrayList = new ArrayList<>();
		String query = "SELECT * FROM Livre";
		System.out.println();
		System.out.println(query);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next())
				do {
					String titre = result.getString("titre");
					String soustitre = result.getString("soustitre");
					int annee = result.getInt("annee");
					String image = result.getString("image");
					String lien = result.getString("lien");
					livre = new Livre(titre, soustitre, annee, image, lien);
					System.out.println(livre.toString());
					arrayList.add(livre);
				} while (result.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... éléments introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}
	@Override
	public void save(Livre element) {
		String query = "INSERT INTO Livre(titre, soustitre, annee, image, lien) "
				+ "VALUES(?, ?, ?, ?, ?)";
		System.out.println(query);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, element.getTitre());
			preparedStatement.setString(2, element.getSoustitre());
			preparedStatement.setInt(3, element.getAnnee());
			preparedStatement.setString(4, element.getImage());
			preparedStatement.setString(5, element.getLien());
			int result = preparedStatement.executeUpdate();
			if (result>0)
				System.out.println("\tLivre enregistré !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement échoué");
			e.printStackTrace();
		}
	}
	@Override
	public void update(String id, Livre newElement) {
		String query = "UPDATE Livre SET titre=?, soustitre=?, annee=?, image=?, lien=? WHERE titre = ?";
		System.out.println(query);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newElement.getTitre());
			preparedStatement.setString(2, newElement.getSoustitre());
			preparedStatement.setInt(3, newElement.getAnnee());
			preparedStatement.setString(4, newElement.getImage());
			preparedStatement.setString(5, newElement.getLien());
			preparedStatement.setString(6, id);
			int result = preparedStatement.executeUpdate();
			if (result>0)
				System.out.println("\tLivre modifié !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification échouée");
			e.printStackTrace();
		}
	}
	@Override
	public void delete(String id) {
		String query = "DELETE FROM Livre WHERE titre = ?";
		System.out.println(query);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			int result = preparedStatement.executeUpdate();
			if (result>0)
				System.out.println("\tLivre supprimé !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression échouée");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		new LivreDao().save(Something.ORIGINAL_BOOKS[0]);
//		new LivreDao().update(Something.ORIGINAL_BOOKS[1].getTitre(), Something.ORIGINAL_BOOKS[0]);
		System.out.print("TEST : "+new LivreDao().get("Hagakure").toString());
//		new LivreDao().delete("Hagakure");
	}
}
