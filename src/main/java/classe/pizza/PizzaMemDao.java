package classe.pizza;

import java.util.ArrayList;
import java.util.Arrays;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageExceptionMere;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizzaEnum;

public class PizzaMemDao implements IpizzaDao {

	Pizza[] pizzas = { new Pizza("PEP", "Peperoni", 12.50, CategoriePizzaEnum.AUTRE),
			new Pizza("MAR", "Margherita", 14.00, CategoriePizzaEnum.FROMAGE),
			new Pizza("REIN", "La Reine", 11.50, CategoriePizzaEnum.AUTRE),
			new Pizza("FRO", "La 4 Fromage", 12.00, CategoriePizzaEnum.FROMAGE),
			new Pizza("CAN", "La Cannibale", 12.50, CategoriePizzaEnum.VIANDE),
			new Pizza("SAV", "La Savoyarde", 13.00, CategoriePizzaEnum.FROMAGE),
			new Pizza("ORI", "L'Orientale", 13.50, CategoriePizzaEnum.VIANDE),
			new Pizza("IND", "L'Indienne", 14.00, CategoriePizzaEnum.AUTRE) };

	ArrayList<Pizza> list = new ArrayList<Pizza>(Arrays.asList(pizzas));

	public void afficheListe() {

		for (Pizza pizza : list) {

			System.out.println(pizza);
		}
	}

	public ArrayList<Pizza> findAllPizzas() {

		return list;
	}

	public void updatePizza(String codePizza, Pizza pizzaUpdate) throws UpdatePizzaException {

		try {
			pizzaUpdate.CheckPizza();

			boolean exist = isPizzaExists(codePizza);
			if (exist) {

				Pizza pizzaOld = findPizzaByCode(codePizza);
				// méthode Youcef : pizza[pizzaUpdate.getId()] = pizza
				pizzaOld.setCode(pizzaUpdate.getCode());
				pizzaOld.setDesignation(pizzaUpdate.getDesignation());
				pizzaOld.setPrix(pizzaUpdate.getPrix());
				pizzaOld.setCategoriePizza(pizzaUpdate.getCategoriePizza());

			}

		} catch (StockageExceptionMere e) {
			throw new UpdatePizzaException(e.getMessage() + " la modification n'a pas aboutie");

		}

	}

	public Pizza findPizzaByCode(String codePizza) {

		for (Pizza pizza : list) {

			if (pizza.getCode().equals(codePizza.toUpperCase())) { // toUpperCase = pour entrer en minuscule sans causer
																	// d'erreur

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

	public void addPizza(Pizza pizzaNew) throws SavePizzaException {

		try {
			pizzaNew.CheckPizza();

			list.add(pizzaNew);

		} catch (StockageExceptionMere e) {
			throw new SavePizzaException(e.getMessage() + "L'ajout de la pizza n'a pas abouti");

		}

	}

	public void deletePizza(String codePizzaASup) throws DeletePizzaException {

		try {
			Pizza piz = findPizzaByCode(codePizzaASup);

			piz.CheckPizza();

			list.remove(piz);

		} catch (StockageExceptionMere e) {
			throw new DeletePizzaException(e.getMessage() + " la supression a échoué");

		}

	}

	public void saveNewPizza(Pizza pizza) {

	}

	public boolean pizzaExists(String codePizza) {
		return false;
	}
}
