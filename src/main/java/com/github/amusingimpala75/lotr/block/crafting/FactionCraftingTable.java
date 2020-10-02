package com.github.amusingimpala75.lotr.block.crafting;

import com.github.amusingimpala75.lotr.faction.Faction;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class FactionCraftingTable extends CraftingTableBlock {

    private final Faction faction;
    private final Text TITLE;
    private final Block table;
    public FactionCraftingTable(AbstractBlock.Settings settings, Faction faction, String text) {
        super(settings);
        this.faction = faction;
        this.TITLE = new TranslatableText(text);
        this.table = this;


    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (true) {
            if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
                player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
                return ActionResult.CONSUME;
            }
        }
        else {
            return ActionResult.FAIL;
        }
    }

    public Faction getFaction() {
        return this.faction;
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        System.out.println("Creating Screen handler for Faction CT");
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
            return new FactionCraftingScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos), this.table);
        }, TITLE);
    }
}
