package com.github.amusingimpala75.lotr.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
/*
Recipe for brewing
 */
public class BrewingRecipe implements Recipe<CraftingInventory> {
    public final Identifier id;
    private final DefaultedList<Ingredient> inputs;
    private final ItemStack output;
    private final float xp;
    private final int brewTime;
    public BrewingRecipe(Identifier id, DefaultedList<Ingredient> inputs, ItemStack output, float xp, int brewTime) {
        this.id = id;
        this.inputs = inputs;
        this.output = output;
        this.xp = xp;
        this.brewTime = brewTime;
    }

    public DefaultedList<Ingredient> getInputs() {
        return inputs;
    }

    @Override
    public boolean matches(CraftingInventory inv, World world) {
        return false;   //CHECK
    }

    @Override
    public ItemStack craft(CraftingInventory inv) {
        return getOutput();
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return output;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LotrCrafting.BREWING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return LotrCrafting.BREWING_TYPE;
    }
    public static class Serializer implements RecipeSerializer<BrewingRecipe> {
        public Serializer() {}

        @Override
        public BrewingRecipe read(Identifier id, JsonObject json) {
            ItemStack output = new ItemStack(Registry.ITEM.get(new Identifier("lotr", (JsonHelper.getString(json, "result")).substring(5))));
            float xp = JsonHelper.getFloat(json, "experience");
            int brewTime = JsonHelper.getInt(json, "brewtime");
            DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(6, Ingredient.EMPTY);
            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromJson(json.getAsJsonArray("ingredients").get(i)));
            }
            return new BrewingRecipe(id, ingredients, output, xp, brewTime);
        }

        @Override
        public BrewingRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(6, Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i ++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            float xp = buf.readFloat();
            int brewTime = buf.readInt();
            return new BrewingRecipe(id, inputs, output, xp, brewTime);
        }

        @Override
        public void write(PacketByteBuf buf, BrewingRecipe recipe) {
            for (Ingredient ingredient:recipe.inputs) {
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.output);
            buf.writeFloat(recipe.xp);
            buf.writeInt(recipe.brewTime);
        }
    }
}
