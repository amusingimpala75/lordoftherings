package com.github.amusingimpala75.lotr.registry;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.amusingimpala75.lotr.block.ModCropBlock;
import com.github.amusingimpala75.lotr.item.*;
import com.github.amusingimpala75.lotr.materials.ModArmorMaterial;
import com.github.amusingimpala75.lotr.materials.ModToolMaterial;
import com.github.amusingimpala75.lotr.tools.ModPickaxe;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import com.github.amusingimpala75.lotr.util.ItemReg;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class ModItems {
    public static final Item MITHRIL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item GOLD_RING = new GoldRingItem(new Item.Settings().group(LOTR_MISC));
    public static final Item LEMBAS = new Item(new Item.Settings().group(LOTR_FOOD).food((new FoodComponent.Builder().hunger(10).saturationModifier(1.5F).build())));
    public static final Item BRONZE_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item ORC_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item DWARVEN_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item ELVEN_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item MITHRIL_HELMET = new ArmorItem(ModArmorMaterial.MITHRIL, EquipmentSlot.HEAD, new Item.Settings().group(LOTR_COMBAT));
    public static final Item HARAD_WARLORD_HELMET = new ArmorItem(ModArmorMaterial.HARAD_WARLORD, EquipmentSlot.HEAD, new Item.Settings().group(LOTR_COMBAT));
    public static final Item URUK_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item URUK_BERSERKER_HELMET = new ArmorItem(ModArmorMaterial.URUK_CHIEFTAIN, EquipmentSlot.HEAD, new Item.Settings().group(LOTR_COMBAT));
    public static final Item FUR = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item MITHRIL_PICKAXE = new ModPickaxe(ModToolMaterial.MITHRIL, -5, 9.0F, new Item.Settings().group(LOTR_TOOLS));
    public static final Item PINE_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "PINE"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item MALLORN_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "MALLORN"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item MIRK_OAK_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "MIRK_OAK"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item CHARRED_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "CHARRED"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item APPLE_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "APPLE"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item PEAR_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "PEAR"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item CHERRY_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "CHERRY"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item LEBETHRON_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "LEBETHRON"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item BEECH_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "BEECH"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item MAPLE_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "MAPLE"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item ASPEN_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "ASPEN"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item LAIRELOSSE_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "LAIRELOSSE"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item CEDAR_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "CEDAR"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item FIR_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "FIR"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item LARCH_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "LARCH"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item HOLLY_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "HOLLY"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item GREEN_OAK_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "GREEN_OAK"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Item POCKET_MATCH = new PocketMatchItem(new Item.Settings().group(LOTR_TOOLS).maxCount(64));
    public static final Item CYPRESS_BOAT = (new ModBoatItem(ClassTinkerers.getEnum(BoatEntity.Type.class, "CYPRESS"), (new Item.Settings()).maxCount(1).group(LOTR_MISC)));
    public static final Block FLAX_CROP = new ModCropBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).nonOpaque().noCollision(), ModItems.FLAX_SEEDS);
    public static final Block PIPEWEED_CROP = new ModCropBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).nonOpaque().noCollision(), ModItems.PIPEWEED_SEEDS);
    public static final Block LETTUCE_BLOCK = new ModCropBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).nonOpaque().noCollision(), ModItems.LETTUCE);
    public static final Item PIPEWEED_SEEDS = new AliasedBlockItem(PIPEWEED_CROP, new Item.Settings().group(LOTR_FOOD));
    public static final Item FLAX_SEEDS = new AliasedBlockItem(FLAX_CROP, new Item.Settings().group(LOTR_FOOD));
    public static final Item LETTUCE = new AliasedBlockItem(LETTUCE_BLOCK, new Item.Settings().group(LOTR_FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4F).build()));
    public static final Item CERMAIC_MUG = new DrinkVesselItem(new FabricItemSettings().group(LOTR_FOOD));
    public static final Item WOODEN_MUG = new DrinkVesselItem(new FabricItemSettings().group(LOTR_FOOD));
    public static final Item GOLDEN_GOBLET = new DrinkVesselItem(new FabricItemSettings().group(LOTR_FOOD));
    public static final StatusEffectInstance[] DWARVEN_TONIC_EFFECTS = {new StatusEffectInstance(StatusEffects.NIGHT_VISION, 4800)};
    public static final StatusEffectInstance[] ORC_DRAUGHT_EFFECTS = {new StatusEffectInstance(StatusEffects.SPEED, 1200), new StatusEffectInstance(StatusEffects.STRENGTH, 1200)};
    public static final StatusEffectInstance[] MIRUVOR_EFFECTS = {new StatusEffectInstance(StatusEffects.SPEED, 800), new StatusEffectInstance(StatusEffects.STRENGTH, 800)};



    public static void registerItems() {
        /*
        Material Items - complete
        */
        Registry.register(Registry.ITEM, id("bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, id("mithril_ingot"), MITHRIL_INGOT);
        Registry.register(Registry.ITEM, id("orc_steel_ingot"), ORC_STEEL_INGOT);
        Registry.register(Registry.ITEM, id("dwarven_steel_ingot"), DWARVEN_STEEL_INGOT);
        Registry.register(Registry.ITEM, id("elven_steel_ingot"), ELVEN_STEEL_INGOT);
        Registry.register(Registry.ITEM, id("uruk_steel_ingot"), URUK_STEEL_INGOT);
        Registry.register(Registry.ITEM, id("fur"), FUR);
        ItemReg.material("mithril_nugget");
        ItemReg.material("copper_ingot");
        ItemReg.material("tin_ingot");
        ItemReg.material("silver_ingot");
        ItemReg.material("silver_nugget");
        ItemReg.material("silver_ring");
        ItemReg.material("mithril_ring");
        ItemReg.material("salt");
        ItemReg.material("sulfur");
        ItemReg.material("niter");
        ItemReg.material("mallorn_stick");
        ItemReg.material("durnor");
        ItemReg.material("mithril_mail");
        ItemReg.material("beeswax");
        ItemReg.material("pipeweed_leaf");
        ItemReg.material("flax");
        ItemReg.material("edhelvir");
        ItemReg.material("gulduril");
        ItemReg.material("bronze_nugget");
        /*
        Misc Items - Red Book functionality, match ony lighting opposite side of block
         */
        Registry.register(Registry.ITEM, id("gold_ring"), GOLD_RING);
        ItemReg.misc("pipeweed");
        ItemReg.misc("red_book");
        Registry.register(Registry.ITEM, id("pocket_match"), POCKET_MATCH);
        ItemReg.misc("blackroot_stick");
        /*
        Food Items - drink functionality
         */
        Registry.register(Registry.ITEM, id("lembas"), LEMBAS);
        ItemReg.food2("gammon", 8, 0.8F, true, null);
        ItemReg.food2("green_apple", 4, 0.3F, false, null);
        ItemReg.food2("suspicious_meat", 7, 0.6F, true, null);
        ItemReg.food2("pear", 4, 0.3F, false, null);
        ItemReg.food2("cherry", 2, 0.2F, false, null);
        ItemReg.food2("maple_syrup", 2, 0.1F, false, null);
        ItemReg.food("clay_plate");
        ItemReg.food("clay_mug");
        ItemReg.food2("mallorn_nut", 4, 0.4F, false, null);
        Registry.register(Registry.ITEM, id("pipeweed_seeds"), PIPEWEED_SEEDS);
        Registry.register(Registry.BLOCK, id("pipeweed_crop"), PIPEWEED_CROP);
        Registry.register(Registry.ITEM, id("flax_seeds"), FLAX_SEEDS);
        Registry.register(Registry.BLOCK, id("flax_crop"), FLAX_CROP);
        Registry.register(Registry.ITEM, id("lettuce"), ModItems.LETTUCE);
        Registry.register(Registry.BLOCK, id("lettuce"), LETTUCE_BLOCK);
        ItemReg.food2("morgul_shroom", 4, 0.4F, false, null);
        ItemReg.food2("mirk_shroom", 3, 0.3F, false, new StatusEffectInstance(StatusEffects.POISON, 100, 0));
        Registry.register(Registry.ITEM, id("wooden_mug"), WOODEN_MUG);
        Registry.register(Registry.ITEM, id("ceramic_mug"), CERMAIC_MUG);
        Registry.register(Registry.ITEM, id("ale"), VesselLiquidItem.newAlcohol(0.3F, 3, 0.3F));
        Registry.register(Registry.ITEM, id("cider"), VesselLiquidItem.newAlcohol(0.3F, 4, 0.4F));
        Registry.register(Registry.ITEM, id("perry"), VesselLiquidItem.newAlcohol(0.3F, 4, 0.4F));
        Registry.register(Registry.ITEM, id("cherry_liqueur"), VesselLiquidItem.newAlcohol(1.0F, 3, 0.3F));
        Registry.register(Registry.ITEM, id("mead"), VesselLiquidItem.newAlcohol(0.6F, 4, 0.4F));
        Registry.register(Registry.ITEM, id("golden_goblet"), GOLDEN_GOBLET);
        ItemReg.food("water_drink");
        ItemReg.food("milk_drink");
        Registry.register(Registry.ITEM, id("chocolate_drink"), VesselLiquidItem.newBasic(6, 0.6F));
        Registry.register(Registry.ITEM, id("miruvor"), VesselLiquidItem.newEffects(8, 0.8F, MIRUVOR_EFFECTS));
        Registry.register(Registry.ITEM, id("orc_draught"), VesselLiquidItem.newEffDmg(6, 0.6F, 2.0F, ORC_DRAUGHT_EFFECTS));
        Registry.register(Registry.ITEM, id("dwarven_ale"), VesselLiquidItem.newAlcohol(0.4F, 3, 0.3F));
        Registry.register(Registry.ITEM, id("dwarven_tonic"), VesselLiquidItem.newEffAlc(0.2F, 4, 0.4F, DWARVEN_TONIC_EFFECTS));
        ItemReg.food("athelas_brew");
        Registry.register(Registry.ITEM, id("rum"), VesselLiquidItem.newAlcohol(1.5F, 3, 0.3F));
        Registry.register(Registry.ITEM, id("vodka"), VesselLiquidItem.newAlcohol(1.75F, 3, 0.3F));
        Registry.register(Registry.ITEM, id("maple_beer"), VesselLiquidItem.newAlcohol(0.4F, 4, 0.6F));
        Registry.register(Registry.ITEM, id("apple_juice"), VesselLiquidItem.newBasic(6,0.6F));
        Registry.register(Registry.ITEM, id("carrot_wine"), VesselLiquidItem.newAlcohol(0.8F, 3, 0.4F));
        Registry.register(Registry.ITEM, id("cactus_liqueur"), VesselLiquidItem.newAlcohol(0.8F, 2, 0.3F));
        Registry.register(Registry.ITEM, id("melon_liqueur"), VesselLiquidItem.newAlcohol(1.0F, 3, 0.3F));
        Registry.register(Registry.ITEM, id("soured_milk"), VesselLiquidItem.newAlcohol(0.2F, 5, 0.5F));
        Registry.register(Registry.ITEM, id("sweet_berry_juice"), VesselLiquidItem.newBasic(5, 0.5F));
        /*
        Armour Items - complete
         */
        Registry.register(Registry.ITEM, id("mithril_helmet"), MITHRIL_HELMET);
        ItemReg.chestplate("mithril_chestplate", ModArmorMaterial.MITHRIL);
        ItemReg.leggings("mithril_leggings", ModArmorMaterial.MITHRIL);
        ItemReg.boots("mithril_boots", ModArmorMaterial.MITHRIL);
        ItemReg.armourSet("bronze", ModArmorMaterial.BRONZE);
        ItemReg.armourSet("mordor", ModArmorMaterial.MORDOR);
        ItemReg.armourSet("gondor", ModArmorMaterial.GONDOR);
        ItemReg.armourSet("dwarven", ModArmorMaterial.DWARVEN);
        ItemReg.armourSet("lindon", ModArmorMaterial.LINDON);
        ItemReg.armourSet("rivendell", ModArmorMaterial.RIVENDELL);
        ItemReg.armourSet("galadhrim", ModArmorMaterial.GALADHRIM);
        ItemReg.armourSet("wood_elven", ModArmorMaterial.WOOD_ELVEN);
        ItemReg.armourSet("harad", ModArmorMaterial.HARAD);
        Registry.register(Registry.ITEM, id("harad_warlord_helmet"), HARAD_WARLORD_HELMET);
        ItemReg.armourSet("umbar", ModArmorMaterial.UMBAR);
        ItemReg.armourSet("uruk", ModArmorMaterial.URUK);
        Registry.register(Registry.ITEM, id("uruk_berserker_helmet"), URUK_BERSERKER_HELMET);
        ItemReg.armourSet("blue_dwarven", ModArmorMaterial.BLUE_DWARVEN);
        ItemReg.armourSet("fur", ModArmorMaterial.FUR);
        ItemReg.armourSet("rohan", ModArmorMaterial.ROHAN);
        /*
        Tools and Combat - fix attack speed
         */
        Registry.register(Registry.ITEM, id("mithril_pickaxe"), MITHRIL_PICKAXE);
        ItemReg.axe("mithril_axe", ModToolMaterial.MITHRIL, 0, 9.0F);
        ItemReg.shovel("mithril_shovel", ModToolMaterial.MITHRIL, -2, 9.0F);
        ItemReg.sword("mithril_sword", ModToolMaterial.MITHRIL, 1, 9.0F);
        ItemReg.hoe("mithril_hoe", ModToolMaterial.MITHRIL, -7, 9.0F);
        ItemReg.toolSet("bronze", "sword", ModToolMaterial.BRONZE,  5.0F, -3, 5.0F,  5.0F,  5.0F,  5.0F);
        ItemReg.toolSet("mordor", "scimitar", ModToolMaterial.MORDOR,  6.0F, -4, 6.0F,  6.0F,  6.0F, 6.0F);
        ItemReg.sword("gondor_sword", ModToolMaterial.GONDOR, 1, 6.0F);
        ItemReg.sword("rohan_sword", ModToolMaterial.ROHAN, 1, 6.0F);
        ItemReg.toolSet("dwarven", "sword", ModToolMaterial.DWARVEN, 7.0F, -5, 7.0F,  7.0F,  7.0F,  7.0F);
        ItemReg.toolSet("lindon", "sword", ModToolMaterial.LINDON,  8.0F, -5, 8.0F,  8.0F,  8.0F,  8.0F);
        ItemReg.toolSet("rivendell", "sword", ModToolMaterial.RIVENDELL,  8.0F, -5, 8.0F,  8.0F,  8.0F,  8.0F);
        ItemReg.toolSet("galadhrim", "sword", ModToolMaterial.GALADHIRM,  7.0F, -5, 7.0F,  7.0F,  7.0F,  7.0F);
        ItemReg.toolSet("wood_elven", "sword", ModToolMaterial.WOOD_ELVEN,  9.0F, -5, 9.0F,  9.0F,  9.0F,  9.0F);
        ItemReg.sword("harad_sword", ModToolMaterial.HARAD, 1, 6.0F);
        ItemReg.toolSet("uruk", "cleaver", ModToolMaterial.URUK,  6.0F, -5, 6.0F,  6.0F,  6.0F,  6.0F);
        ItemReg.sword("uruk_berserker_cleaver", ModToolMaterial.URUK, 2, 6.0F);
        ItemReg.sword("umbar_scimitar", ModToolMaterial.UMBAR, -4, 6.0F);
        ItemReg.toolSet("blue_dwarven", "sword", ModToolMaterial.BLUE_DWARVEN,  7.0F, -5, 7.0F,  7.0F,  7.0F,  7.0F);
        /*
        Boats - complete :)
         */
        Registry.register(Registry.ITEM, id("pine_boat"), PINE_BOAT);
        Registry.register(Registry.ITEM, id("mallorn_boat"), MALLORN_BOAT);
        Registry.register(Registry.ITEM, id("mirk_oak_boat"), MIRK_OAK_BOAT);
        Registry.register(Registry.ITEM, id("charred_boat"), CHARRED_BOAT);
        Registry.register(Registry.ITEM, id("apple_boat"), APPLE_BOAT);
        Registry.register(Registry.ITEM, id("pear_boat"), PEAR_BOAT);
        Registry.register(Registry.ITEM, id("cherry_boat"), CHERRY_BOAT);
        Registry.register(Registry.ITEM, id("lebethron_boat"), LEBETHRON_BOAT);
        Registry.register(Registry.ITEM, id("beech_boat"), BEECH_BOAT);
        Registry.register(Registry.ITEM, id("maple_boat"), MAPLE_BOAT);
        Registry.register(Registry.ITEM, id("aspen_boat"), ASPEN_BOAT);
        Registry.register(Registry.ITEM, id("lairelosse_boat"), LAIRELOSSE_BOAT);
        Registry.register(Registry.ITEM, id("cedar_boat"), CEDAR_BOAT);
        Registry.register(Registry.ITEM, id("fir_boat"), FIR_BOAT);
        Registry.register(Registry.ITEM, id("larch_boat"), LARCH_BOAT);
        Registry.register(Registry.ITEM, id("holly_boat"), HOLLY_BOAT);
        Registry.register(Registry.ITEM, id("green_oak_boat"), GREEN_OAK_BOAT);
        Registry.register(Registry.ITEM, id("cypress_boat"), CYPRESS_BOAT);


    }
    /*
    TODO:
        -fix tool/weapon attack speed
        -fix foods/drinks
        -fix match placement
        -add Red Book functionality ?
     */
}
