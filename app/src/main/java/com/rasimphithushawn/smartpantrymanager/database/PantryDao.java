package com.rasimphithushawn.smartpantrymanager.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import java.util.List;

@Dao
public interface PantryDao {
    @Insert long insert(PantryItem item);
    @Update void update(PantryItem item);
    @Delete void delete(PantryItem item);

    @Query("SELECT * FROM pantry_items ORDER BY name ASC")
    LiveData<List<PantryItem>> getAllItems();

    @Query("SELECT * FROM pantry_items ORDER BY name ASC")
    List<PantryItem> getAllItemsSync();

    @Query("SELECT * FROM pantry_items WHERE id = :id")
    PantryItem getById(int id);
}