package com.rasimphithushawn.smartpantrymanager.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PantryItem.class, Recipe.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    public static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public abstract PantryDao pantryDao();
    public abstract RecipeDao recipeDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "smart_pantry_db"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}