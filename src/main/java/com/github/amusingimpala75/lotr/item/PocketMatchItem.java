package com.github.amusingimpala75.lotr.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class PocketMatchItem extends Item {
    public PocketMatchItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
            World world = context.getWorld();
            ItemStack itemstack = context.getStack();

            ItemStack proxyItem = new ItemStack((ItemConvertible) Items.FLINT_AND_STEEL);

            ItemUsageContext proxyContext = new ProxyItemUse(world, context.getPlayer(), context.getHand(), proxyItem, new BlockHitResult(context.getHitPos(), context.getPlayerFacing(), context.getBlockPos(), context.hitsInsideBlock()));
            if (proxyItem.useOnBlock(proxyContext) == ActionResult.SUCCESS) {
                itemstack.decrement(1);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        }
    private static class ProxyItemUse extends ItemUsageContext {
            protected ProxyItemUse(World world, PlayerEntity player, Hand hand, ItemStack heldItem, BlockHitResult hit) {
                super(world, player, hand, heldItem, hit);
            }
        }
}
