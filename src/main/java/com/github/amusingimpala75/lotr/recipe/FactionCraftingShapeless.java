package com.github.amusingimpala75.lotr.recipe;

import com.github.amusingimpala75.lotr.ducks.DuckForShaplessRecipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

import java.util.Iterator;

public class FactionCraftingShapeless extends ShapelessRecipe implements FactionCrafting{
    private final String faction;
    public FactionCraftingShapeless(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> input, String faction) {
        super(id, group, output, input);
        this.faction = faction;
    }

    @Override
    public RecipeType<?> getType() {
        return LotrCrafting.FACTION;
    }

    public String getFaction() {
        return this.faction;
    }
    public static void register() {}

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LotrCrafting.SHAPELESS;
    }
    public static class Serializer extends ShapelessRecipe.Serializer {
        public FactionCraftingShapeless read(Identifier identifier, JsonObject jsonObject) {
            String string = JsonHelper.getString(jsonObject, "group", "");
            DefaultedList<Ingredient> defaultedList = getIngredients(JsonHelper.getArray(jsonObject, "ingredients"));
            if (defaultedList.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (defaultedList.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe");
            } else {
                ItemStack itemStack = ShapedRecipe.getItemStack(JsonHelper.getObject(jsonObject, "result"));
                String faction = JsonHelper.getString(jsonObject, "table", "").substring(5);
                return new FactionCraftingShapeless(identifier, string, itemStack, defaultedList, faction);
            }
        }

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();

            for(int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i));
                if (!ingredient.isEmpty()) {
                    defaultedList.add(ingredient);
                }
            }

            return defaultedList;
        }

        public FactionCraftingShapeless read(Identifier identifier, PacketByteBuf buf) {
            String string = buf.readString(32767);
            int i = buf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);

            for(int j = 0; j < defaultedList.size(); ++j) {
                defaultedList.set(j, Ingredient.fromPacket(buf));
            }

            ItemStack itemStack = buf.readItemStack();
            return new FactionCraftingShapeless(identifier, string, itemStack, defaultedList, buf.readString());
        }

        public void write(PacketByteBuf buf, FactionCraftingShapeless shapelessRecipe) {
            buf.writeString(((DuckForShaplessRecipe)shapelessRecipe).getGroup());
            buf.writeVarInt(((DuckForShaplessRecipe)shapelessRecipe).getInput().size());
            Iterator var3 = ((DuckForShaplessRecipe)shapelessRecipe).getInput().iterator();

            while(var3.hasNext()) {
                Ingredient ingredient = (Ingredient)var3.next();
                ingredient.write(buf);
            }

            buf.writeItemStack(((DuckForShaplessRecipe)shapelessRecipe).getOutput());
            buf.writeString(shapelessRecipe.getFaction());
        }
    }
    public static class Type implements RecipeType<FactionCraftingShapeless> {
        private Type() {}
        public static final Type INSTANCE = new Type();

        public static final String ID = "faction_shapeless";
    }
}
