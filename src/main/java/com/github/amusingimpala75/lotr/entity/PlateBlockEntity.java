package com.github.amusingimpala75.lotr.entity;

import com.github.amusingimpala75.lotr.registry.ModBlockEntites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlateBlockEntity extends BlockEntity {

    private ItemStack food = ItemStack.EMPTY;

    public PlateBlockEntity() {
        super(ModBlockEntites.PLATE_ENTITY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.put("food", new ItemStack(food.getItem(), food.getCount()).toTag(new CompoundTag()));
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        food = ItemStack.fromTag((CompoundTag) tag.get("food"));
    }

    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        if (player.getMainHandStack().isFood()) {
            boolean success = tryAddFood(player.getMainHandStack(), player);
            if (!success) {
                tryRemoveFood(world, pos);
            }
        } else {
            tryRemoveFood(world, pos);
        }
    }

    public boolean tryAddFood(ItemStack stack, PlayerEntity player) {
        System.out.println("Attempting to add food");
        if (this.food.isEmpty()) {
            System.out.println("Adding food with none to start with");
            food = new ItemStack(stack.getItem(), 1);
            food.setCount(1);
            player.getMainHandStack().decrement(1);
            markDirty();
            return true;
        } else if (this.food.isItemEqual(stack) && this.food.getCount() < 3) {
            System.out.println("Adding to existing food");
            food.increment(1);
            player.getMainHandStack().decrement(1);
            markDirty();
            return true;
        } else {
            System.out.println("Not adding food");
            return false;
        }
    }

    public ItemStack getFood() {
        return food;
    }

    public void tryRemoveFood(World world, BlockPos pos) {
        if (this.food.getCount() > 0 && !this.food.isEmpty()) {
            food.decrement(1);
            ItemEntity dropped = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), this.food);
            dropped.setToDefaultPickupDelay();
            world.spawnEntity(dropped);
            markDirty();
        }
    }
}
