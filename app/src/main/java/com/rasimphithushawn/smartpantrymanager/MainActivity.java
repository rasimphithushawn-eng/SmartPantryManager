package com.rasimphithushawn.smartpantrymanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rasimphithushawn.smartpantrymanager.ui.PantryListFragment;
import com.rasimphithushawn.smartpantrymanager.ui.SettingsFragment;
import com.rasimphithushawn.smartpantrymanager.ui.SuggestedRecipesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView nav = findViewById(R.id.bottom_nav);
        nav.setOnItemSelectedListener(item -> {
            Fragment f;
            int id = item.getItemId();
            if (id == R.id.nav_pantry) f = new PantryListFragment();
            else if (id == R.id.nav_recipes) f = new SuggestedRecipesFragment();
            else f = new SettingsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, f).commit();
            return true;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new PantryListFragment()).commit();
        }
    }
}