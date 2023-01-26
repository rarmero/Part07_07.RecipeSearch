import org.examples.Recipe;
import org.examples.UserInterface;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestUserInterface {

    private List<Recipe> recipeBook;

    @Test
    public void testLastLineFile(){


    }


    @Test
    public void testStart() {

        Recipe recipeOrigin = new Recipe();
        ArrayList<Recipe> recipeLstOrigin = new ArrayList<>();

        recipeOrigin.setName("Pancake dough");
        recipeOrigin.setTime(60);
        recipeOrigin.setIngredients("milk");
        recipeOrigin.setIngredients("egg");
        recipeOrigin.setIngredients("butter");
        recipeOrigin.setIngredients("flour");
        recipeOrigin.setIngredients("salt");

        recipeLstOrigin.add(recipeOrigin);

        recipeOrigin = new Recipe();
        recipeOrigin.setName("Meatballs");
        recipeOrigin.setTime(20);
        recipeOrigin.setIngredients("ground meat");
        recipeOrigin.setIngredients("egg");
        recipeOrigin.setIngredients("breadcrumbs");

        recipeLstOrigin.add(recipeOrigin);

        recipeOrigin = new Recipe();

        recipeOrigin.setName("Tofu rolls");
        recipeOrigin.setTime(30);
        recipeOrigin.setIngredients("tofu");
        recipeOrigin.setIngredients("rice");
        recipeOrigin.setIngredients("water");
        recipeOrigin.setIngredients("carrot");
        recipeOrigin.setIngredients("cucumber");
        recipeOrigin.setIngredients("avocado");
        recipeOrigin.setIngredients("wasabi");

        recipeLstOrigin.add(recipeOrigin);

        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner);

        ArrayList<Recipe> recipeBook = userInterface.start("recipes.txt");

        assertEquals(4,recipeBook.size());
/*
        assertEquals(recipeLstOrigin.get(0).getName(),recipeBook.get(0).getName());
        assertEquals(recipeLstOrigin.get(1).getName(),recipeBook.get(1).getName());
        assertEquals(recipeLstOrigin.get(2).getName(),recipeBook.get(2).getName());
*/
    }

    @Test
    public void readingAndListing1() throws Throwable {
    //    test(Arrays.asList("Pancake dough", "15", "milk", "", "Meatballs", "10", "ground meat"), Arrays.asList("list"), Arrays.asList("Pancake dough, cooking time: 15", "Meatballs, cooking time: 10"), Arrays.asList(""));
    }
/*
    public void test(List<String> fileContents, List<String> commandList, List<String> expectedPrints, List<String> notExpectedPrints) {
        String file = createTestFile(fileContents);

        String commands = file + "\n";
        for (String command : commandList) {
            commands += command + "\n";
        }
        commands += "stop\n";

        io.setSysIn(commands);
        RecipeSearch.main(new String[]{});

        String print = io.getSysOut();
        for (String expected : expectedPrints) {
            if (expected.trim().isEmpty()) {
                continue;
            }

            assertTrue("Expected the output to contain the string " + expected
                    + ".\nWhen the contents of the file are:\n" + byRows(fileContents)
                    + "\nTest the program with the commands:\n" + commands + ".", print.contains(expected));
        }

        for (String notExpected : notExpectedPrints) {
            if (notExpected.trim().isEmpty()) {
                continue;
            }

            assertFalse("Expected that the output would not contain the string " + notExpected
                    + ".\nWhen the contents of the file are:\n" + byRows(fileContents) +
                    "\nTest the program with the commands:\n" + commands + ".", print.contains(notExpected));
        }

        try {
            new File(file).delete();
        } catch (Throwable t) {
            System.out.println("Failed to delete the test file " + file);
        }
    }

    private String byRows(List<String> rows) {
        String s = "";
        for (String row : rows) {
            s += row + "\n";
        }

        return s;
    }

    public String createTestFile(List<String> contents) {
        String fileName = "test-" + UUID.randomUUID().toString().substring(0, 6);

        try (PrintWriter pw = new PrintWriter(fileName)) {
            for (String row : contents) {
                pw.println(row);
            }
            pw.flush();
        } catch (Exception e) {
            fail("Failed to create the test file that contains recipes.\nTry running the tests on the TMC server.");

        }

        return fileName;
    }
*/

}
