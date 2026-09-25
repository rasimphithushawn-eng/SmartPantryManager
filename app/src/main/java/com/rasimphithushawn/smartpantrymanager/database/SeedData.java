package com.rasimphithushawn.smartpantrymanager.database;

import java.util.ArrayList;
import java.util.List;

public class SeedData {
    public static List<Recipe> getRecipes() {
        List<Recipe> list = new ArrayList<>();
        list.add(new Recipe("Tomato Pasta",
                "pasta:200:grams,tomato:3:pieces,garlic:2:cloves,olive oil:2:tbsp",
                "1. Boil pasta.\n2. Sauté garlic in olive oil.\n3. Add chopped tomatoes.\n4. Mix and serve."));
        list.add(new Recipe("Onion Omelette",
                "egg:2:pieces,onion:1:piece,oil:1:tbsp,salt:1:pinch",
                "1. Beat eggs.\n2. Chop onion and add.\n3. Cook in pan."));
        list.add(new Recipe("Garlic Bread",
                "bread:4:slices,garlic:3:cloves,butter:2:tbsp",
                "1. Mix garlic with butter.\n2. Spread on bread.\n3. Toast."));
        list.add(new Recipe("Tomato Soup",
                "tomato:4:pieces,onion:1:piece,garlic:2:cloves,salt:1:pinch",
                "1. Sauté onion & garlic.\n2. Add tomatoes and water.\n3. Blend and simmer."));
        list.add(new Recipe("Cheese Sandwich",
                "bread:2:slices,cheese:2:slices,butter:1:tbsp",
                "1. Butter bread.\n2. Add cheese.\n3. Grill until melted."));
        list.add(new Recipe("Vegetable Stir Fry",
                "carrot:2:pieces,broccoli:1:piece,onion:1:piece,soy sauce:2:tbsp,oil:1:tbsp",
                "1. Chop vegetables.\n2. Stir fry in oil.\n3. Add soy sauce."));
        list.add(new Recipe("Egg Fried Rice",
                "rice:200:grams,egg:2:pieces,onion:1:piece,soy sauce:1:tbsp",
                "1. Cook rice.\n2. Scramble eggs.\n3. Mix with rice and soy."));
        list.add(new Recipe("Pancakes",
                "flour:200:grams,milk:200:ml,egg:1:piece,sugar:2:tbsp",
                "1. Mix dry ingredients.\n2. Add milk and egg.\n3. Cook on pan."));
        list.add(new Recipe("Guacamole",
                "avocado:2:pieces,tomato:1:piece,onion:1:piece,lime:1:piece,salt:1:pinch",
                "1. Mash avocado.\n2. Chop tomato & onion.\n3. Mix with lime juice."));
        list.add(new Recipe("Greek Salad",
                "cucumber:1:piece,tomato:2:pieces,feta:100:grams,olive oil:2:tbsp",
                "1. Chop cucumber & tomato.\n2. Add feta.\n3. Drizzle with oil."));
        list.add(new Recipe("Banana Smoothie",
                "banana:2:pieces,milk:200:ml,honey:1:tbsp",
                "1. Blend everything.\n2. Serve chilled."));
        list.add(new Recipe("Quesadilla",
                "tortilla:2:pieces,cheese:100:grams,onion:1:piece",
                "1. Fill tortilla with cheese & onion.\n2. Fold and grill."));
        list.add(new Recipe("Chicken Soup",
                "chicken:200:grams,carrot:1:piece,onion:1:piece,garlic:2:cloves",
                "1. Boil chicken.\n2. Add chopped vegetables.\n3. Simmer 20 mins."));
        list.add(new Recipe("Mashed Potatoes",
                "potato:4:pieces,butter:2:tbsp,milk:50:ml,salt:1:pinch",
                "1. Boil potatoes.\n2. Mash with butter and milk."));
        list.add(new Recipe("Cheese Omelette",
                "egg:3:pieces,cheese:50:grams,butter:1:tbsp",
                "1. Beat eggs.\n2. Add cheese.\n3. Cook in butter."));
        list.add(new Recipe("Fruit Salad",
                "apple:1:piece,banana:1:piece,orange:1:piece,honey:1:tbsp",
                "1. Chop fruits.\n2. Drizzle honey."));
        list.add(new Recipe("Fried Egg",
                "egg:2:pieces,oil:1:tbsp,salt:1:pinch",
                "1. Heat oil.\n2. Crack eggs.\n3. Fry and season."));
        list.add(new Recipe("Spaghetti Aglio",
                "spaghetti:200:grams,garlic:4:cloves,olive oil:3:tbsp,chili:1:piece",
                "1. Boil spaghetti.\n2. Sauté garlic & chili.\n3. Toss together."));
        list.add(new Recipe("Cheese Toast",
                "bread:2:slices,cheese:2:slices",
                "1. Put cheese on bread.\n2. Toast until melted."));
        list.add(new Recipe("Tomato Bruschetta",
                "bread:4:slices,tomato:3:pieces,garlic:2:cloves,olive oil:2:tbsp",
                "1. Toast bread.\n2. Rub with garlic.\n3. Top with chopped tomato & oil."));
        return list;
    }
}