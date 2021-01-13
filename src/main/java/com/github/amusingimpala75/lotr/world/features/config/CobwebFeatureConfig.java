package com.github.amusingimpala75.lotr.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class CobwebFeatureConfig implements FeatureConfig {
    public static Codec<CobwebFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("tries").forGetter(source -> source.tries),
            Codec.INT.fieldOf("xspread").forGetter(source -> source.xspread),
            Codec.INT.fieldOf("yspread").forGetter(source -> source.yspread),
            Codec.INT.fieldOf("zspread").forGetter(source -> source.zspread),
            BlockStateProvider.TYPE_CODEC.fieldOf("blockProvider").forGetter(source -> source.blockProvider))
            .apply(instance, instance.stable(CobwebFeatureConfig::new)));
    public final int tries;
    public final int xspread;
    public final int yspread;
    public final int zspread;
    public final BlockStateProvider blockProvider;

    public CobwebFeatureConfig(int t, int x, int y, int z, BlockStateProvider blp) {
        this.tries = t;
        this.xspread = x;
        this.yspread = y;
        this.zspread = z;
        this.blockProvider = blp;
    }

    /*public <T> Dynamic<T> func_214634_a(DynamicOps<T> ops) {
        return new Dynamic(ops, ops.createMap(ImmutableMap.of(ops.createString("block_provider"), this.blockProvider.func_218175_a(ops), ops.createString("tries"), ops.createInt(this.tries), ops.createString("xspread"), ops.createInt(this.xspread), ops.createString("yspread"), ops.createInt(this.yspread), ops.createString("zspread"), ops.createInt(this.zspread))));
    }

    public static <T> CobwebFeatureConfig deserialize(Dynamic<T> dyn) {
        BlockStateProvider blockProv = LOTRFeatures.deserializeBlockProvider(dyn, "block_provider");
        int tries = dyn.get("tries").asInt(0);
        int xspread = dyn.get("xspread").asInt(0);
        int yspread = dyn.get("yspread").asInt(0);
        int zspread = dyn.get("zspread").asInt(0);
        return new CobwebFeatureConfig(tries, xspread, yspread, zspread, blockProv);
    }*/
}
