package classe.pizza;

import classe.pizza.PizzaMemDao;

public class TestPizzeria {

	public static void main(String[] args) {
		
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		Pizza[] pizzas = pizzaMemDao.findAllPizzas();
		
			
		pizzaMemDao.afficheTableau();
		
		
	
		}
	}


