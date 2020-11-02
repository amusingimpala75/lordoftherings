package com.github.amusingimpala75.lotr.block.crafting;

import com.github.amusingimpala75.lotr.mixin.ShapedRecipeInvokers;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

import java.util.Map;

public class FactionCraftingRecipe extends ShapedRecipe implements FactionCrafting {
    private final String faction;
    public FactionCraftingRecipe(Identifier id, String group, int width, int height, DefaultedList<Ingredient> ingredients, ItemStack output, String faction) {
        super(id, group, width, height, ingredients, output);
        this.faction = faction;
    }
    public String getFaction() {
        return faction;
    }

    @Override
    public RecipeType<?> getType() {
        return LotrCrafting.FACTION_SHAPED;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LotrCrafting.SHAPED;
    }
    public static void register() {
    }


    public static class Serializer extends ShapedRecipe.Serializer {
        @Override
        public FactionCraftingRecipe read(Identifier identifier, JsonObject jsonObject) {
            String string = JsonHelper.getString(jsonObject, "group", "");
            Map<String, Ingredient> map = ShapedRecipeInvokers.invokeGetComponents(JsonHelper.getObject(jsonObject, "key"));
            String[] strings = ShapedRecipeInvokers.invokeCombinePattern(ShapedRecipeInvokers.invokeGetPattern(JsonHelper.getArray(jsonObject, "pattern")));
            int i = strings[0].length();
            int j = strings.length;
            DefaultedList<Ingredient> defaultedList = ShapedRecipeInvokers.invokeGetIngredients(strings, map, i, j);
            ItemStack itemStack = ShapedRecipe.getItemStack(JsonHelper.getObject(jsonObject, "result"));
            String table = JsonHelper.getString(jsonObject, "table", "").substring(5);
            return new FactionCraftingRecipe(identifier, string, i, j, defaultedList, itemStack, table);
        }

        public void write(PacketByteBuf buf, FactionCraftingRecipe shapedRecipe) {
            super.write(buf, shapedRecipe);
            buf.writeString(shapedRecipe.getFaction());
        }

        @Override
        public FactionCraftingRecipe read(Identifier identifier, PacketByteBuf buf) {
            ShapedRecipe recipe = super.read(identifier, buf);
            return new FactionCraftingRecipe(recipe.getId(), recipe.getGroup(), recipe.getWidth(), recipe.getHeight(), recipe.getPreviewInputs(), recipe.getOutput(), buf.readString());
        }
    }
    public static class Type implements RecipeType<FactionCraftingRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "faction_shaped";
    }
}
