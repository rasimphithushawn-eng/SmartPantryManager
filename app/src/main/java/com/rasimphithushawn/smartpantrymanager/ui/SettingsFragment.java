package com.rasimphithushawn.smartpantrymanager.ui;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup c, Bundle b) {
        TextView tv = new TextView(getContext());
        tv.setText("Settings coming on Day 4...");
        tv.setPadding(40, 60, 40, 40);
        return tv;
    }
}