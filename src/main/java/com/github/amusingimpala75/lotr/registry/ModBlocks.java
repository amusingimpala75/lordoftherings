package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.Lotr;
import com.github.amusingimpala75.lotr.block.crafting.FactionCraftingTable;
import com.github.amusingimpala75.lotr.faction.Faction;
import com.github.amusingimpala75.lotr.util.BlockReg;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block GONDOR_ROCK = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block GONDOR_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.GONDOR, "container.lotr.gondor_crafting");
    public static final Block MORDOR_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.MORDOR, "container.lotr.mordor_crafting");
    public static final Block DWARVEN_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.DURINS_FOLK, "container.lotr.dwarven_crafting");
    public static final Block LINDON_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.HIGH_ELF, "container.lotr.lindon_crafting");
    public static final Block RIVENDELL_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.HIGH_ELF, "container.lotr.rivendell_crafting");
    public static final Block GALADHRIM_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.WOOD_ELF, "container.lotr.galadhrim_crafting");
    public static final Block WOOD_ELVEN_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.WOOD_ELF, "container.lotr.wood_elven_crafting");
    public static final Block HARAD_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.NEAR_HARAD, "container.lotr.harad_crafting");
    public static final Block UMBAR_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.DUNLAND, "container.lotr.umbar_crafting");
    public static final Block URUK_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.ISENGARD, "container.lotr.uruk_crafting");
    public static final Block HOBBIT_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.HOBBIT, "container.lotr.hobbit_crafting");
    public static final Block BLUE_MOUNTIAN_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.BLUE_MOUNTAINS, "container.lotr.blue_mountains_crafting");
    public static final Block ROHAN_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.ROHAN, "container.lotr.rohan_crafting");
    public static final Block RANGER_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.RANGER_NORTH, "container.lotr.ranger_crafting");
    public static final Block DOL_AMROTH_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.DOL_GULDUR, "container.lotr.dol_amroth_crafting");
    public static void registerBlocks() {
        /*
        Slab
         */
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "stone_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_stone_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "brick_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_high_elven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_high_elven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "thatch_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_mordor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_mordor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_rohan_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_rohan_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_numenorean_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_numenorean_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_blue_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_blue_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_blue_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_red_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_mordor_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_gondor_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_rohan_rock_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_galadhrim_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_galadhrim_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dwarven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dwarven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_dwarven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_wood_elven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_wood_elven_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_arnor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_arnor_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_cobblebrick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_cobblebrick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_cobblebrick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "dol_amroth_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dol_amroth_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dol_amroth_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_clay_tiling_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_umbar_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_umbar_brick_slab");
        /*
        Ore
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "copper_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "tin_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "salt_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "sulfur_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "niter_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "morgul_iron_ore_mordor");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "morgul_iron_ore_stone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "durnor_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "glowstone_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "edhelvir_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_ore_mordor");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_ore_stone");
        /*
        Stair
         */
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_stone_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_high_elven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_high_elven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "thatch_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_mordor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_mordor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_rohan_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_rohan_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_numenorean_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_numenorean_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_blue_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_blue_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_galadhrim_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_galadhrim_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dwarven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dwarven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_dwarven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_wood_elven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_wood_elven_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_arnor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_arnor_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_cobblebrick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_cobblebrick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_cobblebrick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "dol_amroth_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dol_amroth_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dol_amroth_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_clay_tiling_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_umbar_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_umbar_brick_stairs");
        /*
        Wall
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_stone_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stone_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_high_elven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_high_elven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_mordor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_mordor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_rohan_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_rohan_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_numenorean_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_numenorean_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_blue_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_blue_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_galadhrim_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_galadhrim_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dwarven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dwarven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_dwarven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_wood_elven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_wood_elven_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_arnor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_arnor_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_cobblebrick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_cobblebrick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_cobblebrick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dol_amroth_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dol_amroth_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dol_amroth_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_clay_tiling_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_umbar_brick_wall");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_umbar_brick_wall");
        /*
        Sign
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_wall_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_sign");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_wall_sign");
        /*
        Planks
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_planks");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_planks");
        /*
        Leaves
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_leaves_red");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_leaves_green");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_leaves_fruit");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_leaves_fruit");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_leaves");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_oak_leaves");
        /*
        Crafting Table
         */
        Registry.register(Registry.BLOCK, new Identifier("lotr", "gondor_crafting_table"), GONDOR_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "mordor_crafting_table"), MORDOR_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "rohan_crafting_table"), ROHAN_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "dwarven_crafting_table"), DWARVEN_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "lindon_crafting_table"), LINDON_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "rivendell_crafting_table"), RIVENDELL_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "galadhrim_crafting_table"), GALADHRIM_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "wood_elven_crafting_table"), WOOD_ELVEN_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "harad_crafting_table"), HARAD_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "umbar_crafting_table"), UMBAR_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "uruk_crafting_table"), URUK_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "hobbit_crafting_table"), HOBBIT_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "blue_mountains_crafting_table"), BLUE_MOUNTIAN_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "ranger_crafting_table"), RANGER_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "dol_amroth_crafting_table"), DOL_AMROTH_TABLE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "gondor_crafting_table"), new BlockItem(GONDOR_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "mordor_crafting_table"), new BlockItem(MORDOR_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "rohan_crafting_table"), new BlockItem(ROHAN_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "dwarven_crafting_table"), new BlockItem(DWARVEN_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "lindon_crafting_table"), new BlockItem(LINDON_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "rivendell_crafting_table"), new BlockItem(RIVENDELL_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "wood_elven_crafting_table"), new BlockItem(WOOD_ELVEN_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "galadhrim_crafting_table"), new BlockItem(GALADHRIM_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "harad_crafting_table"), new BlockItem(HARAD_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "umbar_crafting_table"), new BlockItem(UMBAR_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "uruk_crafting_table"), new BlockItem(URUK_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "hobbit_crafting_table"), new BlockItem(HOBBIT_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "blue_mountains_crafting_table"), new BlockItem(BLUE_MOUNTIAN_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "ranger_crafting_table"), new BlockItem(RANGER_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("lotr", "dol_amroth_crafting_table"), new BlockItem(DOL_AMROTH_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        /*
        Door
         */
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "shire_pine_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_door");
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_door");
        /*
        Trapdoor
         */
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "shire_pine_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_trapdoor");
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_trapdoor");
        /*
        Pressure Plate
         */
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_pressure_plate");
        /*
        Button
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_button");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_button");
        /*
        Pillar
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stone_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "brick_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wattle_and_daub_pillar");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_pillar");
        /*
        Beam
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "oak_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "spruce_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "birch_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "jungle_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "acacia_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dark_oak_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_beam");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_beam");
        /*
        Brick
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "glowing_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_gondor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_high_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_high_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_high_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_mordor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_mordor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_mordor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_rohan_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_rohan_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_rohan_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_trimmed_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_trimmed_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_trimmed_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_numenorean_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_numenorean_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_blue_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_blue_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_blue_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_red_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_galadhrim_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_galadhrim_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_galadhrim_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_dwarven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_wood_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_wood_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_wood_elven_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_arnor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_arnor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_arnor_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_cobblebrick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_cobblebrick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_cobblebrick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dol_amroth_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dol_amroth_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dol_amroth_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_numenorean_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_umbar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_umbar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_brick");
        /*
        Glass
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_fine_glass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_fine_glass");
        /*
        Glass Pane
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_fine_glass_pane");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_fine_glass_pane");
        /*
        Dripstone
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "obsidian_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "ice_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "andesite_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "diorite_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "granite_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "sandstone_dripstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_sandstone_dripstone");
        /*
        Tiling
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_clay_tiling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_clay_tiling");
        /*
        Forges and Ovens
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "alloy_forge");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_forge");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "elven_forge");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_forge");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "hobbit_oven");
        /*
        Rock
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_blue_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_red_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_mordor_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_gondor_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_rohan_rock");
        /*
        Precious Block
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "copper_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "tin_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "bronze_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "salt_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "sulfur_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "niter_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_steel_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "durnor_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_steel_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "elven_steel_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "edhelvir_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_steel_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_treasure_pile");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_treasure_pile");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "copper_treasure_pile");
        /*
        Wood - Stripped and non-stripped
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pine_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mallorn_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mirk_oak_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_charred_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_apple_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pear_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cherry_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lebethron_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_beech_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_maple_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_aspen_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lairelosse_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cedar_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_fir_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_larch_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_holly_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_wood");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_green_oak_wood");
        /*
        Log - Stripped and non-stripped
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pine_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mallorn_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_crumble");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mirk_oak_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_charred_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_apple_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pear_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cherry_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lebethron_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_beech_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_maple_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_aspen_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lairelosse_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cedar_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_fir_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_larch_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_holly_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_shroom");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_mirk_shroom");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_log");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_green_oak_log");
        /*
        Light Source
        */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_chandelier");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "iron_chandelier");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "bronze_chandelier");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_chandelier");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_chandelier");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "bronze_lantern");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "candle");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_mallorn_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_mallorn_wall_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_mallorn_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_mallorn_wall_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_mallorn_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_mallorn_wall_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_mallorn_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_mallorn_wall_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_torch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_wall_torch");
        /*
        Fence Gate
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_fence_gate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_fence_gate");
        /*
        Fence
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_fence");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_fence");
        /*
        Bars
         */
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "bronze_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_wood_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_wood_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_wood_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_bars");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_dwarven_bars");
        /*
        Sapling - not Potted
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_oak_sapling");
        /*
        Sapling - Potted
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_pine_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_mallorn_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_mirk_oak_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_apple_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_pear_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_cherry_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_lebethron_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_beech_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_maple_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_aspen_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_lairelosse_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_cedar_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_fir_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_larch_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_holly_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_green_oak_sapling");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_red_oak_sapling");
        /*
        Food
         */
        BlockReg.food(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_pie");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "fine_plate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "stoneware_plate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wooden_plate");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "keg");
        /*
        Plant
         */
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "simbelmyne");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "shire_heather");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "elanor");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "niphredil");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "bluebell");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "marigold");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "asphodel");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "lavender");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "clover");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "four_leaf_clover");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_thorn");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "flax_crop");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "lettuce");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "short_grass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wheatgrass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "flowery_grass");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "thistle");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "nettles");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "fernsprout");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "athelas");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarfwort");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_wild_pipeweed");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_wild_flax");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "pipeweed_crop");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_sand_gem");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_sand_gem");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_daisy");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "southbell");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "hibiscus");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "flame_of_harad");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wild_pipeweed");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wild_flax");


        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_gravel");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "hearth_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_ladder");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_dirt");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_moss");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_grass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "edhelvir_crystal");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_crystal");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "glowstone_crystal");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "thatch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "drystone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wattle_and_daub");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "morgul_shroom");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "potted_morgul_shroom");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "hanging_web");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "arid_grass");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_plating");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rusted_orc_plating");
    }
}
