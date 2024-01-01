<%@page import="projet.liu.dao.*" %>
<%@page import="projet.liu.metier.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	// CONTROLLER CODE
	LivreDao dao = new LivreDao();
	String ancienTitre = request.getParameter("ancienTitre");
	if (ancienTitre!=null) {
		Livre nouveauLivre = new Livre(request.getParameter("titre"), 
				request.getParameter("soustitre"), 
				Integer.parseInt(request.getParameter("annee")), 
				request.getParameter("image"), 
				request.getParameter("lien"));
		if (dao.get(ancienTitre)!=null)
			dao.update(request.getParameter("ancienTitre"), nouveauLivre);
		else
			dao.save(nouveauLivre);
	}
	//
	String titre = request.getParameter("titre");
	Livre livre = dao.get(titre);
	if (livre==null)
		livre = Something.DEFAULT_BOOK;
/* 	livre = Something.ORIGINAL_BOOKS[7]; */

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%= livre.getTitre().length()>0? livre.getTitre():"Ajouter un nouveau livre" %></title>
		<!-- <link rel="stylesheet" type="text/css" href="public/style.css"> -->
		<style type="text/css">
			header {
				padding: 10px;
			}
			header img {
				width: 70%;
				max-width: 600px;
			}
			body {
				padding: 0;
				margin: 0;
				text-align: center;
				font-family: 'helvetica', san-serif;
				background-color: #829093;
				background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 56 28' width='56' height='28'%3E%3Cpath fill='%23262a2b' fill-opacity='0.4' d='M56 26v2h-7.75c2.3-1.27 4.94-2 7.75-2zm-26 2a2 2 0 1 0-4 0h-4.09A25.98 25.98 0 0 0 0 16v-2c.67 0 1.34.02 2 .07V14a2 2 0 0 0-2-2v-2a4 4 0 0 1 3.98 3.6 28.09 28.09 0 0 1 2.8-3.86A8 8 0 0 0 0 6V4a9.99 9.99 0 0 1 8.17 4.23c.94-.95 1.96-1.83 3.03-2.63A13.98 13.98 0 0 0 0 0h7.75c2 1.1 3.73 2.63 5.1 4.45 1.12-.72 2.3-1.37 3.53-1.93A20.1 20.1 0 0 0 14.28 0h2.7c.45.56.88 1.14 1.29 1.74 1.3-.48 2.63-.87 4-1.15-.11-.2-.23-.4-.36-.59H26v.07a28.4 28.4 0 0 1 4 0V0h4.09l-.37.59c1.38.28 2.72.67 4.01 1.15.4-.6.84-1.18 1.3-1.74h2.69a20.1 20.1 0 0 0-2.1 2.52c1.23.56 2.41 1.2 3.54 1.93A16.08 16.08 0 0 1 48.25 0H56c-4.58 0-8.65 2.2-11.2 5.6 1.07.8 2.09 1.68 3.03 2.63A9.99 9.99 0 0 1 56 4v2a8 8 0 0 0-6.77 3.74c1.03 1.2 1.97 2.5 2.79 3.86A4 4 0 0 1 56 10v2a2 2 0 0 0-2 2.07 28.4 28.4 0 0 1 2-.07v2c-9.2 0-17.3 4.78-21.91 12H30zM7.75 28H0v-2c2.81 0 5.46.73 7.75 2zM56 20v2c-5.6 0-10.65 2.3-14.28 6h-2.7c4.04-4.89 10.15-8 16.98-8zm-39.03 8h-2.69C10.65 24.3 5.6 22 0 22v-2c6.83 0 12.94 3.11 16.97 8zm15.01-.4a28.09 28.09 0 0 1 2.8-3.86 8 8 0 0 0-13.55 0c1.03 1.2 1.97 2.5 2.79 3.86a4 4 0 0 1 7.96 0zm14.29-11.86c1.3-.48 2.63-.87 4-1.15a25.99 25.99 0 0 0-44.55 0c1.38.28 2.72.67 4.01 1.15a21.98 21.98 0 0 1 36.54 0zm-5.43 2.71c1.13-.72 2.3-1.37 3.54-1.93a19.98 19.98 0 0 0-32.76 0c1.23.56 2.41 1.2 3.54 1.93a15.98 15.98 0 0 1 25.68 0zm-4.67 3.78c.94-.95 1.96-1.83 3.03-2.63a13.98 13.98 0 0 0-22.4 0c1.07.8 2.09 1.68 3.03 2.63a9.99 9.99 0 0 1 16.34 0z'%3E%3C/path%3E%3C/svg%3E");
			}
			section {
				margin: 40px auto;
				padding: 10px;
				color: #b7b7b7;
				background: #262a2b88;
				border: 1px solid #252727;
				border-radius: 10px;
				text-align: left;
				max-width: 80vw;
			}
			section img {
				max-width: 230px;
			}
			section form {
				margin: 10px;
				min-width: 330px;
				max-width: 60%;
				padding-bottom: 20px;
			}
			section img, section form {
				display: inline-block;
				vertical-align: top;
				margin: 10px;
			}
			section form h3, #titre {
				font-size: 20px;
				color: #b7b7b7;
				margin-bottom: 5px;
				background: transparent;
			}
			header h3 {
				font-size: 20px;
				color: #e7e7e7;
				margin-bottom: 5px;
  				text-shadow: 3px 3px 3px black;
			}
			header p {
				font-size: 20px;
				color: #e7e7e7;
				margin-bottom: 5px;
  				text-shadow: 3px 3px 3px black;
			}
			header p a {
				text-decoration: none;
				color: #e7e7e7;
				font-style: oblique;
			}
			header p a:hover {
				text-decoration: underline;
			}
			section form p, #soustitre, #annee, #lien, #image {
				font-size: 16px;
				line-height: 18px;
				color: #b7b7b7;
				margin-top: 5px;
				background: transparent;
			}
			input, textarea {
				width: 90%;
				border: 1px solid;
				border-radius: 5px;
			}
			textarea {
				font-family: 'helvetica', san-serif;
				min-height: 80px;
				min-width: 90%;
				max-width: 90%;
			}
			.button {
				position: relative;
				text-decoration: none;
				font-family: 'helvetica', san-serif;
				font-size: 16px;
				border: 1px solid #b7b7b7;
				padding: 10px;
				margin: 5px;
				color: #b7b7b7;
				border-radius: 3px;
				overflow: hidden;
				background: #262a2b88;
				cursor: pointer;
			}
			.button:hover {
				color: #262a2b;
				background-color: #b7b7b7;
			}
			.hidden {
				visibility: hidden;
				display: none;
			}
		</style>
	</head>
	<body>
		<header>
			<a href="<%= application.getContextPath() %>/index.jsp"><img alt="Bibliophile" src="public/bibliophile.gif"></a>
			<div>
				<h3>Mini-projet de bibliothèque participative 📚</h3>
				<div>
					<br>
					<a href="<%= application.getContextPath()+"/livre.jsp?titre=?" %>" class="button">Ajouter un nouveau livre</a>
				</div>
			</div>
		</header>
		<section>
			<img alt="couverture <%= livre.getTitre() %>" src="<%= livre.getImage() %>" class="<%= livre.getTitre().length()>0? "":"hidden" %>">
			<form method="post" action="<%= application.getContextPath()+"/livre.jsp" %>">
				<div class="mode-normal <%= livre.getTitre().length()>0? "":"hidden" %>">
					<h3><%= livre.getTitre() %></h3>
					<p>
						<%
							out.print(livre.getSoustitre());
							out.print("<br><br>Rédigé en "+livre.getAnnee());
						%>
					</p>
					<br>
					<a href="<%= livre.getLien() %>" class="button" target="_BLANK">Télécharger</a>
					<a class="button" onclick="modifier()">Modifier</a>
					<a class="button" onclick="supprimer()">Supprimer</a>
				</div>
				<div class="mode-editable <%= livre.getTitre().length()>0? "hidden":"" %>">
					<input id="titre" type="text" value="<%= livre.getTitre() %>" name="titre" placeholder="Titre du livre" maxlength="100"><br>
					<textarea id="soustitre" name="soustitre" maxlength="200"><%
							out.print(livre.getSoustitre());
					%></textarea><br>
					<input id="annee" type="number" value="<%= livre.getAnnee() %>" name="annee" placeholder="Année de rédaction"><br>
					<input id="image" type="url" value="<%= livre.getImage() %>" name="image" placeholder="Url de la couverture (jpg, jpeg, png)" maxlength="400"><br>
					<input id="lien" type="url" value="<%= livre.getLien() %>" name="lien" placeholder="Url du document (pdf, epub, docx)" maxlength="400"><br>
					<br>
					<button class="button" type="submit">Enregister</button>
					<a class="button" onclick="annuler()">Annuler</a>
					<input id="ancienTitre" type="hidden" name="ancienTitre" value="<%= livre.getTitre() %>">
				</div>
			</form>
		</section>
		<script type="text/javascript">
			let ancienTitre = document.querySelector("#ancienTitre").value;
			function supprimer() {
				if (confirm("Supprimer ce livre définitivement ?"))
					window.location.href="/Bibliophile/index.jsp?ancienTitre="+ancienTitre;
			}
			function modifier() {
				document.querySelector(".mode-normal").classList.add("hidden");
				document.querySelector(".mode-editable").classList.remove("hidden");
			}
			function annuler() {
				if (ancienTitre.length>0) {					
					document.querySelector(".mode-editable").classList.add("hidden");
					document.querySelector(".mode-normal").classList.remove("hidden");
				}
				else
					window.location.href="/Bibliophile/index.jsp";
			}
		</script>
	</body>
</html>
