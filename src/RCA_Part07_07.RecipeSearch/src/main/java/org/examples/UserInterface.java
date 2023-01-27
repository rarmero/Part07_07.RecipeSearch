package org.examples;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scan;
    private ArrayList<Recipe> recipeBook;

    public UserInterface(Scanner scan) {
        this.scan = scan;
        this.recipeBook = new ArrayList<>();

    }

    public ArrayList<Recipe> start(String file) {


            try (Scanner fileReader = new Scanner(Paths.get(file))) {
                
                int linePos = 0;
                String name = "";
                int time = 0;
                List<String> ingredients = new ArrayList<>();

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                          
                    if (linePos == 0) {
                        name = line;
                    }
                    if (linePos == 1) {
                        time = Integer.valueOf(line);
                    }
                    if (linePos > 1 && !line.isEmpty()) {
                        ingredients.add(line);
                    }
                    linePos++;

                    if(line.isEmpty()) {

                        Recipe cook = new Recipe(name, time);
                        for (String elements : ingredients) {
                            cook.getIngredients().add(elements);
                        }
                        recipeBook.add(cook);

                        linePos = 0;
                        name = "";
                        time = 0;
                        ingredients.clear();
                    }
                }
                if (!fileReader.hasNextLine()) {
                    Recipe cook = new Recipe(name, time);
                    for (String elements : ingredients) {
                        cook.getIngredients().add(elements);
                    }
                    recipeBook.add(cook);
                }

                return recipeBook;

            } catch (Exception e) {
                System.out.println("Couldn't read file " + e.getMessage());
                return recipeBook;
            }
    }
    
}
