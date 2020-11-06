package com.github.amusingimpala75.lotr.recipe;

import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public abstract class LotrCrafting {
    public static RecipeSerializer<ShapedRecipe> SHAPED = RecipeSerializer.register("lotr:faction_shaped", new FactionCraftingRecipe.Serializer());
    public static RecipeSerializer<ShapelessRecipe> SHAPELESS = RecipeSerializer.register("lotr:faction_shapeless", new FactionCraftingShapeless.Serializer());
    public static RecipeSerializer<BrewingRecipe> BREWING_SERIALIZER = RecipeSerializer.register("lotr:brewing", new BrewingRecipe.Serializer());
    public static RecipeSerializer<DwarvenForgeRecipe> DWARVEN_NON_ALLOY = RecipeSerializer.register("lotr:dwarven_forge", new DwarvenForgeRecipe.Serializer());
    public static RecipeSerializer<OrcForgeRecipe> ORC_NON_ALLOY = RecipeSerializer.register("lotr:orc_forge", new OrcForgeRecipe.Serializer());
    public static RecipeSerializer<AlloyForge> ALLOY_FORGE = RecipeSerializer.register("lotr:alloy_forge", new AlloyForge.Serializer());
    public static RecipeSerializer<OrcForgeAlloy> ORC_ALLOY_FORGE = RecipeSerializer.register("lotr:orc_forge_alloy", new OrcForgeAlloy.Serializer());
    public static RecipeSerializer<ElvenForgeAlloy> ELVEN_ALLOY_FORGE = RecipeSerializer.register("lotr:elven_forge_alloy", new ElvenForgeAlloy.Serializer());
    public static RecipeSerializer<DwarvenForgeAlloy> DWARVEN_ALLOY_FORGE = RecipeSerializer.register("lotr:dwarven_forge_alloy", new DwarvenForgeAlloy.Serializer());
    public static RecipeSerializer<VesselShapeless> VESSEL_SHAPELESS = RecipeSerializer.register("lotr:vessel_drink_shapeless", new VesselShapeless.Serializer());
    public static RecipeSerializer<HobbitOven> HOBBIT_OVEN = RecipeSerializer.register("lotr:hobbit_oven_alloy", new HobbitOven.Serializer());

    public static RecipeType<BrewingRecipe> BREWING_TYPE = register("brewing");
    public static RecipeType<CraftingRecipe> FACTION = register("faction");
    public static RecipeType<DwarvenForgeRecipe> DWARVEN_FORGE = register("dwarven_forge");
    public static RecipeType<OrcForgeRecipe> ORC_FORGE = register("orc_forge");
    public static RecipeType<AlloyForge> ALLOY_FORGE_TYPE = register("alloy_forge");
    public static RecipeType<OrcForgeAlloy> ORC_ALLOY = register("orc_alloy");
    public static RecipeType<ElvenForgeAlloy> ELVEN_ALLOY = register("elven_alloy");
    public static RecipeType<DwarvenForgeAlloy> DWARVEN_ALLOY = register("dwarven_alloy");
    public static RecipeType<VesselShapeless> VESSEL_SHAPELESS_TYPE = register("vessel_drink_shapeless");
    public static RecipeType<HobbitOven> HOBBIT_OVEN_TYPE = register("hobbit_oven_alloy");

    public static void registerCrafting() {
        //Just to load Class
    }

    static <T extends Recipe<?>> RecipeType<T> register(final String string) {
        return (RecipeType<T>) Registry.register(Registry.RECIPE_TYPE, (Identifier)(new Identifier("lotr", string)), new RecipeType<T>() {
            public String toString() {
                return string;
            }
        });
    }
}
