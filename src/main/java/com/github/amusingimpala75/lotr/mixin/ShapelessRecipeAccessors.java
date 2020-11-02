package com.github.amusingimpala75.lotr.mixin;

import com.github.amusingimpala75.lotr.ducks.DuckForShaplessRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ShapelessRecipe.class)
public interface ShapelessRecipeAccessors extends DuckForShaplessRecipe {
    @Accessor
    DefaultedList<Ingredient> getInput();
    @Accessor
    String getGroup();
    @Accessor
    ItemStack getOutput();
}
