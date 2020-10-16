package com.github.amusingimpala75.lotr.registry;

import com.chocohead.mm.api.ClassTinkerers;
import com.github.amusingimpala75.lotr.item.GoldRingItem;
import com.github.amusingimpala75.lotr.item.ModBoatItem;
import com.github.amusingimpala75.lotr.materials.ModArmorMaterial;
import com.github.amusingimpala75.lotr.materials.ModToolMaterial;
import com.github.amusingimpala75.lotr.tools.ModPickaxe;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import com.github.amusingimpala75.lotr.util.ItemReg;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class ModItems {
    public static final Item MITHRIL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item GOLD_RING = new GoldRingItem(new Item.Settings().group(LOTR_MISC));
    public static final Item LEMBAS = new Item(new Item.Settings().group(LOTR_FOOD));
    public static final Item BRONZE_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item ORC_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item DWARVEN_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item ELVEN_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item MITHRIL_HELMET = new ArmorItem(ModArmorMaterial.MITHRIL, EquipmentSlot.HEAD, new Item.Settings().group(LOTR_COMBAT));
    public static final Item HARAD_WARLORD_HELMET = new ArmorItem(ModArmorMaterial.HARAD, EquipmentSlot.HEAD, new Item.Settings().group(LOTR_COMBAT));
    public static final Item URUK_STEEL_INGOT = new Item(new Item.Settings().group(LOTR_MATERIALS));
    public static final Item URUK_BERSERKER_HELMET = new ArmorItem(ModArmorMaterial.URUK, EquipmentSlot.HEAD, new Item.Settings().group(LOTR_COMBAT));
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


    public static void registerItems() {
        /*
        Material Items
        */
        Registry.register(Registry.ITEM, new Identifier("lotr", "bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mithril_ingot"), MITHRIL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "orc_steel_ingot"), ORC_STEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "dwarven_steel_ingot"), DWARVEN_STEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "elven_steel_ingot"), ELVEN_STEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "uruk_steel_ingot"), URUK_STEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "fur"), FUR);
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
        Misc Items
         */
        Registry.register(Registry.ITEM, new Identifier("lotr", "gold_ring"), GOLD_RING);
        ItemReg.misc("pipeweed");
        /*
        Food Items
         */
        Registry.register(Registry.ITEM, new Identifier("lotr", "lembas"), LEMBAS);
        ItemReg.food("gammon");
        ItemReg.food("green_apple");
        ItemReg.food("suspicious_meat");
        ItemReg.food("pear");
        ItemReg.food("cherry");
        ItemReg.food("maple_syrup");
        ItemReg.food("clay_plate");
        ItemReg.food("clay_mug");
        ItemReg.food("mallorn_nut");
        /*
        Armour Items
         */
        Registry.register(Registry.ITEM, new Identifier("lotr", "mithril_helmet"), MITHRIL_HELMET);
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
        Registry.register(Registry.ITEM, new Identifier("lotr", "harad_warlord_helmet"), HARAD_WARLORD_HELMET);
        ItemReg.armourSet("umbar", ModArmorMaterial.UMBAR);
        ItemReg.armourSet("uruk", ModArmorMaterial.URUK);
        Registry.register(Registry.ITEM, new Identifier("lotr", "uruk_berserker_helmet"), URUK_BERSERKER_HELMET);
        ItemReg.armourSet("blue_dwarven", ModArmorMaterial.BLUE_DWARVEN);
        ItemReg.armourSet("fur", ModArmorMaterial.FUR);
        /*
        Tools and Combat
         */
        Registry.register(Registry.ITEM, new Identifier("lotr", "mithril_pickaxe"), MITHRIL_PICKAXE);
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
        Boats
         */
        Registry.register(Registry.ITEM, new Identifier("lotr", "pine_boat"), PINE_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mallorn_boat"), MALLORN_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mirk_oak_boat"), MIRK_OAK_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "charred_boat"), CHARRED_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "apple_boat"), APPLE_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "pear_boat"), PEAR_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "cherry_boat"), CHERRY_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "lebethron_boat"), LEBETHRON_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "beech_boat"), BEECH_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "maple_boat"), MAPLE_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "aspen_boat"), ASPEN_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "lairelosse_boat"), LAIRELOSSE_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "cedar_boat"), CEDAR_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "fir_boat"), FIR_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "larch_boat"), LARCH_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "holly_boat"), HOLLY_BOAT);
        Registry.register(Registry.ITEM, new Identifier("lotr", "green_oak_boat"), GREEN_OAK_BOAT);
    }
}
