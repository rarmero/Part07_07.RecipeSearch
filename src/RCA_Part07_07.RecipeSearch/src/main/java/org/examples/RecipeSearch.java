package org.examples;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);

        ArrayList<Recipe> recipeBook = userInterface.start("recipes.txt");

       System.out.println("Commands:\nlist - lists the recipes\nstop - stops the program\nfind name - searches recipes by name\n" +
       "find cooking time - searches recipes by cooking time\nfind ingredient - searches recipes by ingredient\n");


        while(true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                for (Recipe toPrint : recipeBook) {
                    System.out.println(toPrint);
                }
            }

            if (command.equals("find name")) {
                System.out.println("Searched word:");
                String word = scanner.nextLine();
                System.out.println("Recipes:");
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getName().contains(word)) {
                        System.out.println(toPrint);
                    }
                }
            }

            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());
                System.out.println("Recipes:");
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getTime() <= maxTime) {
                        System.out.println(toPrint);
                    }
                }
            }

            if (command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String ingredientSearched = scanner.nextLine();
                System.out.println("Recipes:");
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getIngredients().contains(ingredientSearched)) {
                        System.out.println(toPrint);
                    }
                    
                }
            }
        }




    }

}
