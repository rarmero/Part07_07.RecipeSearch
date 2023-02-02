package org.examples.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private int time;
    private List<String> ingredients;

    public Recipe(String name, int time, List<String> ingredients) {
        this.name = name;
        this.time = time;
        this.ingredients = ingredients;
    }

    public Recipe(String name, int time) {
        this.name = name;
        this.time = time;
        this.ingredients = new ArrayList<>();
    }

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe() {
        this("not defined", 0, new ArrayList<>());

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    public void setIngredients(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public String toString() {
        return this.name + ", cooking time: " + this.time;
    }

}
