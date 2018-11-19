package com.Pizzeria;

import java.util.Scanner;

public class Pizzeria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int choix = 0;

		while (choix != 99) {

			System.out.println("***** Pizzeria Administration *****\r\n" + "1. Lister les pizzas\r\n"
					+ "2. Ajouter une nouvelle pizza\r\n" + "3. Mettre à jour une pizza\r\n"
					+ "4. Supprimer une pizza\r\n" + "99. Sortir");

			choix = sc.nextInt();

			if (choix == 1) {
				System.out.println("Liste des pizzas");
				System.out.println();
			}
			if (choix == 2) {
				System.out.println("Ajout d’une nouvelle pizza");
				System.out.println();

			}
			if (choix == 3) {
				System.out.println("Mise à jour d’une pizza");
				System.out.println();

			}
			if (choix == 4) {
				System.out.println("Suppression d’une pizza");
				System.out.println();

			}
			if (choix == 99) {
				System.out.println("Au revoir et à bientôt");
			}
		}
	}

}
