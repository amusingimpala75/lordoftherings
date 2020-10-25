package com.github.amusingimpala75.lotr.block;

import com.github.amusingimpala75.lotr.entity.ModDamageSources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Dripstone extends Block {
    public static final VoxelShape[] shape = {
          //Stalagmite

          //Stalactite

          //Stalag with double pt

          //Stalac with double pt

          //Stalag with double base

          //Stalac with double base

    };

    public Dripstone(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(TYPE, DripstoneTypes.G));
    }

    public static final EnumProperty<DripstoneTypes> TYPE = EnumProperty.of("type", DripstoneTypes.class);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(TYPE, DripstoneTypes.G);
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
