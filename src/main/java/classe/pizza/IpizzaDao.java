package classe.pizza;

public interface IpizzaDao {
	
	

	public Pizza[] findAllPizzas();

	public void updatePizza(String codePizza, Pizza pizza);

	public Pizza findPizzaByCode(String codePizza);

	public boolean isPizzaExists(String codePizza);

	public void addPizza(Pizza pizza);

	public void deletePizza(String codePizza);
	
}
