package com.github.amusingimpala75.lotr.block;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallShape;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.Iterator;
import java.util.Map;

import static com.github.amusingimpala75.lotr.mixin.WallBlockInvokers.*;
import static net.minecraft.block.WallBlock.*;
import static net.minecraft.block.WallBlock.UP;
import static net.minecraft.block.WallBlock.WATERLOGGED;
import static net.minecraft.state.property.Properties.*;
import static com.github.amusingimpala75.lotr.mixin.WallBlockAccessors.*;

public class ModWallBlock extends Block implements Waterloggable {

    private final Map<BlockState, VoxelShape> shapeMap;
    private final Map<BlockState, VoxelShape> collisionShapeMap;

    public ModWallBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState())).with(NORTH_SHAPE, WallShape.NONE)).with(EAST_SHAPE, WallShape.NONE)).with(SOUTH_SHAPE, WallShape.NONE)).with(WEST_SHAPE, WallShape.NONE)).with(WATERLOGGED, false));
        this.shapeMap = getShapeMap(4.0F, 3.0F, 16.0F, 0.0F, 14.0F, 16.0F);
        this.collisionShapeMap = this.getShapeMap(4.0F, 3.0F, 24.0F, 0.0F, 24.0F, 24.0F);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED});
    }

    private Map<BlockState, VoxelShape> getShapeMap(float f, float g, float h, float i, float j, float k) {
        float l = 8.0F - f;
        float m = 8.0F + f;
        float n = 8.0F - g;
        float o = 8.0F + g;
        VoxelShape voxelShape = Block.createCuboidShape((double)l, 0.0D, (double)l, (double)m, (double)h, (double)m);
        VoxelShape voxelShape2 = Block.createCuboidShape((double)n, (double)i, 0.0D, (double)o, (double)j, (double)o);
        VoxelShape voxelShape3 = Block.createCuboidShape((double)n, (double)i, (double)n, (double)o, (double)j, 16.0D);
        VoxelShape voxelShape4 = Block.createCuboidShape(0.0D, (double)i, (double)n, (double)o, (double)j, (double)o);
        VoxelShape voxelShape5 = Block.createCuboidShape((double)n, (double)i, (double)n, 16.0D, (double)j, (double)o);
        VoxelShape voxelShape6 = Block.createCuboidShape((double)n, (double)i, 0.0D, (double)o, (double)k, (double)o);
        VoxelShape voxelShape7 = Block.createCuboidShape((double)n, (double)i, (double)n, (double)o, (double)k, 16.0D);
        VoxelShape voxelShape8 = Block.createCuboidShape(0.0D, (double)i, (double)n, (double)o, (double)k, (double)o);
        VoxelShape voxelShape9 = Block.createCuboidShape((double)n, (double)i, (double)n, 16.0D, (double)k, (double)o);
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        Iterator var21 = UP.getValues().iterator();

        while(var21.hasNext()) {
            Boolean boolean_ = (Boolean)var21.next();
            Iterator var23 = EAST_SHAPE.getValues().iterator();

            while(var23.hasNext()) {
                WallShape wallShape = (WallShape)var23.next();
                Iterator var25 = NORTH_SHAPE.getValues().iterator();

                while(var25.hasNext()) {
                    WallShape wallShape2 = (WallShape)var25.next();
                    Iterator var27 = WEST_SHAPE.getValues().iterator();

                    while(var27.hasNext()) {
                        WallShape wallShape3 = (WallShape)var27.next();
                        Iterator var29 = SOUTH_SHAPE.getValues().iterator();

                        while(var29.hasNext()) {
                            WallShape wallShape4 = (WallShape)var29.next();
                            VoxelShape voxelShape10 = VoxelShapes.empty();
                            voxelShape10 = invokeMethod_24426(voxelShape10, wallShape, voxelShape5, voxelShape9);
                            voxelShape10 = invokeMethod_24426(voxelShape10, wallShape3, voxelShape4, voxelShape8);
                            voxelShape10 = invokeMethod_24426(voxelShape10, wallShape2, voxelShape2, voxelShape6);
                            voxelShape10 = invokeMethod_24426(voxelShape10, wallShape4, voxelShape3, voxelShape7);
                            if (boolean_) {
                                voxelShape10 = VoxelShapes.union(voxelShape10, voxelShape);
                            }

                            BlockState blockState = (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.getDefaultState().with(UP, boolean_)).with(EAST_SHAPE, wallShape)).with(WEST_SHAPE, wallShape3)).with(NORTH_SHAPE, wallShape2)).with(SOUTH_SHAPE, wallShape4);
                            builder.put(blockState.with(WATERLOGGED, false), voxelShape10);
                            builder.put(blockState.with(WATERLOGGED, true), voxelShape10);
                        }
                    }
                }
            }
        }

        return builder.build();
    }

    private boolean method_27092(BlockState blockState, BlockState blockState2, VoxelShape voxelShape) {
        boolean bl = blockState2.getBlock() instanceof WallBlock;
        if (bl) {
            return true;
        } else {
            WallShape wallShape = (WallShape)blockState.get(NORTH_SHAPE);
            WallShape wallShape2 = (WallShape)blockState.get(SOUTH_SHAPE);
            WallShape wallShape3 = (WallShape)blockState.get(EAST_SHAPE);
            WallShape wallShape4 = (WallShape)blockState.get(WEST_SHAPE);
            boolean bl2 = wallShape2 == WallShape.NONE;
            boolean bl3 = wallShape4 == WallShape.NONE;
            boolean bl4 = wallShape3 == WallShape.NONE;
            boolean bl5 = wallShape == WallShape.NONE;
            boolean bl6 = bl5 && bl2 && bl3 && bl4 || bl5 != bl2 || bl3 != bl4;
            if (bl6) {
                return true;
            } else {
                boolean bl7 = wallShape == ClassTinkerers.getEnum(WallShape.class, "TRUE") && wallShape2 == ClassTinkerers.getEnum(WallShape.class, "TRUE") || wallShape3 == ClassTinkerers.getEnum(WallShape.class, "TRUE") && wallShape4 == ClassTinkerers.getEnum(WallShape.class, "TRUE");
                if (bl7) {
                    return false;
                } else {
                    return blockState2.getBlock().isIn(BlockTags.WALL_POST_OVERRIDE) || invokeMethod_24427(voxelShape, getTALL_POST_SHAPE());
                }
            }
        }
    }

    private WallShape method_24428(boolean bl, VoxelShape voxelShape, VoxelShape voxelShape2) {
        if (bl) {
            return ClassTinkerers.getEnum(WallShape.class, "TRUE");
        } else {
            return WallShape.NONE;
        }
    }
}
