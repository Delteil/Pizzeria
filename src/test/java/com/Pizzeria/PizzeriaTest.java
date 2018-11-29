/*
 * Tests
Dans tout programme il est important de contrôler la saisie des données par l’utilisateur.
o Modifier le programme pour vérifier les données, par exemple en s’assurant que :
• Une donnée ne peut pas être vide
• Une référence de donnée comprenne 3 caractères majuscules
• Le prix ne soit pas négatif et compris dans un intervalle de prix
• La référence ou la désignation d’une pizza ne soit pas en double
o Mettre en place les tests permettant d’assurer la non-régression du code pour les
données saisies.
o Mettre en place les tests permettant de vérifier le bon fonctionnement de la classe
DAO.
 */

package com.Pizzeria;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import classe.pizza.Pizza;
import classe.pizza.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizzaEnum;

public class PizzeriaTest {

	PizzaMemDao dao = new PizzaMemDao();
	ArrayList<Pizza> listePizza = dao.findAllPizzas();

	@Before
	public void set_up_liste_pizza() {
		listePizza = dao.findAllPizzas();
	}

	// Test • Une donnée ne peut pas être vide

	@Test
	public void test_données_vides() {
		Pizza pizzaNew = new Pizza("PEP", "Peperoni", 12.5, CategoriePizzaEnum.AUTRE);
		assertNotEquals("le code est vide", "", pizzaNew.getCode());
		assertNotEquals("la desigantion est vide", "", pizzaNew.getDesignation());
		assertNotEquals("le prix est vide", null, pizzaNew.getPrix());
		assertNotEquals("la categorie est vide", "", pizzaNew.getCategoriePizza());
	}

	// Test • Une référence de donnée comprenne 3 caractères majuscules

	@Test
	public void test_Maj() {
		Pizza pizzaNew = new Pizza("PEP", "Peperoni", 12.5, CategoriePizzaEnum.AUTRE);
		assertTrue("le code n'est pas en MAJ", pizzaNew.getCode().equals(pizzaNew.getCode().toUpperCase()));
	}

	// Test • Le prix ne soit pas négatif et compris dans un intervalle de prix

	@Test
	public void test_prix_non_neg_et_compris_dans_un_int() {
		Pizza pizzaNew = new Pizza("PEP", "Peperoni", 12.5, CategoriePizzaEnum.AUTRE);
		assertFalse("le prix est négatif ou n'est pas compris entre 5 et 50",
				pizzaNew.getPrix() < Pizza.PRIX_MIN || pizzaNew.getPrix() > Pizza.PRIX_MAX);
	}

	// Test • Le code ou la désignation d’une pizza ne soit pas en double

	@Test
	public void test_pizza_en_double() {
		Set<Pizza> set = new HashSet<Pizza>(); // création d'une liste HashSet qui ne supporte pas les doublons
		for (Pizza pizza : listePizza) { // on parcours la liste array
			set.add(pizza); // on ajoute les pizza à la liste set, si doublon la pizza n'est pas copiée
		}
		assertEquals("pas de doublon", set.size(), listePizza.size()); // on compare la taille des 2 tableaux
	}

	@Test(expected = UpdatePizzaException.class)
	public void exp0_declenche_exception_donnee_vide() throws UpdatePizzaException {
		Pizza pizzaNew = new Pizza("VEGdgg", "Peperoni", 12.5, CategoriePizzaEnum.AUTRE);
		dao.updatePizza("PEP", pizzaNew);

	}

	@Test
	public void exp1_declenche_exception_donnee_vide() {
		try {
			dao.deletePizza("PEP");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(expected = SavePizzaException.class)
	public void exp2_declenche_exception_donnee_vide() throws SavePizzaException {
		Pizza pizzaNew = new Pizza("", "Peperoni", 12.5, CategoriePizzaEnum.AUTRE);
		dao.addPizza(pizzaNew);
	}
}
