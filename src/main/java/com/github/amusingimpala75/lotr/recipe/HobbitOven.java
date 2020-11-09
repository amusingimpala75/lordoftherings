package com.github.amusingimpala75.lotr.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
/*
For "alloying" in hobbit oven
 */
public class HobbitOven implements Recipe<Inventory> {

    private final ItemStack output;
    private final Identifier id;
    private final boolean swappable;
    private final float xp;
    private final int cookTime;
    private final DefaultedList<Ingredient> possibleIngredients;
    private final DefaultedList<Ingredient> alloy;

    public HobbitOven(ItemStack output, Identifier id, boolean swappable, float xp, int cookTime, DefaultedList<Ingredient> possibleIngredients, DefaultedList<Ingredient> alloy) {
        this.output = output;
        this.id = id;
        this.swappable = swappable;
        this.xp = xp;
        this.cookTime = cookTime;
        this.possibleIngredients = possibleIngredients;
        this.alloy = alloy;
    }


    @Override
    public boolean matches(Inventory inv, World world) {
        return false;
    }

    @Override
    public ItemStack craft(Inventory inv) {
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
        return LotrCrafting.HOBBIT_OVEN;
    }

    @Override
    public RecipeType<?> getType() {
        return LotrCrafting.HOBBIT_OVEN_TYPE;
    }

    public boolean isSwappable() {
        return swappable;
    }

    public float getXp() {
        return xp;
    }

    public int getCookTime() {
        return cookTime;
    }

    public DefaultedList<Ingredient> getPossibleIngredients() {
        return possibleIngredients;
    }

    public DefaultedList<Ingredient> getAlloy() {
        return alloy;
    }

    public static class Serializer implements RecipeSerializer<HobbitOven> {

        @Override
        public HobbitOven read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> possibleInputs = DefaultedList.of();
            JsonArray jsonArray = JsonHelper.getArray(json, "ingredient");
            for (int i = 0; i < jsonArray.size(); i++) {
                possibleInputs.add(Ingredient.fromJson(jsonArray.get(i)));
            }
            boolean swappable = JsonHelper.getBoolean(json, "swappable");
            float xp = JsonHelper.getFloat(json, "experience");
            int cookTime = JsonHelper.getInt(json, "cookingtime");
            JsonObject array = JsonHelper.getObject(json, "result");
            String outputItem = JsonHelper.getString(array, "item");
            ItemStack output = new ItemStack(Registry.ITEM.get(Identifier.tryParse(outputItem)));
            DefaultedList<Ingredient> possibleAlloys = DefaultedList.of();
            JsonArray jsonArray2 = JsonHelper.getArray(json, "alloy");
            for (int i = 0; i < jsonArray2.size(); i++) {
                possibleAlloys.add(Ingredient.fromJson(jsonArray2.get(i)));
            }
            return new HobbitOven(output , id, swappable, xp, cookTime, possibleInputs, possibleAlloys);
        }

        @Override
        public HobbitOven read(Identifier id, PacketByteBuf buf) {
            boolean swappable = buf.readBoolean();
            ItemStack output = buf.readItemStack();
            float xp = buf.readFloat();
            int cookTime = buf.readInt();
            DefaultedList<Ingredient> possibleIngredients = DefaultedList.of();
            int ingredientLength = buf.readInt();
            for (int i = 0; i < ingredientLength; i++) {
                possibleIngredients.add(Ingredient.fromPacket(buf));
            }
            DefaultedList<Ingredient> possibleAlloys = DefaultedList.of();
            int alloysLength = buf.readInt();
            for (int i = 0; i < alloysLength; i++) {
                possibleAlloys.add(Ingredient.fromPacket(buf));
            }
            return new HobbitOven(output, id, swappable, xp, cookTime, possibleIngredients, possibleAlloys);
        }

        @Override
        public void write(PacketByteBuf buf, HobbitOven recipe) {
            buf.writeBoolean(recipe.swappable);
            buf.writeItemStack(recipe.output);
            buf.writeFloat(recipe.xp);
            buf.writeInt(recipe.cookTime);
            buf.writeInt(recipe.possibleIngredients.size());
            for (int i = 0; i < recipe.possibleIngredients.size(); i++) {
                Ingredient ingredient = recipe.possibleIngredients.get(i);
                ingredient.write(buf);
            }
            buf.writeInt(recipe.alloy.size());
            for (int i = 0; i < recipe.alloy.size(); i++) {
                Ingredient ingredient = recipe.alloy.get(i);
                ingredient.write(buf);
            }
        }
    }
}
