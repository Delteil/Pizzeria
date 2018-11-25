package classe.pizza;

import java.util.ArrayList;

public class PizzaMemDao implements IpizzaDao {

	Pizza[] pizzas = { new Pizza("PEP", "Peperoni", 12.50), new Pizza("MAR", "Margherita", 14.00),
			new Pizza("REIN", "La Reine", 11.50), new Pizza("FRO", "La 4 Fromage", 12.00),
			new Pizza("CAN", "La Cannibale", 12.50), new Pizza("SAV", "La Savoyarde", 13.00),
			new Pizza("ORI", "L'Orientale", 13.50), new Pizza("IND", "L'Indienne", 14.00) };
	
	ArrayList<Pizza> list = new ArrayList<Pizza>();
	
	
	public void afficheListe() {

		for (Pizza pizza : pizzas) {

			System.out.println(pizza);
		}
	}

	public ArrayList<Pizza> findAllPizzas() {

		return list;
	}

	public void updatePizza(String codePizza, Pizza pizzaUpdate) {

		Pizza pizzaOld = findPizzaByCode(codePizza);
		// méthode Youcef : pizza[pizzaUpdate.getId()] = pizza
		pizzaOld.setCode(pizzaUpdate.getCode());
		pizzaOld.setDesignation(pizzaUpdate.getDesignation());
		pizzaOld.setPrix(pizzaUpdate.getPrix());

	}

	public Pizza findPizzaByCode(String codePizza) {

		for (Pizza pizza : pizzas) {

			if (pizza.getCode().equals(codePizza.toUpperCase())) { //toUpperCase = pour entrer en minuscule sans causer d'erreur

				return pizza;
			}
		}

		return null;
	}

	public boolean isPizzaExists(String codePizza) {

		if (findPizzaByCode(codePizza) != null) {

			return true;
		}
		return false;
	}

	public void addPizza(Pizza pizzaNew) {

		Pizza[] pizzaTemp = new Pizza[pizzas.length + 1];

		for (int i = 0; i < pizzas.length; i++) {

			pizzaTemp[i] = pizzas[i];
		}

		pizzaTemp[pizzaTemp.length - 1] = pizzaNew;

		pizzas = pizzaTemp;

	}

	public void deletePizza(String codePizzaASup) {

		Pizza[] pizzaTemp2 = new Pizza[pizzas.length - 1];

		int indiceTemp = 0;

		for (Pizza pizza : pizzas) {

			if (!pizza.getCode().equals(codePizzaASup.toUpperCase())) {

				pizzaTemp2[indiceTemp] = pizza;
				indiceTemp++;
			}

			pizzas = pizzaTemp2;
		}

	}

	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
}
