package com.rasimphithushawn.smartpantrymanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rasimphithushawn.smartpantrymanager.R;
import com.rasimphithushawn.smartpantrymanager.adapter.RecipeAdapter;
import com.rasimphithushawn.smartpantrymanager.database.AppDatabase;
import com.rasimphithushawn.smartpantrymanager.database.PantryItem;
import com.rasimphithushawn.smartpantrymanager.database.Recipe;
import com.rasimphithushawn.smartpantrymanager.logic.RecipeMatcher;

import java.util.List;

public class SuggestedRecipesFragment extends Fragment {

    private RecipeAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup c, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_suggested, c, false);
        RecyclerView rv = v.findViewById(R.id.recipe_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecipeAdapter();
        rv.setAdapter(adapter);
        adapter.setOnClick(recipe -> {
            Intent i = new Intent(getContext(), RecipeDetailActivity.class);
            i.putExtra("recipe_id", recipe.getId());
            startActivity(i);
        });
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        View v = getView();
        if (v == null) return;
        AppDatabase db = AppDatabase.getInstance(requireContext());
        AppDatabase.executor.execute(() -> {
            List<Recipe> all = db.recipeDao().getAllRecipesSync();
            List<PantryItem> pantry = db.pantryDao().getAllItemsSync();
            List<Recipe> suggested = RecipeMatcher.filterSuggested(all, pantry);

            requireActivity().runOnUiThread(() -> {
                adapter.setItems(suggested);
                TextView empty = v.findViewById(R.id.empty_msg);
                if (suggested.isEmpty()) {
                    empty.setText("No recipes match your pantry yet.\nAdd more ingredients!");
                    empty.setVisibility(View.VISIBLE);
                } else {
                    empty.setVisibility(View.GONE);
                }
            });
        });
    }
}