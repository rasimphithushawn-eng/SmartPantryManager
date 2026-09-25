package com.rasimphithushawn.smartpantrymanager.logic;

import com.rasimphithushawn.smartpantrymanager.database.PantryItem;
import com.rasimphithushawn.smartpantrymanager.database.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeMatcher {

    /**
     * STRICT MATCHING.
     * Returns true only if the pantry contains EVERY required ingredient
     * in at least the required quantity.
     */
    public static boolean canMakeStrict(Recipe recipe, List<PantryItem> pantry) {
        List<RequiredIngredient> required = parseRequired(recipe.getRequiredIngredients());

        Map<String, Double> pantryMap = new HashMap<>();
        for (PantryItem item : pantry) {
            String key = item.getNormalizedName();
            double current = pantryMap.containsKey(key) ? pantryMap.get(key) : 0.0;
            pantryMap.put(key, current + item.getQuantity());
        }

        for (RequiredIngredient req : required) {
            String key = normalize(req.name);
            if (!pantryMap.containsKey(key)) return false;
            if (pantryMap.get(key) < req.quantity) return false;
        }
        return true;
    }

    /** Optional "Almost There" helper. */
    public static List<String> getMissing(Recipe recipe, List<PantryItem> pantry) {
        List<RequiredIngredient> required = parseRequired(recipe.getRequiredIngredients());
        Map<String, Double> pantryMap = new HashMap<>();
        for (PantryItem item : pantry) {
            String key = item.getNormalizedName();
            double current = pantryMap.containsKey(key) ? pantryMap.get(key) : 0.0;
            pantryMap.put(key, current + item.getQuantity());
        }
        List<String> missing = new ArrayList<>();
        for (RequiredIngredient req : required) {
            String key = normalize(req.name);
            if (!pantryMap.containsKey(key) || pantryMap.get(key) < req.quantity) {
                missing.add(req.name);
            }
        }
        return missing;
    }

    public static List<Recipe> filterSuggested(List<Recipe> all, List<PantryItem> pantry) {
        List<Recipe> out = new ArrayList<>();
        for (Recipe r : all) if (canMakeStrict(r, pantry)) out.add(r);
        return out;
    }

    // ---------- helpers ----------

    private static class RequiredIngredient {
        String name; double quantity; String unit;
    }

    private static List<RequiredIngredient> parseRequired(String data) {
        List<RequiredIngredient> list = new ArrayList<>();
        if (data == null || data.isEmpty()) return list;
        for (String part : data.split(",")) {
            String[] tok = part.trim().split(":");
            if (tok.length >= 2) {
                RequiredIngredient r = new RequiredIngredient();
                r.name = tok[0];
                try { r.quantity = Double.parseDouble(tok[1]); }
                catch (NumberFormatException e) { r.quantity = 1; }
                r.unit = tok.length > 2 ? tok[2] : "pieces";
                list.add(r);
            }
        }
        return list;
    }

    public static String normalize(String s) {
        String n = s.toLowerCase().trim();
        if (n.endsWith("es") && n.length() > 3) return n.substring(0, n.length() - 2);
        if (n.endsWith("s") && n.length() > 2) return n.substring(0, n.length() - 1);
        return n;
    }
}