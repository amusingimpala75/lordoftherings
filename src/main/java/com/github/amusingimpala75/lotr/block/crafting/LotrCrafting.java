package com.github.amusingimpala75.lotr.block.crafting;

import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class LotrCrafting {
    static RecipeSerializer<ShapedRecipe> SHAPED = RecipeSerializer.register("lotr:faction_shaped", new FactionCraftingRecipe.Serializer());
    static RecipeSerializer<ShapelessRecipe> SHAPELESS = RecipeSerializer.register("lotr:faction_shapeless", new FactionCraftingShapeless.Serializer());
    static RecipeSerializer<BrewingRecipe> BREWING_SERIALIZER = RecipeSerializer.register("lotr:brewing", new BrewingRecipe.Serializer());
    static RecipeType<CraftingRecipe> FACTION_SHAPED = register(FactionCraftingRecipe.Type.ID);
    static RecipeType<CraftingRecipe> FACTION_SHAPELESS = register(FactionCraftingShapeless.Type.ID);
    static RecipeType<BrewingRecipe> BREWING_TYPE = register(BrewingRecipe.Type.ID);
    public static void registerCrafting() {
        //Just to load Class (I think)
    }

    static <T extends Recipe<?>> RecipeType<T> register(final String string) {
        return (RecipeType) Registry.register(Registry.RECIPE_TYPE, (Identifier)(new Identifier("lotr", string)), new RecipeType<T>() {
            public String toString() {
                return string;
            }
        });
    }
}
