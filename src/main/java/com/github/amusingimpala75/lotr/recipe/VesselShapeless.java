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
TODO: figure out actual use
 */
public class VesselShapeless implements Recipe<Inventory> {

    private final DefaultedList<Ingredient> ingredients;
    private final ItemStack output;
    private final Identifier id;

    public VesselShapeless(Identifier id, DefaultedList<Ingredient> ingredients, ItemStack output) {
        this.id = id;
        this.ingredients = ingredients;
        this.output = output;
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
        return LotrCrafting.VESSEL_SHAPELESS;
    }

    @Override
    public RecipeType<?> getType() {
        return LotrCrafting.VESSEL_SHAPELESS_TYPE;
    }

    public DefaultedList<Ingredient> getIngredients() {
        return ingredients;
    }

    public static class Serializer implements RecipeSerializer<VesselShapeless> {

        @Override
        public VesselShapeless read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> inputs = DefaultedList.of();
            JsonArray jsonArray = JsonHelper.getArray(json, "ingredients");
            for (int i = 0; i < jsonArray.size(); i++) {
                inputs.add(Ingredient.fromJson(jsonArray.get(i)));
            }
            ItemStack output = new ItemStack(Registry.ITEM.get(Identifier.tryParse(JsonHelper.getString(JsonHelper.getObject(json, "result"), "item"))));
            return new VesselShapeless(id, inputs, output);
        }

        @Override
        public VesselShapeless read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.of();
            int inputLength = buf.readInt();
            for (int i = 0; i < inputLength; i++) {
                inputs.add(Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            return new VesselShapeless(id, inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, VesselShapeless recipe) {
            buf.writeInt(recipe.ingredients.size());
            for (int i = 0; i < recipe.ingredients.size(); i++) {
                Ingredient ingredient = recipe.ingredients.get(i);
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.output);
        }
    }
}
