package classe.pizza;

/**
 * @author Amandine
 * 
 *         Au démarrage l’application vous devez afficher le menu suivant :          
 		***** Pizzeria Administration ***** 
 *         1. Lister les pizzas 
 *         2. Ajouter une nouvelle pizza 
 *         3. Mettre à jour une pizza 
 *         4. Supprimer une pizza 
 *         99.Sortir
 */

public class Pizza {

	// attributs de la classe Pizza
	
	public int id;
	public String code;
	public String designation;
	public double prix;

	public static int compteur; // sera amené à donne un id unique pr chaque pizza

	// génération du constructeur
	
	/**
	 * @param id  : identifiant unique pour chaque Pizza, ex : id : 1
	 * @param code : identifiant unique, ex : Code : MAR
	 * @param designation : ex : Désignation : MARGARITTA
	 * @param prix : ex : Prix : 9,20 euros
	 */
	
	public Pizza(int id, String code, String designation, double prix) {
		this.id = ++compteur; // incrémentation de l'id en fonction de la liste
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}

	// méthode toString
	
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", designation=" + designation + ", prix=" + prix + "]";
	}

	//getter/setter
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getCompteur() {
		return compteur;
	}

}
