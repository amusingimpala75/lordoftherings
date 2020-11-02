package com.github.amusingimpala75.lotr.ducks;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.collection.DefaultedList;

public interface DuckForShaplessRecipe {
    DefaultedList<Ingredient> getInput();
    String getGroup();
    ItemStack getOutput();
}
