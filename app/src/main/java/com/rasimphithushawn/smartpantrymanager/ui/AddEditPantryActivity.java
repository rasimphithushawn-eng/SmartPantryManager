package com.rasimphithushawn.smartpantrymanager.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.rasimphithushawn.smartpantrymanager.R;
import com.rasimphithushawn.smartpantrymanager.database.AppDatabase;
import com.rasimphithushawn.smartpantrymanager.database.PantryItem;

public class AddEditPantryActivity extends AppCompatActivity {

    private EditText etName, etQty, etUnit, etExpiry;
    private Button btnSave, btnDelete;
    private AppDatabase db;
    private PantryItem existing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_pantry);
        db = AppDatabase.getInstance(this);

        etName = findViewById(R.id.et_name);
        etQty = findViewById(R.id.et_qty);
        etUnit = findViewById(R.id.et_unit);
        etExpiry = findViewById(R.id.et_expiry);
        btnSave = findViewById(R.id.btn_save);
        btnDelete = findViewById(R.id.btn_delete);

        int id = getIntent().getIntExtra("item_id", -1);
        if (id != -1) {
            setTitle("Edit Ingredient");
            AppDatabase.executor.execute(() -> {
                existing = db.pantryDao().getById(id);
                runOnUiThread(() -> {
                    if (existing != null) {
                        etName.setText(existing.getName());
                        etQty.setText(String.valueOf(existing.getQuantity()));
                        etUnit.setText(existing.getUnit());
                        etExpiry.setText(existing.getExpiryDate());
                    }
                });
            });
        } else {
            setTitle("Add Ingredient");
            btnDelete.setVisibility(View.GONE);
        }

        btnSave.setOnClickListener(v -> save());
        btnDelete.setOnClickListener(v -> delete());
    }

    private void save() {
        String name = etName.getText().toString().trim();
        String qtyStr = etQty.getText().toString().trim();
        String unit = etUnit.getText().toString().trim();
        String expiry = etExpiry.getText().toString().trim();

        if (TextUtils.isEmpty(name)) { etName.setError("Name required"); return; }
        if (TextUtils.isEmpty(qtyStr)) { etQty.setError("Quantity required"); return; }
        double qty;
        try {
            qty = Double.parseDouble(qtyStr);
            if (qty <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            etQty.setError("Enter a positive number");
            return;
        }
        if (TextUtils.isEmpty(unit)) { etUnit.setError("Unit required"); return; }

        final double fQty = qty;
        AppDatabase.executor.execute(() -> {
            if (existing == null) {
                db.pantryDao().insert(new PantryItem(name, fQty, unit, expiry));
            } else {
                existing.setName(name);
                existing.setQuantity(fQty);
                existing.setUnit(unit);
                existing.setExpiryDate(expiry);
                db.pantryDao().update(existing);
            }
            runOnUiThread(() -> {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                finish();
            });
        });
    }

    private void delete() {
        if (existing == null) return;
        AppDatabase.executor.execute(() -> {
            db.pantryDao().delete(existing);
            runOnUiThread(this::finish);
        });
    }
}