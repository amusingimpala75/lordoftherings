package com.github.amusingimpala75.lotr.block.crafting;

import com.github.amusingimpala75.lotr.faction.Faction;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
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


//General Class for faction Specific crafting tables
public class FactionCraftingTable extends CraftingTableBlock {
    private final Faction faction;
    private final Text TITLE;
    private final FactionCraftingTable table;   //For use in screenhandler
    private final String factionString;

    public FactionCraftingTable(AbstractBlock.Settings settings, Faction faction, String text, String factionString) {
        super(settings);
        this.faction = faction;
        this.TITLE = new TranslatableText(text);
        this.table = this;
        this.factionString = factionString;
    }
    public FactionCraftingTable(FactionCraftingTable table) {
        super(table.settings);
        this.faction = table.getFaction();
        this.TITLE = table.TITLE;
        this.table = this;
        this.factionString = table.factionString;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (true) {     //TODO: Add faction check
            if (world.isClient) {
                return ActionResult.SUCCESS;
            } else {
                player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
                player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
                return ActionResult.CONSUME;
            }
        } else {
            int d = pos.getX();
            int e = pos.getY() + 1;
            int f = pos.getZ();
            world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
        }
        return ActionResult.FAIL;
    }

    public Faction getFaction() {
        return this.faction;
    }
    public String getFactionString() {return this.factionString;}

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) ->
                new FactionCraftingScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos), this.table), TITLE);
    }
}
