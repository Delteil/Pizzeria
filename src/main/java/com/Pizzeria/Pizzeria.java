package com.Pizzeria;

import java.util.Scanner;
import classe.pizza.Pizza; // importation de la classe Pizza
import classe.pizza.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException; //importation des classes Exceptions
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizzaEnum;

public class Pizzeria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PizzaMemDao pizzaMemDao = new PizzaMemDao();

		int choix = 0;

		String code = "";
		String designation = "";
		double prix = 0;

		while (choix != 99) {

			System.out.println("***** Pizzeria Administration *****\r\n" + "1. Lister les pizzas\r\n"
					+ "2. Ajouter une nouvelle pizza\r\n" + "3. Mettre à jour une pizza\r\n"
					+ "4. Supprimer une pizza\r\n" + "99. Sortir");

			choix = sc.nextInt();

			if (choix == 1) {

				pizzaMemDao.afficheListe();
				System.out.println();
			}

			if (choix == 2) {

				System.out.println("Ajout d’une nouvelle pizza");
				try {
					sc.nextLine(); // ajouter...pb scanner
					System.out.println("Veuillez saisir le code");
					code = sc.nextLine();

					System.out.println("Veuillez saisir le nom (sans espace) :");
					designation = sc.nextLine();

					System.out.println("Veuillez saisir le prix :");
					prix = sc.nextDouble();
					
					sc.nextLine();
					System.out.println("Veuillez saisir la catégorie :");
					String idCategorie = sc.nextLine().toUpperCase();

					Pizza pizzaNew = new Pizza(code, designation, prix, CategoriePizzaEnum.valueOf(idCategorie));

					pizzaMemDao.addPizza(pizzaNew);
					
				} catch (SavePizzaException e) {

					System.out.println(e.getMessage());
				}

				pizzaMemDao.afficheListe();
			}

			System.out.println();

			if (choix == 3) {

				System.out.println("Mise à jour d’une pizza");

				String newCode = "";
				String newDesignation = "";
				double newPrix = 0;

				try {
					sc.nextLine(); // ajouter...pb scanner
					System.out.println("Veuillez choisir le code de la pizza à modifier.");
					code = sc.nextLine();

					System.out.println("Veuillez saisir le nouveau code");
					newCode = sc.nextLine();

					System.out.println("Veuillez saisir le nouveau nom (sans espace)");
					newDesignation = sc.nextLine();

					System.out.println("Veuillez saisir le nouveau prix");
					newPrix = sc.nextDouble();

					System.out.println("Veuillez saisir la nouvelle catégorie");
					String idNewCategorie = sc.next().toUpperCase();

					Pizza pizzaUpdate = new Pizza(newCode, newDesignation, newPrix,
							CategoriePizzaEnum.valueOf(idNewCategorie));

					pizzaMemDao.updatePizza(code, pizzaUpdate);

				} catch (UpdatePizzaException e) {
					
					System.out.println(e.getMessage());
				}

				pizzaMemDao.afficheListe();
				System.out.println();

			}
			if (choix == 4) {
				System.out.println("Suppression d’une pizza");
				try {
					sc.nextLine();
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					String codeASupprimer = sc.nextLine();

					pizzaMemDao.deletePizza(codeASupprimer.toUpperCase());

				} catch (DeletePizzaException e) {

					System.out.println(e.getMessage());
				}

				pizzaMemDao.afficheListe();

				System.out.println();

			}
			if (choix == 99) {

				System.out.println("Au revoir et à bientôt");

			}

		}

		sc.close();

	}
}
