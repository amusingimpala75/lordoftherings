package com.github.amusingimpala75.lotr.block;

import com.github.amusingimpala75.lotr.Lotr;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class ForgeScreenHandler extends ScreenHandler {
    Inventory inv;
    PropertyDelegate delegate;
    public ForgeScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }
    public ForgeScreenHandler(int syncId, PlayerInventory inv) {
        this(syncId, inv, new SimpleInventory(13), new ArrayPropertyDelegate(2));
    }
    public ForgeScreenHandler(int syncId, PlayerInventory playerInv, Inventory inv, PropertyDelegate propDel) {
        super(Lotr.FORGE_SCREEN_HANDLER, syncId);
        checkSize(inv, 13);
        this.inv = inv;
        inv.onOpen(playerInv.player);
        this.delegate = propDel;
        this.addProperties(propDel);
    }
    public int getBurnTime() {
        return this.delegate.get(0);
    }
    public int getCookTime() {
        return this.delegate.get(1);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
