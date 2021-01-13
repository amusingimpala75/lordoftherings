package com.github.amusingimpala75.lotr.world.features.config;

import com.github.amusingimpala75.lotr.block.Dripstone;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Optional;

//TODO: FIX DUMB OPTIONAL CODEC
public class DripstoneFeatureConfig implements FeatureConfig {
    public static Codec<DripstoneFeatureConfig> CODEC = RecordCodecBuilder.create(dripstoneFeatureConfigInstance -> dripstoneFeatureConfigInstance.group(
        Codec.INT.fieldOf("tries").forGetter(source -> source.tries),
        Codec.INT.fieldOf("xspread").forGetter(source -> source.xspread),
        Codec.INT.fieldOf("yspread").forGetter(source -> source.yspread),
        Codec.INT.fieldOf("zspread").forGetter(source -> source.zspread),
        Codec.FLOAT.fieldOf("doubleChance").forGetter(source -> source.doubleChance),
        BlockState.CODEC.optionalFieldOf("forcedBlockState", Blocks.BEDROCK.getDefaultState()).forGetter(source -> source.forcedBlockState)
    ).apply(dripstoneFeatureConfigInstance, dripstoneFeatureConfigInstance.stable(DripstoneFeatureConfig::new)));
    public final int tries;
    public final int xspread;
    public final int yspread;
    public final int zspread;
    public final float doubleChance;
    public final BlockState forcedBlockState;

    public DripstoneFeatureConfig(int t, int x, int y, int z, float dc) {
        this(t, x, y, z, dc, /*(BlockState)null*/Blocks.BEDROCK.getDefaultState());
    }

    public DripstoneFeatureConfig(int t, int x, int y, int z, float dc, BlockState state) {
        this.tries = t;
        this.xspread = x;
        this.yspread = y;
        this.zspread = z;
        this.doubleChance = dc;
        this.forcedBlockState = state;
    }

    public boolean hasForcedDripstoneState() {
        //return this.forcedBlockState != null && this.forcedBlockState.getBlock() instanceof Dripstone;
        return this.forcedBlockState.equals(Blocks.BEDROCK.getDefaultState()) && this.forcedBlockState.getBlock() instanceof Dripstone;
        //return this.forcedBlockState && this.forcedBlockState.getBlock() instanceof Dripstone;
    }

    /*public <T> Dynamic<T> func_214634_a(DynamicOps<T> ops) {
        Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("tries"), ops.createInt(this.tries)).put(ops.createString("xspread"), ops.createInt(this.xspread)).put(ops.createString("yspread"), ops.createInt(this.yspread)).put(ops.createString("zspread"), ops.createInt(this.zspread)).put(ops.createString("double_chance"), ops.createFloat(this.doubleChance));
        if (this.forcedBlockState != null) {
            builder.put(ops.createString("forced_blockstate"), BlockState.func_215689_a(ops, this.forcedBlockState).getValue());
        }

        return new Dynamic(ops, ops.createMap(builder.build()));
    }

    public static <T> DripstoneFeatureConfig deserialize(Dynamic<T> dyn) {
        int tries = dyn.get("tries").asInt(0);
        int xspread = dyn.get("xspread").asInt(0);
        int yspread = dyn.get("yspread").asInt(0);
        int zspread = dyn.get("zspread").asInt(0);
        float doubleChance = dyn.get("double_chance").asFloat(0.0F);
        BlockState state = BlockState.deserialize(dyn.get("forced_blockstate").orElseEmptyMap());
        DripstoneFeatureConfig config = new DripstoneFeatureConfig(tries, xspread, yspread, zspread, doubleChance, state);
        return config;
    }*/
}
