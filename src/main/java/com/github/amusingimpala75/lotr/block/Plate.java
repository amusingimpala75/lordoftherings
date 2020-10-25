package com.github.amusingimpala75.lotr.block;

import com.github.amusingimpala75.lotr.entity.PlateBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Plate extends Block implements BlockEntityProvider {

    public Plate(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new PlateBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof PlateBlockEntity) {
            ((PlateBlockEntity) world.getBlockEntity(pos)).onUse(state, world, pos, player, hand, hit);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
