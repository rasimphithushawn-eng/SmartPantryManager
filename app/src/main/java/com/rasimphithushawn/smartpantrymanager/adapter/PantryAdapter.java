package com.rasimphithushawn.smartpantrymanager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rasimphithushawn.smartpantrymanager.R;
import com.rasimphithushawn.smartpantrymanager.database.PantryItem;
import java.util.ArrayList;
import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.VH> {

    public interface OnItemClick { void onClick(PantryItem item); }

    private OnItemClick listener;
    private List<PantryItem> items = new ArrayList<>();

    public void setItems(List<PantryItem> newItems) {
        this.items = newItems != null ? newItems : new ArrayList<>();
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClick l) { this.listener = l; }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        PantryItem item = items.get(pos);
        h.name.setText(item.getName());
        h.qty.setText(item.getQuantity() + " " + item.getUnit());
        if (item.getExpiryDate() != null && !item.getExpiryDate().isEmpty()) {
            h.expiry.setText("Expires: " + item.getExpiryDate());
            h.expiry.setVisibility(View.VISIBLE);
        } else {
            h.expiry.setVisibility(View.GONE);
        }
        h.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onClick(item);
        });
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView name, qty, expiry;
        VH(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.item_name);
            qty = v.findViewById(R.id.item_qty);
            expiry = v.findViewById(R.id.item_expiry);
        }
    }
}