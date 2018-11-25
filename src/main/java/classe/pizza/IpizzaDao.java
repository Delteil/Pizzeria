package classe.pizza;

import java.util.ArrayList;

public interface IpizzaDao {

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

	void saveNewPizza(Pizza pizza);

	void updatePizza(String codePizza, Pizza pizza);

	void deletePizza(String codePizza);

	Pizza findPizzaByCode(String codePizza);

	boolean pizzaExists(String codePizza);

}
