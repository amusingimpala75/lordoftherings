package com.github.amusingimpala75.lotr.entity;

import com.github.amusingimpala75.lotr.block.ForgeScreenHandler;
import com.github.amusingimpala75.lotr.block.ImplementedInventory;
import com.github.amusingimpala75.lotr.registry.ModBlockEntites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

public class ForgeBlockEntity extends BlockEntity implements Tickable, NamedScreenHandlerFactory, ImplementedInventory {
    private int burnTimeRemaining;
    private int cookTimeProgression;
    private DefaultedList<ItemStack> inventory;     //Input row, alloy row, output row, fuel; left to right
    public ForgeBlockEntity() {
        super(ModBlockEntites.FORGE_ENTITY);
        this.inventory = DefaultedList.ofSize(13, ItemStack.EMPTY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("burnTime", burnTimeRemaining);
        tag.putInt("cookTime", cookTimeProgression);
        Inventories.toTag(tag, inventory);
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.burnTimeRemaining = tag.getInt("burnTime");
        this.cookTimeProgression = tag.getInt("cookTime");
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public void tick() {

    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ForgeScreenHandler(syncId, inv, this, delegate);
    }
    private final PropertyDelegate delegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            switch (index) {
                case 1:
                    return burnTimeRemaining;
                case 2:
                    return cookTimeProgression;
                default:
                    return 0;
            }
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 1:
                    burnTimeRemaining = value;
                    break;
                case 2:
                    cookTimeProgression = value;
            }
        }

        @Override
        public int size() {
            return 4;
        }
    };

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
}
