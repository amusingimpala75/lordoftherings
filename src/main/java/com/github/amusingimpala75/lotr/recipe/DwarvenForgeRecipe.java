package com.github.amusingimpala75.lotr.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;
/*
Recipe for cooking, NOT alloying in Dwarven forge
 */
public class DwarvenForgeRecipe extends AbstractCookingRecipe {

    public DwarvenForgeRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(LotrCrafting.DWARVEN_FORGE, id, group, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LotrCrafting.DWARVEN_NON_ALLOY;
    }

    @Override
    public RecipeType<?> getType() {
        return LotrCrafting.DWARVEN_FORGE;
    }

    public static class Serializer implements RecipeSerializer<DwarvenForgeRecipe> {
        public Serializer() {}

        @Override
        public DwarvenForgeRecipe read(Identifier id, JsonObject json) {
            String group = JsonHelper.getString(json, "group", "");
            JsonElement ingredient = JsonHelper.hasArray(json, "ingredient") ? JsonHelper.getArray(json, "ingredient") : JsonHelper.getObject(json, "ingredient");
            Ingredient input = Ingredient.fromJson(ingredient);
            String output = JsonHelper.getString(json, "result");
            ItemStack result = new ItemStack(Registry.ITEM.get(id(output.substring(5))));
            float xp = JsonHelper.getFloat(json, "experience");
            int cookTime = JsonHelper.getInt(json, "cookingtime");
            return new DwarvenForgeRecipe(id, group, input, result, xp, cookTime);
        }

        @Override
        public DwarvenForgeRecipe read(Identifier id, PacketByteBuf buf) {
            String group = buf.readString();
            Ingredient input = Ingredient.fromPacket(buf);
            ItemStack output = buf.readItemStack();
            float xp = buf.readFloat();
            int cookTime = buf.readInt();
            return new DwarvenForgeRecipe(id, group, input, output, xp, cookTime);
        }

        @Override
        public void write(PacketByteBuf buf, DwarvenForgeRecipe recipe) {
            buf.writeString(recipe.group);
            recipe.input.write(buf);
            buf.writeItemStack(recipe.output);
            buf.writeFloat(recipe.experience);
            buf.writeInt(recipe.cookTime);
        }
    }
}
