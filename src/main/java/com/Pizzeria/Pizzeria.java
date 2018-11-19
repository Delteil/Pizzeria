package com.Pizzeria;

import java.util.Scanner;

import classe.pizza.Pizza; // importation de la classe Pizza

public class Pizzeria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int choix = 0;
		String code = "";
		String designation = "";
		double prix = 0;

		Pizza[] pizzas = { new Pizza("PEP", "Peperoni", 12.50), new Pizza("MAR", "Margherita", 14.00),
				new Pizza("REIN", "La Reine", 11.50), new Pizza("FRO", "La 4 Fromage", 12.00),
				new Pizza("CAN", "La Cannibale", 12.50), new Pizza("SAV", "La Savoyarde", 13.00),
				new Pizza("ORI", "L'Orientale", 13.50), new Pizza("IND", "L'Indienne", 14.00) }; // importation et
																									// création de la

		while (choix != 99) {

			System.out.println("***** Pizzeria Administration *****\r\n" + "1. Lister les pizzas\r\n"
					+ "2. Ajouter une nouvelle pizza\r\n" + "3. Mettre à jour une pizza\r\n"
					+ "4. Supprimer une pizza\r\n" + "99. Sortir");

			choix = sc.nextInt();

			if (choix == 1) {
				System.out.println("Liste des pizzas");

				for (Pizza pizzaListe : pizzas) {

					System.out.println(pizzaListe.toString());
				}
				System.out.println();

			}
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

				Pizza[] pizzaTemp = new Pizza[pizzas.length + 1];

				for (int i = 0; i < pizzas.length; i++) {
					pizzaTemp[i] = pizzas[i];
				}

				pizzaTemp[pizzaTemp.length - 1] = pizzaNew; // ajout au dernier indice

				pizzas = pizzaTemp;

				for (Pizza pizzaListe : pizzas) {

					System.out.println(pizzaListe.toString());
				}

				System.out.println();
			}
//			if (choix == 3) { System.out.println("Mise à jour d’une pizza");
//			 
//			 String newCode = ""; 
//			 String newDesignation = ""; 
//			 double newPrix = 0;
//			 
//			  System.out.println("Veuillez choisir le code de la pizza à modifier.");
//			  code = sc.nextLine();
//			  System.out.println("Veuillez saisir le nouveau code");
//			  newCode = sc.nextLine(); 
//			  code = newCode; code.setCode(code.getCode());
//			  System.out.println("Veuillez saisir le nouveau nom (sans espace)");
//			  designation = sc.nextLine();
//			  designation = newDesignation;
//			  designation.setDesignation(designation.getDesignation());
//			  System.out.println("Veuillez saisir le nouveau prix"); newPrix =
//			 sc.nextDouble(); prix = newPrix; prix.setPrix(prix.getPrix());
//			 
//			 System.out.println();
//			
//		}
//		if (choix == 4) {
//			System.out.println("Suppression d’une pizza");
//
//			System.out.println("Veuillez choisir le code de la pizza à supprimer :");
//			code = sc.nextLine();
//
//			System.out.println();
//
//		}
//		if (choix == 99) {
//			System.out.println("Au revoir et à bientôt");
//
//		}
		}

	}
}
