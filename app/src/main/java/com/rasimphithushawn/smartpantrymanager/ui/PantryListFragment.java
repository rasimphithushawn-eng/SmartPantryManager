package com.rasimphithushawn.smartpantrymanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rasimphithushawn.smartpantrymanager.R;
import com.rasimphithushawn.smartpantrymanager.adapter.PantryAdapter;
import com.rasimphithushawn.smartpantrymanager.database.AppDatabase;

public class PantryListFragment extends Fragment {

    private PantryAdapter adapter;
    private AppDatabase db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        View v = inflater.inflate(R.layout.fragment_pantry_list, container, false);
        db = AppDatabase.getInstance(requireContext());

        RecyclerView rv = v.findViewById(R.id.pantry_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PantryAdapter();
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(item -> {
            Intent i = new Intent(getContext(), AddEditPantryActivity.class);
            i.putExtra("item_id", item.getId());
            startActivity(i);
        });

        db.pantryDao().getAllItems().observe(getViewLifecycleOwner(), items -> {
            adapter.setItems(items);
            v.findViewById(R.id.empty_view).setVisibility(
                    (items == null || items.isEmpty()) ? View.VISIBLE : View.GONE);
        });

        FloatingActionButton fab = v.findViewById(R.id.fab_add);
        fab.setOnClickListener(c -> startActivity(
                new Intent(getContext(), AddEditPantryActivity.class)));

        return v;
    }
}