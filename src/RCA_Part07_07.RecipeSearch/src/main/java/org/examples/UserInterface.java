package org.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.examples.model.Recipe;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final ArrayList<Recipe> recipeBook;
    private final Scanner scan;
    private static final Logger logger = LogManager.getLogger("HelloWorld");


    public UserInterface(Scanner scan) {
        this.scan = scan;
        this.recipeBook = new ArrayList<>();

    }

    public List<Recipe> start(String file) {


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
                        time = Integer.parseInt(line);
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
                logger.debug(String.format("Couldn't read file %s", e.getMessage()));
                return recipeBook;
            }
    }
    
}
