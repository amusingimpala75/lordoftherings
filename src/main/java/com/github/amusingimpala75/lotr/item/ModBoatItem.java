package com.github.amusingimpala75.lotr.item;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.BoatEntity.Type;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
/*
Wrapper class for boat
TODO: remove old code
 */
/*public class ModBoatItem extends Item {
    private static final Predicate<Entity> RIDERS;
    private final Type type;

    public ModBoatItem(Type type, Settings settings) {
        super(settings);
        this.type = type;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        HitResult hitResult = raycast(world, user, FluidHandling.ANY);
        if (hitResult.getType() == net.minecraft.util.hit.HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        } else {
            Vec3d vec3d = user.getRotationVec(1.0F);
            double d = 5.0D;
            List<Entity> list = world.getOtherEntities(user, user.getBoundingBox().stretch(vec3d.multiply(5.0D)).expand(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vec3d vec3d2 = user.getCameraPosVec(1.0F);
                Iterator var11 = list.iterator();

                while(var11.hasNext()) {
                    Entity entity = (Entity)var11.next();
                    Box box = entity.getBoundingBox().expand((double)entity.getTargetingMargin());
                    if (box.contains(vec3d2)) {
                        return TypedActionResult.pass(itemStack);
                    }
                }
            }

            if (hitResult.getType() == net.minecraft.util.hit.HitResult.Type.BLOCK) {
                BoatEntity boatEntity = new BoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
                boatEntity.setBoatType(this.type);
                boatEntity.yaw = user.yaw;
                if (!world.isSpaceEmpty(boatEntity, boatEntity.getBoundingBox().expand(-0.1D))) {
                    return TypedActionResult.fail(itemStack);
                } else {
                    if (!world.isClient) {
                        world.spawnEntity(boatEntity);
                        if (!user.abilities.creativeMode) {
                            itemStack.decrement(1);
                        }
                    }

                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(itemStack, world.isClient());
                }
            } else {
                return TypedActionResult.pass(itemStack);
            }
        }
    }

    static {
        RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::collides);
    }
}
*/
public class ModBoatItem extends BoatItem {

    public ModBoatItem(Type type, Settings settings) {
        super(type, settings);
    }
}