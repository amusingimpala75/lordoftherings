package com.github.amusingimpala75.lotr.mixin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;
/*
Invokers to help with "copying" vanilla Shaped Recipes without actually copying it
 */
@Mixin(ShapedRecipe.class)
public interface ShapedRecipeInvokers {
    @Invoker
    static Map<String, Ingredient> invokeGetComponents(JsonObject json) {
        throw new AssertionError();
    }
    @Invoker
    static String[] invokeCombinePattern(String... lines) {
        throw new AssertionError();
    }
    @Invoker
    static String[] invokeGetPattern(JsonArray json) {
        throw new AssertionError();
    }
    @Invoker
    static DefaultedList<Ingredient> invokeGetIngredients(String[] pattern, Map<String, Ingredient> key, int width, int height) {
        throw new AssertionError();
    }
}
