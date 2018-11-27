package fr.pizzeria.model;

public enum CategoriePizzaEnum {

	FROMAGE("Fromage"), VIANDE("Viande"), POISSON("Poisson"), AUTRE("Autre");

	// attributs
	private String categoriePizza;

	// constructeur
	private CategoriePizzaEnum(String categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	// toString
	public String toString() {
		return this.categoriePizza;
		
	}

	// getter/setter
	public String getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(String categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
}
