package com.rasimphithushawn.smartpantrymanager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rasimphithushawn.smartpantrymanager.R;
import com.rasimphithushawn.smartpantrymanager.database.Recipe;
import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {

    public interface OnClick { void onClick(Recipe r); }
    private OnClick listener;
    private List<Recipe> items = new ArrayList<>();

    public void setItems(List<Recipe> i) {
        this.items = i != null ? i : new ArrayList<>();
        notifyDataSetChanged();
    }
    public void setOnClick(OnClick l) { this.listener = l; }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        Recipe r = items.get(pos);
        h.name.setText(r.getName());
        h.sub.setText(r.getRequiredIngredients().replace(",", ", "));
        h.itemView.setOnClickListener(v -> { if (listener != null) listener.onClick(r); });
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView name, sub;
        VH(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.tv_recipe_name);
            sub = v.findViewById(R.id.tv_recipe_sub);
        }
    }
}