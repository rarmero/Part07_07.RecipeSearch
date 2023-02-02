package org.examples;

import org.examples.model.Recipe;
import org.examples.utils.showMessage;

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
            showMessage.showConsoleMessage("Enter command:");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                for (Recipe toPrint : recipeBook) {
                    showMessage.showConsoleMessage(toPrint.toString());
                }
            }

            if (command.equals("find name")) {
                showMessage.showConsoleMessage("Searched word:");
                String word = scanner.nextLine();
                showMessage.showConsoleMessage("Recipes:");
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getName().contains(word)) {
                        System.out.println(toPrint);
                    }
                }
            }

            if (command.equals("find cooking time")) {
                showMessage.showConsoleMessage("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());
                showMessage.showConsoleMessage("Recipes:");
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getTime() <= maxTime) {
                        showMessage.showConsoleMessage(toPrint.toString());
                    }
                }
            }

            if (command.equals("find ingredient")) {
                showMessage.showConsoleMessage("Ingredient: ");
                String ingredientSearched = scanner.nextLine();
                showMessage.showConsoleMessage("Recipes:");
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getIngredients().contains(ingredientSearched)) {
                        showMessage.showConsoleMessage(toPrint.toString());
                    }
                    
                }
            }
        }




    }

}
