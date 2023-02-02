package org.examples;

import org.examples.model.Recipe;
import org.examples.utils.ShowMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {

        String Recipes="Recipes:";

        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);

        List<Recipe> recipeBook = userInterface.start("recipes.txt");

        String menu= """
        Commands:\\nlist - lists the recipes\\nstop - stops the program\\nfind name - searches recipes by name\\n" +
               "find cooking time - searches recipes by cooking time\\nfind ingredient - searches recipes by ingredient\\n
        """;

       System.out.println(menu);


        while(true) {
            ShowMessage.showConsoleMessage("Enter command:");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                for (Recipe toPrint : recipeBook) {
                    ShowMessage.showConsoleMessage(toPrint.toString());
                }
            }

            if (command.equals("find name")) {
                ShowMessage.showConsoleMessage("Searched word:");
                String word = scanner.nextLine();
                ShowMessage.showConsoleMessage(Recipes);
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getName().contains(word)) {
                        System.out.println(toPrint);
                    }
                }
            }

            if (command.equals("find cooking time")) {
                ShowMessage.showConsoleMessage("Max cooking time: ");
                int maxTime = Integer.parseInt(scanner.nextLine());
                ShowMessage.showConsoleMessage(Recipes);
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getTime() <= maxTime) {
                        ShowMessage.showConsoleMessage(toPrint.toString());
                    }
                }
            }

            if (command.equals("find ingredient")) {
                ShowMessage.showConsoleMessage("Ingredient: ");
                String ingredientSearched = scanner.nextLine();
                ShowMessage.showConsoleMessage(Recipes);
                for (Recipe toPrint : recipeBook) {
                    if (toPrint.getIngredients().contains(ingredientSearched)) {
                        ShowMessage.showConsoleMessage(toPrint.toString());
                    }
                    
                }
            }
        }

    }

}
