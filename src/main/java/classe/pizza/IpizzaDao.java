package classe.pizza;

import java.util.ArrayList;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public interface IpizzaDao  {

	// TP10

//	public Pizza[] findAllPizzas();
//
//	public void updatePizza(String codePizza, Pizza pizza);
//
//	public Pizza findPizzaByCode(String codePizza);
//
//	public boolean isPizzaExists(String codePizza);
//
//	public void addPizza(Pizza pizza);
//
//	public void deletePizza(String codePizza);
//	

	// TP11

	ArrayList<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza) throws SavePizzaException;

	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;

	void deletePizza(String codePizza) throws DeletePizzaException;

	Pizza findPizzaByCode(String codePizza);

	boolean pizzaExists(String codePizza);

}
