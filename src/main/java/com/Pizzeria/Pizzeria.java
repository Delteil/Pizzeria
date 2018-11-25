package com.Pizzeria;

import java.util.Scanner;

import classe.pizza.Pizza; // importation de la classe Pizza
import classe.pizza.PizzaMemDao;

public class Pizzeria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PizzaMemDao pizzaMemDao = new PizzaMemDao();

		int choix = 0;
		String code = "";
		String designation = "";
		double prix = 0;

//		Pizza[] pizzas = { new Pizza("PEP", "Peperoni", 12.50), new Pizza("MAR", "Margherita", 14.00),
//				new Pizza("REIN", "La Reine", 11.50), new Pizza("FRO", "La 4 Fromage", 12.00),
//				new Pizza("CAN", "La Cannibale", 12.50), new Pizza("SAV", "La Savoyarde", 13.00),
//				new Pizza("ORI", "L'Orientale", 13.50), new Pizza("IND", "L'Indienne", 14.00) }; // importation et
		// création de la

		while (choix != 99) {

			System.out.println("***** Pizzeria Administration *****\r\n" + "1. Lister les pizzas\r\n"
					+ "2. Ajouter une nouvelle pizza\r\n" + "3. Mettre à jour une pizza\r\n"
					+ "4. Supprimer une pizza\r\n" + "99. Sortir");

			choix = sc.nextInt();

			if (choix == 1) {

				pizzaMemDao.afficheListe();
				System.out.println();
			}

//				System.out.println("Liste des pizzas");
//
//				for (Pizza pizzaListe : pizzas) {
//
//					System.out.println(pizzaListe.toString());

			if (choix == 2) {
				System.out.println("Ajout d’une nouvelle pizza");

				sc.nextLine(); // ajouter...pb scanner
				System.out.println("Veuillez saisir le code");
				code = sc.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				designation = sc.nextLine();
				System.out.println("Veuillez saisir le prix :");
				prix = sc.nextDouble();

				Pizza pizzaNew = new Pizza(code, designation, prix);

				pizzaMemDao.addPizza(pizzaNew);

//				Pizza pizzaNew = new Pizza(code, designation, prix);
//
//				// création d'un tableau temporaire plus grand
//
//				Pizza[] pizzaTemp = new Pizza[pizzas.length + 1];
//
//				for (int i = 0; i < pizzas.length; i++) {
//					pizzaTemp[i] = pizzas[i];
//				}
//
//				pizzaTemp[pizzaTemp.length - 1] = pizzaNew; // ajout au dernier indice
//
//				pizzas = pizzaTemp;

//				for (Pizza pizzaListe : pizzas) {
//
//					System.out.println(pizzaListe.toString());
//				}

				pizzaMemDao.afficheListe();
			}

			System.out.println();

			if (choix == 3) {

				System.out.println("Mise à jour d’une pizza");

				String newCode = "";
				String newDesignation = "";
				double newPrix = 0;

				sc.nextLine(); // ajouter...pb scanner
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				code = sc.nextLine();

				if (pizzaMemDao.isPizzaExists(code.toUpperCase())) { // toUpperCase = pour entrer en minuscule

					System.out.println("Veuillez saisir le nouveau code");
					newCode = sc.nextLine();

					System.out.println("Veuillez saisir le nouveau nom (sans espace)");
					newDesignation = sc.nextLine();

					System.out.println("Veuillez saisir le nouveau prix");
					newPrix = sc.nextDouble();

					Pizza pizzaUpdate = new Pizza(newCode, newDesignation, newPrix);

					pizzaMemDao.updatePizza(code, pizzaUpdate);

					pizzaMemDao.afficheListe();
					System.out.println();

				} else {

					System.out.println("code pizza non valide");
				}

//				for (Pizza pizzaListe : pizzas) {
//
//					if (pizzaListe.getCode().equals(code)) {
//
//						System.out.println("Veuillez saisir le nouveau code");
//						newCode = sc.nextLine();
//
//						System.out.println("Veuillez saisir le nouveau nom (sans espace)");
//						newDesignation = sc.nextLine();
//
//						System.out.println("Veuillez saisir le nouveau prix");
//						newPrix = sc.nextDouble();
//
//						pizzaListe.setCode(newCode);
//						pizzaListe.setDesignation(newDesignation);
//						pizzaListe.setPrix(newPrix);

//					}
//					System.out.println(pizzaListe.toString());
//				}
//				System.out.println();
			}

			if (choix == 4) {
				System.out.println("Suppression d’une pizza");

				sc.nextLine();
				System.out.println("Veuillez choisir le code de la pizza à supprimer :");
				String codeASupprimer = sc.nextLine();

				pizzaMemDao.deletePizza(codeASupprimer.toUpperCase());

				pizzaMemDao.afficheListe();

				System.out.println();

//				// creation d'un tableau temporaire2 plus petit que l'ancien
//
//				Pizza[] pizzaTemp2 = new Pizza[pizzas.length - 1];
//
//				// ajout dans tableau temp2 les pizzas que l'on garde
//
//				int indiceTemp = 0; // création d'un indiceTemporaire pour le tableauTemp
//
//				for (Pizza pizza : pizzas) {
//
//					if (!pizza.getCode().equals(codeASupprimer)) { // nb, l'inverse de la condition avec ! en debut
//
//						pizzaTemp2[indiceTemp] = pizza;
//
//// incrémentation de l'indiceTemp pour suivre l'incrémentation de l'indice i du tableau pizza, malgré la suppression de la ligne et donc de l'indiceTemp
//						indiceTemp++;
//					}
//
//					pizzas = pizzaTemp2;
//				}
//
//				for (Pizza pizza : pizzas) {
//
//					System.out.println(pizza.toString());
//				}
//				System.out.println();

			}
			if (choix == 99) {

				System.out.println("Au revoir et à bientôt");

			}

		}
		sc.close();

	}
}
