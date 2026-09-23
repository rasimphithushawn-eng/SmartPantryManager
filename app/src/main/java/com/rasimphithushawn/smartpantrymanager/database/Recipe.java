package com.rasimphithushawn.smartpantrymanager.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipes")
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    /** Format: "ingredient:qty:unit,ingredient:qty:unit" */
    private String requiredIngredients;
    private String steps;

    public Recipe(String name, String requiredIngredients, String steps) {
        this.name = name;
        this.requiredIngredients = requiredIngredients;
        this.steps = steps;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRequiredIngredients() { return requiredIngredients; }
    public void setRequiredIngredients(String r) { this.requiredIngredients = r; }
    public String getSteps() { return steps; }
    public void setSteps(String steps) { this.steps = steps; }
}