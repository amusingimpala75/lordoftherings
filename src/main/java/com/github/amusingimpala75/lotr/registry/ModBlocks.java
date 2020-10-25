package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.Lotr;
import com.github.amusingimpala75.lotr.block.*;
import com.github.amusingimpala75.lotr.block.crafting.FactionCraftingTable;
import com.github.amusingimpala75.lotr.faction.Faction;
import com.github.amusingimpala75.lotr.util.BlockReg;
import com.github.amusingimpala75.lotr.world.features.AspenSaplingGen;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
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
    public static final Block ANGMAR_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.STONE), Faction.ANGMAR, "container.lotr.angmar_crafting");
    public static final Block COPPER_ORE = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block SILVER_ORE = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block SULFUR_ORE = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block NITER_ORE = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block SALT_ORE = new Block(FabricBlockSettings.of(Material.STONE));
    public static final Block CLOVER = new CloverBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block CLOVER_POTTED = new FlowerPotBlock(CLOVER, FabricBlockSettings.of(Material.ORGANIC_PRODUCT));
    public static final Block FOUR_CLOVER = new FlowerBlock(StatusEffects.LUCK, 1, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block FOUR_CLOVER_POTTED = new FlowerPotBlock(FOUR_CLOVER, FabricBlockSettings.of(Material.ORGANIC_PRODUCT));
    public static final Block NETTLES = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block POTTED_NETTLES = new FlowerPotBlock(NETTLES, FabricBlockSettings.of(Material.ORGANIC_PRODUCT));
    public static final Block THISTLES = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block POTTED_THISTLES = new FlowerPotBlock(THISTLES, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly());
    public static final Block MARIGOLD = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block POTTED_MARIGOLD = new FlowerPotBlock(MARIGOLD, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly());
    public static final Block BLUEBELL = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block POTTED_BLUEBELL = new FlowerPotBlock(BLUEBELL, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly());
    public static final Block LAVENDER = new FlowerBlock(StatusEffects.GLOWING, 1, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly().noCollision());
    public static final Block POTTED_LAVENDER = new FlowerPotBlock(LAVENDER, FabricBlockSettings.of(Material.ORGANIC_PRODUCT).breakInstantly());
    public static final Block ASPEN_LEAVES = new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).nonOpaque());
    public static final Block ASPEN_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD, (blockState) -> {
        return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.BROWN : MaterialColor.BROWN;
    }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block ASPEN_SAPLING = new ModSaplingBlock(new AspenSaplingGen(), FabricBlockSettings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.GRASS));
    public static final Block POTTED_ASPEN = new FlowerPotBlock(ASPEN_SAPLING, FabricBlockSettings.of(Material.ORGANIC_PRODUCT));
    public static final Block PINE_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block MALLORN_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block MIRK_OAK_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block CHARRED_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block APPLE_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block PEAR_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block CHERRY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block LEBETHRON_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block BEECH_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block MAPLE_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block ASPEN_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block LAIRELOSSE_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block CEDAR_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block FIR_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block LARCH_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block HOLLY_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block GREEN_OAK_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block PINE_SIGN = new SignBlock(FabricBlockSettings.of(Material.WOOD).noCollision(), ModSignType.PINE);
    public static final Block PINE_WALL_SIGN = new WallSignBlock(FabricBlockSettings.of(Material.WOOD).noCollision(), ModSignType.PINE);
    public static final Block ORC_STEEL_BLOCK = new ModDirectionalBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block URUK_STEEL_BLOCK = new ModDirectionalBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block MALLORN_LADDER = new ModLadderBlock(FabricBlockSettings.of(Material.WOOD).nonOpaque());
    public static final Block BRONZE_LANTERN = new LanternBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().luminance((state) -> {
        return 15;
    }));
    public static final Block CANDLE = new ModCandleBlock(AbstractBlock.Settings.of(Material.UNDERWATER_PLANT).luminance((state) -> {
        return SeaPickleBlock.isDry(state) ? 3 + 3 * (Integer)state.get(SeaPickleBlock.PICKLES) : 0;
    }).sounds(BlockSoundGroup.SLIME).nonOpaque());
    public static final Block ORC_TORCH = new ModOrcTorch(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().luminance((state) -> {
        return 15;
    }).noCollision());
    public static final Block DORWINION_CRAFTING_TABLE = new FactionCraftingTable(FabricBlockSettings.of(Material.WOOD), Faction.DORWINION, "container.lotr.dorwinion_crafting");
    public static final Block CYPRESS_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD));
    public static final Block KEG = new Keg(FabricBlockSettings.of(Material.WOOD).nonOpaque());
    //Alloy, Dwarven, Elven, Orc, Hobbit
    public static final Block ALLOY_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block DWARVEN_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block ELVEN_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block ORC_FORGE = new ForgeBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block HOBBIT_OVEN = new OvenBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block HEARTH = new HearthBlock(FabricBlockSettings.of(Material.STONE));
    public static final Block HANGING_WEB = new HangingWeb(FabricBlockSettings.of(Material.COBWEB).nonOpaque().noCollision());
    public static final Block MORDOR_ROCK = new MordorRock(FabricBlockSettings.of(Material.STONE).ticksRandomly());
    public static final Block DIRTY_CHALK = new DirtyChalk(FabricBlockSettings.of(Material.STONE));
    public static final Block MIRK_OAK_LEAVES = new MirkOakLeaves(FabricBlockSettings.of(Material.LEAVES).nonOpaque());

    //public static BlockEntityType<?> SIGN2;


    public static void registerBlocks() {
        /*
        Sign - don't render into world
         */
        Registry.register(Registry.BLOCK, new Identifier("lotr", "pine_sign"), PINE_SIGN);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "pine_wall_sign"), PINE_WALL_SIGN);
        Registry.register(Registry.ITEM, new Identifier("lotr", "pine_sign"), new BlockItem(PINE_SIGN, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn", ModSignType.MALLORN);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak", ModSignType.MIRK_OAK);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred", ModSignType.CHARRED);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple", ModSignType.APPLE);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear", ModSignType.PEAR);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry", ModSignType.CHERRY);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron", ModSignType.LEBETHRON);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech", ModSignType.BEECH);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple", ModSignType.MAPLE);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen", ModSignType.ASPEN);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse", ModSignType.LAIRELOSSE);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar", ModSignType.CEDAR);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir", ModSignType.FIR);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch", ModSignType.LARCH);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly", ModSignType.HOLLY);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak", ModSignType.GREEN_OAK);
        BlockReg.sign(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress", ModSignType.CYPRESS);
        /*
        Slab - still need to fix models, perhaps add on-the-fly resource generation
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
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "angmar_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_wool_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_angmar_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_angmar_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_angmar_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_plating_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "rusted_orc_plating_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "angmar_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "polished_chalk_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "dorwinion_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dorwinion_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dorwinion_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_dorwinion_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_dorwinion_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_dorwinion_brick_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "dorwinion_pillar_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_sandstone_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cut_white_sandstone_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_white_sandstone_slab");
        BlockReg.slab(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_slab");
        /*
        Ore - complete
         */
        Registry.register(Registry.BLOCK, new Identifier("lotr", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "tin_ore"), TIN_ORE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "tin_ore"), new BlockItem(TIN_ORE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "silver_ore"), SILVER_ORE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "silver_ore"), new BlockItem(SILVER_ORE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_ore");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "salt_ore"), SALT_ORE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "salt_ore"), new BlockItem(SALT_ORE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "sulfur_ore"), SULFUR_ORE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "sulfur_ore"), new BlockItem(SULFUR_ORE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "niter_ore"), NITER_ORE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "niter_ore"), new BlockItem(NITER_ORE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "morgul_iron_ore_mordor");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "morgul_iron_ore_stone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "durnor_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "glowstone_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "edhelvir_ore");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_ore_mordor");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_ore_stone");
        /*
        Stair - complete
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
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_wool_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_angmar_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_angmar_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_angmar_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "angmar_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "rusted_orc_plating_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_plating_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "polished_chalk_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "dorwinion_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dorwinion_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dorwinion_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_dorwinion_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_dorwinion_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_dorwinion_brick_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_sandstone_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_white_sandstone_stairs");
        BlockReg.stair(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_stairs");
        /*
        Wall - don't connect visibly (but actually do)
         */
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_stone_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "stone_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_high_elven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_high_elven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_mordor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_mordor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_rohan_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_rohan_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_numenorean_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_numenorean_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_blue_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_blue_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_galadhrim_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_galadhrim_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dwarven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dwarven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_dwarven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_wood_elven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_wood_elven_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_arnor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_arnor_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_cobblebrick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_gondor_cobblebrick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_gondor_cobblebrick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "dol_amroth_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dol_amroth_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dol_amroth_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_clay_tiling_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_umbar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_umbar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_angmar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_angmar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_angmar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "angmar_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "polished_chalk_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "dorwinion_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dorwinion_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dorwinion_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_dorwinion_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_dorwinion_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_dorwinion_brick_wall");
        BlockReg.wall(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_sandstone_wall");
        /*
        Planks - complete
         */
        Registry.register(Registry.BLOCK, new Identifier("lotr", "pine_planks"), PINE_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "pine_planks"), new BlockItem(PINE_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "mallorn_planks"), MALLORN_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mallorn_planks"), new BlockItem(MALLORN_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "mirk_oak_planks"), MIRK_OAK_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mirk_oak_planks"), new BlockItem(MIRK_OAK_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "charred_planks"), CHARRED_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "charred_planks"), new BlockItem(CHARRED_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "apple_planks"), APPLE_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "apple_planks"), new BlockItem(APPLE_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "pear_planks"), PEAR_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "pear_planks"), new BlockItem(PEAR_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "cherry_planks"), CHERRY_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "cherry_planks"), new BlockItem(CHERRY_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "lebethron_planks"), LEBETHRON_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "lebethron_planks"), new BlockItem(LEBETHRON_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "beech_planks"), BEECH_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "beech_planks"), new BlockItem(BEECH_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "maple_planks"), MAPLE_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "maple_planks"), new BlockItem(MAPLE_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "aspen_planks"), ASPEN_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "aspen_planks"), new BlockItem(ASPEN_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "lairelosse_planks"), LAIRELOSSE_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "lairelosse_planks"), new BlockItem(LAIRELOSSE_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "cedar_planks"), CEDAR_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "cedar_planks"), new BlockItem(CEDAR_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "fir_planks"), FIR_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "fir_planks"), new BlockItem(FIR_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "larch_planks"), LARCH_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "larch_planks"), new BlockItem(LARCH_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "holly_planks"), HOLLY_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "holly_planks"), new BlockItem(HOLLY_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "green_oak_planks"), GREEN_OAK_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "green_oak_planks"), new BlockItem(GREEN_OAK_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "cypress_planks"), CYPRESS_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("lotr", "cypress_planks"), new BlockItem(CYPRESS_PLANKS, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        /*
        Leaves - complete
         */
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "pine_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "mallorn_leaves");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "mirk_oak_leaves"), MIRK_OAK_LEAVES);
        Registry.register(Registry.ITEM,  new Identifier("lotr", "mirk_oak_leaves"), new BlockItem(MIRK_OAK_LEAVES, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "apple_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "apple_leaves_red");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "apple_leaves_green");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "pear_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "pear_leaves_fruit");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "cherry_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "cherry_leaves_fruit");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "lebethron_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "beech_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "maple_leaves");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "aspen_leaves"), ASPEN_LEAVES);
        Registry.register(Registry.ITEM, new Identifier("lotr", "aspen_leaves"), new BlockItem(ASPEN_LEAVES, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "lairelosse_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "cedar_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "fir_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "larch_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "holly_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "green_oak_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "red_oak_leaves");
        BlockReg.leaves(Material.LEAVES, Lotr.LOTR_BLOCKS, true, "cypress_leaves");
        /*
        Crafting Table - individual recipes need to be fixed
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
        Registry.register(Registry.BLOCK, new Identifier("lotr", "angmar_crafting_table"), ANGMAR_TABLE);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "dorwinion_crafting_table"), DORWINION_CRAFTING_TABLE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "dorwinion_crafting_table"), new BlockItem(DORWINION_CRAFTING_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
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
        Registry.register(Registry.ITEM, new Identifier("lotr", "angmar_crafting_table"), new BlockItem(ANGMAR_TABLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        /*
        Door - complete
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
        BlockReg.door(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_door");
        /*
        Trapdoor - complete
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
        BlockReg.trapdoor(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_trapdoor");
        /*
        Pressure Plate - complete
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
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_pressure_plate");
        BlockReg.pressurePlate(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_pressure_plate");
        /*
        Button - complete
         */
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_rock_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_button");
        BlockReg.button(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_button");
        /*
        Pillar - doesn't update on neighborUpdate
         */
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "stone_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "galadhrim_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "wood_elven_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_harad_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "numenorean_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "uruk_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "brick_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "wattle_and_daub_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "arnor_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "angmar_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_pillar");
        BlockReg.pillar2(Material.STONE, Lotr.LOTR_BLOCKS, true, "dorwinion_pillar");
        /*
        Beam - complete
         */
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "oak_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "spruce_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "birch_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "jungle_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "acacia_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "dark_oak_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_beam");
        BlockReg.beam(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_beam");
        /*
        Brick - complete
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
        BlockReg.dolAmroth(Material.STONE, Lotr.LOTR_BLOCKS, true, "dol_amroth_brick");
        BlockReg.dolAmroth(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dol_amroth_brick");
        BlockReg.dolAmroth(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dol_amroth_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_numenorean_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_umbar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_umbar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "angmar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "snowy_angmar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "carved_angmar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_angmar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_angmar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "umbar_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dorwinion_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_dorwinion_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_dorwinion_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_dorwinion_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mossy_red_dorwinion_brick");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cracked_red_dorwinion_brick");
        /*
        Glass - complete
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
        Glass Pane - complete
         */
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "magenta_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_blue_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "lime_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "gray_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "light_gray_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "cyan_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "brown_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_fine_glass_pane");
        BlockReg.bars(Material.STONE, Lotr.LOTR_BLOCKS, true, "black_fine_glass_pane");
        /*
        Dripstone - fix placement, collisions boxes (get from official)
         */
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "obsidian_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "ice_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "andesite_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "diorite_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "granite_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "sandstone_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_sandstone_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk_dripstone");
        BlockReg.dripstone(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_sandstone_dripstone");
        /*
        Tiling - complete
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
        Forges and Ovens - need functionality
         */
        Registry.register(Registry.BLOCK, new Identifier("lotr", "alloy_forge"), ALLOY_FORGE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "alloy_forge"), new BlockItem(ALLOY_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "dwarven_forge"), DWARVEN_FORGE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "dwarven_forge"), new BlockItem(DWARVEN_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "elven_forge"), ELVEN_FORGE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "elven_forge"), new BlockItem(ELVEN_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "orc_forge"), ORC_FORGE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "orc_forge"), new BlockItem(ORC_FORGE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "hobbit_oven"), HOBBIT_OVEN);
        Registry.register(Registry.ITEM, new Identifier("lotr", "hobbit_oven"), new BlockItem(HOBBIT_OVEN, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        /*
        Rock - complete
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gondor_rock");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "mordor_rock"), MORDOR_ROCK);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mordor_rock"), new BlockItem(MORDOR_ROCK, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rohan_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_blue_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_red_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_mordor_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_gondor_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_rohan_rock");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "chalk");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "polished_chalk");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "dirty_chalk"), DIRTY_CHALK);
        Registry.register(Registry.ITEM, new Identifier("lotr", "dirty_chalk"), new BlockItem(DIRTY_CHALK, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_sandstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "cut_white_sandstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "chiseled_white_sandstone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "smooth_white_sandstone");
        /*
        Precious Block - complete
         */
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "copper_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "tin_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "bronze_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "salt_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "sulfur_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "niter_block");
        Registry.register(Registry.ITEM, new Identifier("lotr", "orc_steel_block"), new BlockItem(ORC_STEEL_BLOCK, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "orc_steel_block"), ORC_STEEL_BLOCK);
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "durnor_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarven_steel_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "elven_steel_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "edhelvir_block");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_block");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "uruk_steel_block"), URUK_STEEL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("lotr", "uruk_steel_block"), new BlockItem(URUK_STEEL_BLOCK, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.pile(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_treasure_pile");
        BlockReg.pile(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_treasure_pile");
        BlockReg.pile(Material.STONE, Lotr.LOTR_BLOCKS, true, "copper_treasure_pile");
        /*
        Wood - Stripped and non-stripped - complete
         */
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pine_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mallorn_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mirk_oak_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_charred_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_apple_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pear_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cherry_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lebethron_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_beech_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_maple_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_aspen_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lairelosse_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cedar_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_fir_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_larch_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_holly_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_green_oak_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_wood");
        BlockReg.wood(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cypress_wood");

        /*
        Log - Stripped and non-stripped - complete
         */
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pine_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mallorn_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_mirk_oak_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_charred_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_apple_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_pear_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cherry_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lebethron_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_beech_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_maple_log");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "aspen_log"), ASPEN_LOG);
        Registry.register(Registry.ITEM, new Identifier("lotr", "aspen_log"), new BlockItem(ASPEN_LOG, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_aspen_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_lairelosse_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cedar_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_fir_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_larch_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_holly_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_green_oak_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_log");
        BlockReg.log(Material.STONE, Lotr.LOTR_BLOCKS, true, "stripped_cypress_log");
        /*
        Light Source - torches can't be placed on wall
        */
        BlockReg.chandelier(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_chandelier");
        BlockReg.chandelier(Material.STONE, Lotr.LOTR_BLOCKS, true, "iron_chandelier");
        BlockReg.chandelier(Material.STONE, Lotr.LOTR_BLOCKS, true, "bronze_chandelier");
        BlockReg.chandelier(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_chandelier");
        BlockReg.chandelier(Material.STONE, Lotr.LOTR_BLOCKS, true, "mithril_chandelier");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "bronze_lantern"), BRONZE_LANTERN);
        Registry.register(Registry.ITEM, new Identifier("lotr", "bronze_lantern"), new BlockItem(BRONZE_LANTERN, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "orc_torch"), ORC_TORCH);
        Registry.register(Registry.ITEM, new Identifier("lotr", "orc_torch"), new BlockItem(ORC_TORCH, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "candle"), CANDLE);
        Registry.register(Registry.ITEM, new Identifier("lotr", "candle"), new BlockItem(CANDLE, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.torch(Material.STONE, Lotr.LOTR_BLOCKS, true, "blue_mallorn");
        BlockReg.torch(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_mallorn");
        BlockReg.torch(Material.STONE, Lotr.LOTR_BLOCKS, true, "gold_mallorn");
        BlockReg.torch(Material.STONE, Lotr.LOTR_BLOCKS, true, "silver_mallorn");
        BlockReg.torch(Material.STONE, Lotr.LOTR_BLOCKS, true, "high_elven");
        /*
        Fence Gate - complete
         */
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_fence_gate");
        BlockReg.fenceGate(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_fence_gate");
        /*
        Fence - complete
         */
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "charred_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "aspen_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_fence");
        BlockReg.fence(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_fence");
        /*
        Bars - complete
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
        Sapling - Potted / not Potted - saplings fail to grow
         */
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "pine_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "mallorn_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "mirk_oak_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "pear_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "lebethron_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "beech_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "maple_sapling");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "aspen_sapling"), ASPEN_SAPLING);
        Registry.register(Registry.ITEM, new Identifier("lotr", "aspen_sapling"), new BlockItem(ASPEN_SAPLING, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "lairelosse_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "cedar_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "fir_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "larch_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "holly_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "green_oak_sapling");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_oak_sapling");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_aspen_sapling"), POTTED_ASPEN);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "cypress_sapling");
        /*
        Food - keg needs work to hold alcohol/mugs, as do plates to hold food
         */
        BlockReg.food(Material.STONE, Lotr.LOTR_BLOCKS, true, "cherry_pie");
        BlockReg.food(Material.STONE, Lotr.LOTR_BLOCKS, true, "apple_crumble");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "keg"), KEG);
        Registry.register(Registry.ITEM, new Identifier("lotr", "keg"), new BlockItem(KEG, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        /*
        Plant - fix models
         */
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "simbelmyne");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "shire_heather");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "elanor");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "niphredil");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "bluebell"), BLUEBELL);
        Registry.register(Registry.ITEM, new Identifier("lotr", "bluebell"), new BlockItem(BLUEBELL, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_bluebell"), POTTED_BLUEBELL);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "marigold"), MARIGOLD);
        Registry.register(Registry.ITEM, new Identifier("lotr", "marigold"), new BlockItem(MARIGOLD, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_marigold"), POTTED_MARIGOLD);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "asphodel");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "lavender"), LAVENDER);
        Registry.register(Registry.ITEM, new Identifier("lotr", "lavender"), new BlockItem(LAVENDER, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_lavender"), POTTED_LAVENDER);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "clover"), CLOVER);
        Registry.register(Registry.ITEM, new Identifier("lotr", "clover"), new BlockItem(CLOVER, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_clover"), CLOVER_POTTED);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "four_leaf_clover"), FOUR_CLOVER);
        Registry.register(Registry.ITEM, new Identifier("lotr", "four_leaf_clover"), new BlockItem(FOUR_CLOVER, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_four_leaf_clover"), FOUR_CLOVER_POTTED);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_thorn");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "short_grass", true);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "wheatgrass", true);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "flowery_grass", true);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "thistle"), THISTLES);
        Registry.register(Registry.ITEM, new Identifier("lotr", "thistle"), new BlockItem(THISTLES, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_thistle"), POTTED_THISTLES);
        Registry.register(Registry.BLOCK, new Identifier("lotr", "nettles"), NETTLES);
        Registry.register(Registry.ITEM, new Identifier("lotr", "nettles"), new BlockItem(NETTLES, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "potted_nettles"), POTTED_NETTLES);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "fernsprout");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "athelas");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "dwarfwort");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "pink_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "orange_chrysanthemum");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_sand_gem");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "yellow_sand_gem");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "harad_daisy");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "southbell");
        BlockReg.flowerTall(Material.STONE, Lotr.LOTR_BLOCKS, true, "hibiscus", true);
        BlockReg.flowerTall(Material.STONE, Lotr.LOTR_BLOCKS, true, "flame_of_harad", true);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "wild_pipeweed");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "wild_flax");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "purple_moor_grass", true);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "red_moor_grass", true);
        BlockReg.flowerTall(Material.STONE, Lotr.LOTR_BLOCKS, true, "tall_wheatgrass", true);
        BlockReg.flowerTall(Material.STONE, Lotr.LOTR_BLOCKS, true, "tall_arid_grass", true);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "arid_grass", true);
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, false, "morgul_shroom");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, false, "mirk_shroom");
        /*
        hearth functionality(not light ground in front on fire), ladder functionality, moss model, grass model, hanging web placement/updating functionality
         */
        BlockReg.gravity(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_gravel");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "hearth_block"), HEARTH);
        Registry.register(Registry.ITEM, new Identifier("lotr", "hearth_block"), new BlockItem(HEARTH, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("lotr", "mallorn_ladder"), MALLORN_LADDER);
        Registry.register(Registry.ITEM, new Identifier("lotr", "mallorn_ladder"), new BlockItem(MALLORN_LADDER, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_dirt");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_moss");
        BlockReg.flower(Material.STONE, Lotr.LOTR_BLOCKS, true, "mordor_grass", true);
        BlockReg.directional(Material.STONE, Lotr.LOTR_BLOCKS, true, "edhelvir_crystal");
        BlockReg.directional(Material.STONE, Lotr.LOTR_BLOCKS, true, "gulduril_crystal");
        BlockReg.directional(Material.STONE, Lotr.LOTR_BLOCKS, true, "glowstone_crystal");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "thatch");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "drystone");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "wattle_and_daub");
        Registry.register(Registry.BLOCK, new Identifier("lotr", "hanging_web"), HANGING_WEB);
        Registry.register(Registry.ITEM, new Identifier("lotr", "hanging_web"), new BlockItem(HANGING_WEB, new Item.Settings().group(Lotr.LOTR_BLOCKS)));
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "orc_plating");
        BlockReg.block(Material.STONE, Lotr.LOTR_BLOCKS, true, "rusted_orc_plating");
        BlockReg.gravity(Material.STONE, Lotr.LOTR_BLOCKS, true, "white_sand");


        /*
        Sign BlockEntityType additions
         */
        //SIGN2 = BlockEntityTypeCreateInvoker.invokeCreate("sign2", BlockEntityType.Builder.create(SignBlockEntity::new, ModBlocks.PINE_SIGN, ModBlocks.PINE_WALL_SIGN));
    }
    /*
    TODO:
        -fix hearth
        -fix ladder
        -fix mordor moss
        -fix mordor grass
        -fix hanging web
        -fix plants
        -fix kegs, plates
        -fix saplings
        -fix wall torches
        -add functionality to forges/ovens
        -fix Dripstone
        -fix pillar updating
        -add individual recipes to faction crafting tables
        -fix wall models
        -fix slab vertical models
        -fix signs
     */
}
