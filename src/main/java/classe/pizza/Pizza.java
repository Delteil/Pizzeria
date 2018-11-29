package classe.pizza;

import fr.pizzeria.exception.StockageExceptionMere;
import fr.pizzeria.model.CategoriePizzaEnum;

/**
 * @author Amandine
 * 
 *         Au démarrage l’application vous devez afficher le menu suivant :
 *****         Pizzeria Administration ***** 1. Lister les pizzas 2. Ajouter une
 *         nouvelle pizza 3. Mettre à jour une pizza 4. Supprimer une pizza
 *         99.Sortir
 */

public class Pizza {

	// attributs de la classe Pizza

	public int idPizza;
	public String code = "";
	public String designation = "";
	public Double prix = null;
	private CategoriePizzaEnum categoriePizza; // ajout de l'attribut catergoriePizza de type Enum

	public static int lastId = -1; // sera amené à donner un id unique pr chaque pizza

	// attributs pour le controle des exceptions

	public static final String CODE = "";
	public static final String DESIGNATION = "";
	public static final Double PRIX_MIN = 5.0;
	public static final Double PRIX_MAX = 50.0;

	// génération du constructeur

	/**
	 * @param id          : identifiant unique pour chaque Pizza, ex : id : 1
	 * @param code        : identifiant unique, ex : Code : MAR
	 * @param designation : ex : Désignation : MARGARITTA
	 * @param i        : ex : Prix : 9,20 euros
	 */

	public Pizza(String code, String designation, Double prix, CategoriePizzaEnum categoriePizza) {
		this.idPizza = ++lastId; // incrémentation de l'id en fonction de la liste
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.categoriePizza = categoriePizza; // ajout dans le constructeur

	}

	// méthode toString

	public String toString() {
		return code + "-> " + designation + " (" + prix + ")" + " " + categoriePizza;
		// méthode Ajout Pizza

	}

	// controle des exceptions

	public void CheckPizza() throws StockageExceptionMere {

		String message = "";

		if (code.length() > 3 || code.isEmpty()) {

			message = "Code non renseigné ou supérieur à 3 caractères";
		}
		if (designation.trim().length() < 1 || designation.isEmpty()) {

			message = "Champs de désignation null ou mal renseigné";
		}
		if (prix > PRIX_MAX || prix < PRIX_MIN) {
			
			message = "Prix renseigné null, trop elevé ou trop bas";
		}
		if (message != "") {

			throw new StockageExceptionMere(message);
		}
	}

	// getter/setter

	/**
	 * @return
	 */

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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	// public void setId(int id) { // pas necessaire ici, on ne veut pas qu'il soit
	// modifié par user

	public int getIdPizza() {
		return idPizza;
	}

	public static int getLastId() {
		return lastId;
	}

	public CategoriePizzaEnum getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizzaEnum categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

}
