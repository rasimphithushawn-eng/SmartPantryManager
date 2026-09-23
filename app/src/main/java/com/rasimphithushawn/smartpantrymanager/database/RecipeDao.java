package com.rasimphithushawn.smartpantrymanager.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import java.util.List;

@Dao
public interface RecipeDao {
    @Insert void insert(Recipe recipe);
    @Insert void insertAll(List<Recipe> recipes);

    @Query("SELECT * FROM recipes ORDER BY name ASC")
    LiveData<List<Recipe>> getAllRecipes();

    @Query("SELECT * FROM recipes ORDER BY name ASC")
    List<Recipe> getAllRecipesSync();

    @Query("SELECT COUNT(*) FROM recipes")
    int getRecipeCount();

    @Query("SELECT * FROM recipes WHERE id = :id")
    Recipe getById(int id);
}