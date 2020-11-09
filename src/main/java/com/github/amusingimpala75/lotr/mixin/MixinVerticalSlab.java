package com.github.amusingimpala75.lotr.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*
Add placing functionality for verticality of slabs
 */
@Mixin(SlabBlock.class)
public abstract class MixinVerticalSlab extends Block implements Waterloggable {
    @Shadow
    @Final
    protected static VoxelShape BOTTOM_SHAPE;

    @Shadow
    @Final
    protected static VoxelShape TOP_SHAPE;

    @Shadow
    @Final
    public static EnumProperty<SlabType> TYPE;

    @Shadow
    @Final
    public static BooleanProperty WATERLOGGED;

    @Unique
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    @Unique
    private static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    @Unique
    private static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    @Unique
    private static final VoxelShape WEST_SHAPE = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public MixinVerticalSlab(Settings settings) {
        super(settings);
    }

    //Determine whether shape is N/S/E/W/D
    @Inject(method = "getOutlineShape", at = @At("HEAD"), cancellable = true)
    public void getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> info) {
        SlabType type = (SlabType) state.get(TYPE);
        if (type == SlabType.DOUBLE || type == ClassTinkerers.getEnum(SlabType.class, "XDOUBLE") || type == ClassTinkerers.getEnum(SlabType.class, "ZDOUBLE")) {
            info.setReturnValue(VoxelShapes.fullCube());
        } else if (type == SlabType.TOP) {
            info.setReturnValue(TOP_SHAPE);
        } else if (type == ClassTinkerers.getEnum(SlabType.class, "NORTH")) {
            info.setReturnValue(NORTH_SHAPE);
        } else if (type == ClassTinkerers.getEnum(SlabType.class, "SOUTH")) {
            info.setReturnValue(SOUTH_SHAPE);
        } else if (type == ClassTinkerers.getEnum(SlabType.class, "EAST")) {
            info.setReturnValue(EAST_SHAPE);
        } else if (type == ClassTinkerers.getEnum(SlabType.class, "WEST")) {
            info.setReturnValue(WEST_SHAPE);
        } else {
            info.setReturnValue(BOTTOM_SHAPE);
        }
    }

    //Placement with verticality added
    //TODO: Add double sideways slabs
    @Inject(method = "getPlacementState", at = @At("HEAD"), cancellable = true)
    public void getPlacementState(ItemPlacementContext ctx, CallbackInfoReturnable<BlockState> info) {
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = ctx.getWorld().getBlockState(blockPos);
        if (blockState.isOf(this)) {
            info.setReturnValue((BlockState)((BlockState)blockState.with(TYPE, SlabType.DOUBLE)).with(WATERLOGGED, false));
        } else {
            FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
            BlockState blockState2 = (BlockState)((BlockState)this.getDefaultState().with(TYPE, SlabType.BOTTOM)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
            Direction direction = ctx.getSide();
            if (ctx.getPlayer().isSneaking()) {
                switch (ctx.getPlayer().getHorizontalFacing()) {
                    case NORTH:
                        info.setReturnValue(blockState2.with(TYPE, ClassTinkerers.getEnum(SlabType.class, "NORTH")));
                        break;
                    case SOUTH:
                        info.setReturnValue(blockState2.with(TYPE, ClassTinkerers.getEnum(SlabType.class, "SOUTH")));
                        break;
                    case EAST:
                        info.setReturnValue(blockState2.with(TYPE, ClassTinkerers.getEnum(SlabType.class, "WEST")));
                        break;
                    case WEST:
                        info.setReturnValue(blockState2.with(TYPE, ClassTinkerers.getEnum(SlabType.class, "EAST")));
                        break;
                }
            } else {
                info.setReturnValue(direction != Direction.DOWN && (direction == Direction.UP || ctx.getHitPos().y - (double) blockPos.getY() <= 0.5D) ? blockState2 : (BlockState) blockState2.with(TYPE, SlabType.TOP));
            }
        }

    }

    @Inject(method = "canReplace", at = @At("HEAD"), cancellable = true)
    public void canReplace(BlockState state, ItemPlacementContext context, CallbackInfoReturnable<Boolean> info) {
        ItemStack itemStack = context.getStack();
        SlabType slabType = (SlabType)state.get(TYPE);
        if (slabType != SlabType.DOUBLE && itemStack.getItem() == this.asItem()) {
            if (context.canReplaceExisting()) {
                boolean bl = context.getHitPos().y - (double)context.getBlockPos().getY() > 0.5D;
                Direction direction = context.getSide();
                if (slabType == SlabType.BOTTOM) {
                    info.setReturnValue(direction == Direction.UP || bl && direction.getAxis().isHorizontal());
                } else if (slabType == SlabType.TOP){
                    info.setReturnValue(direction == Direction.DOWN || !bl && direction.getAxis().isHorizontal());
                } else if (slabType == ClassTinkerers.getEnum(SlabType.class, "NORTH")) {
                    info.setReturnValue(direction == Direction.SOUTH || !bl && direction.getAxis().isVertical());
                } else if (slabType == ClassTinkerers.getEnum(SlabType.class, "SOUTH")) {
                    info.setReturnValue(direction == Direction.NORTH || !bl && direction.getAxis().isVertical());
                } else if (slabType == ClassTinkerers.getEnum(SlabType.class, "EAST")) {
                    info.setReturnValue(direction == Direction.WEST || !bl && direction.getAxis().isVertical());
                } else {
                    info.setReturnValue(direction == Direction.EAST || !bl && direction.getAxis().isVertical());
                }
            } else {
                info.setReturnValue(true);
            }
        } else {
            info.setReturnValue(false);
        }
    }
}
