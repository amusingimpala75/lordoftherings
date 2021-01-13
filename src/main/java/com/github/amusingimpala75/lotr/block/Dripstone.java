package com.github.amusingimpala75.lotr.block;

import com.github.amusingimpala75.lotr.entity.ModDamageSources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Dripstone extends Block implements Waterloggable {
    public boolean isWaterloggable;
    public static Map<Block, Dripstone> BLOCK_TO_DRIPSTONE = new HashMap();
    public static final EnumProperty<DripstoneTypes> TYPE = EnumProperty.of("type", DripstoneTypes.class);
    public static final BooleanProperty WATERLOGGED = BooleanProperty.of("waterlogged");
    public static final VoxelShape[] shape = {
          //Stalagmite

          //Stalactite

          //Stalag with double pt

          //Stalac with double pt

          //Stalag with double base

          //Stalac with double base

    };

    public Dripstone(Settings settings, Block block) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(TYPE, DripstoneTypes.G).with(WATERLOGGED, false));
        BLOCK_TO_DRIPSTONE.put(block, this);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(TYPE, DripstoneTypes.G).with(WATERLOGGED, false);
    }

    //@Override
    //public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    //    return super.getOutlineShape(state, world, pos, context);
    //}


    @Override
    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        entity.damage(ModDamageSources.STALAGMITE, (distance*2.0F)+1.0F);
    }
}
