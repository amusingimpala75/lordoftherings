package com.github.amusingimpala75.lotr.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MESurfaceConfig implements SurfaceConfig {
    public BlockState top;
    public BlockState bottom;
    public BlockState underwater;
    private final OctaveSimplexNoiseSampler firstNoise;
    private final OctaveSimplexNoiseSampler secondNoise;
    private final OctaveSimplexNoiseSampler thirdNoise;
    private MESurfaceConfig.SurfaceNoiseMixer surfaceMixer;
    private MESurfaceConfig.UnderwaterNoiseMixer underwaterMixer;
    private MESurfaceConfig.MountainNoiseMixer mountainMixer;
    private boolean marsh = false;
    private boolean rocky = true;
    private boolean podzol = true;
    private List<MESurfaceConfig.SubSoilLayer> subSoilLayers = new ArrayList();
    private double fillerDepth = 5.0D;
    protected static final OctaveSimplexNoiseSampler MARSH_NOISE = new OctaveSimplexNoiseSampler(new ChunkRandom(444L), ImmutableList.of(0, 0));

    public MESurfaceConfig(BlockState top, BlockState bottom, BlockState underwater) {
        this.top = top;
        this.bottom = bottom;
        this.underwater = underwater;
        this.firstNoise = new OctaveSimplexNoiseSampler(new ChunkRandom(1954L), ImmutableList.of(0, 0));
        this.secondNoise = new OctaveSimplexNoiseSampler(new ChunkRandom(10420914965337148L), ImmutableList.of(0, 0));
        this.thirdNoise = new OctaveSimplexNoiseSampler(new ChunkRandom(2274201084179107L), ImmutableList.of(0, 0));
        this.surfaceMixer = SurfaceNoiseMixer.DEFAULT;
        this.underwaterMixer = UnderwaterNoiseMixer.DEFAULT;
        this.mountainMixer = MountainNoiseMixer.DEFAULT;
    }

    public MESurfaceConfig defaultConfig() {
        return new MESurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.GRAVEL.getDefaultState());
    }

    @Override
    public BlockState getTopMaterial() {
        return top;
    }

    public void setTopMaterial(BlockState top) {
        this.top = top;
    }

    @Override
    public BlockState getUnderMaterial() {
        return bottom;
    }

    public void setBottomMaterial(BlockState bottom) {
        this.bottom = bottom;
    }

    public BlockState getUnderwaterMaterial() {
        return underwater;
    }

    public void setUnderwaterMaterial(BlockState underwater) {
        this.underwater = underwater;
    }

    public Iterator<MESurfaceConfig.SubSoilLayer> getSubSoilLayers() {
        return this.subSoilLayers.iterator();
    }

    public void addSubSoilLayer(BlockState state, int depth) {
        this.addSubSoilLayer(state, depth, depth);
    }

    public void addSubSoilLayer(BlockState state, int min, int max) {
        this.subSoilLayers.add(new MESurfaceConfig.SubSoilLayer(state, min, max));
    }

    public boolean isMarsh() {
        return marsh;
    }

    public boolean hasPodzol() {
        return podzol;
    }

    public boolean isRocky() {
        return rocky;
    }

    public void setMarsh(boolean marsh) {
        this.marsh = marsh;
    }

    public void setPodzol(boolean podzol) {
        this.podzol = podzol;
    }

    public void setRocky(boolean rocky) {
        this.rocky = rocky;
    }

    public void setSurfaceMixer(MESurfaceConfig.SurfaceNoiseMixer mixer) {
        this.surfaceMixer = mixer;
    }

    public void setUnderwaterMixer(MESurfaceConfig.UnderwaterNoiseMixer mixer) {
        this.underwaterMixer = mixer;
    }

    public void setMountainMixer(MESurfaceConfig.MountainNoiseMixer mixer) {
        this.mountainMixer = mixer;
    }

    public BlockState getSurfaceReplacement(int i, int k, BlockState l, boolean m, Random n) {
        return this.surfaceMixer.getReplacement(i, k, l, m, n);
    }

    public BlockState getUnderwaterReplacement(int i, int k, BlockState l, Random n) {
        return this.underwaterMixer.getReplacement(i, k, l, n);
    }

    public BlockState getMountainReplacement(int x, int z, int y, BlockState in, BlockState stone, boolean top, int rockDepth) {
        return this.mountainMixer.getReplacement(x, z, y, in, stone, top, rockDepth);
    }

    public boolean hasMountainTerrain() {
        return this.mountainMixer != MESurfaceConfig.MountainNoiseMixer.DEFAULT;
    }

    public double getNoiseFromFirst(int x, int z, int scale) {
        return this.firstNoise.sample((double)x * scale, (double)z * scale, false);
    }

    public double getNoiseFromFirst(int x, int z, double scale1, double scale2) {
        return (this.firstNoise.sample((double)x * scale1, (double)z * scale1, false) + this.firstNoise.sample((double)x * scale2, (double)z * scale2, false)) / 2.0D;
    }

    public double getNoiseFromFirst(int x, int z, double scale1, double scale2, double scale3) {
        return (this.firstNoise.sample((double)x * scale1, (double)z * scale1, false) + this.firstNoise.sample((double)x * scale2, (double)z * scale2, false) + this.firstNoise.sample((double)x * scale3, (double)z * scale3, false)) / 3.0D;
    }
    public double getNoiseFromSecond(int x, int z, int scale) {
        return this.secondNoise.sample((double)x * scale, (double)z * scale, false);
    }

    public double getNoiseFromSecond(int x, int z, double scale1, double scale2) {
        return (this.secondNoise.sample((double)x * scale1, (double)z * scale1, false) + this.secondNoise.sample((double)x * scale2, (double)z * scale2, false)) / 2.0D;
    }

    public double getNoiseFromSecond(int x, int z, double scale1, double scale2, double scale3) {
        return (this.secondNoise.sample((double)x * scale1, (double)z * scale1, false) + this.secondNoise.sample((double)x * scale2, (double)z * scale2, false) + this.secondNoise.sample((double)x * scale3, (double)z * scale3, false)) / 3.0D;
    }

    public double getNoiseFromThird(int x, int z, int scale) {
        return this.thirdNoise.sample((double)x * scale, (double)z * scale, false);
    }

    public double getNoiseFromThird(int x, int z, double scale1, double scale2) {
        return (this.thirdNoise.sample((double)x * scale1, (double)z * scale1, false) + this.thirdNoise.sample((double)x * scale2, (double)z * scale2, false)) / 2.0D;
    }

    public double getNoiseFromThird(int x, int z, double scale1, double scale2, double scale3) {
        return (this.thirdNoise.sample((double)x * scale1, (double)z * scale1, false) + this.thirdNoise.sample((double)x * scale2, (double)z * scale2, false) + this.thirdNoise.sample((double)x * scale3, (double)z * scale3, false)) / 3.0D;
    }

    public double getFillerDepth() {
        return this.fillerDepth;
    }

    public void setFillerDepth(double d) {
        this.fillerDepth = d;
    }

    public interface SurfaceNoiseMixer {
        MESurfaceConfig.SurfaceNoiseMixer DEFAULT = (x, z, in, top, rand) -> in;

        BlockState getReplacement(int var1, int var2, BlockState var3, boolean var4, Random var5);
    }

    public interface UnderwaterNoiseMixer {
        MESurfaceConfig.UnderwaterNoiseMixer DEFAULT = (x, z, in, rand) -> in;

        BlockState getReplacement(int var1, int var2, BlockState var3, Random var4);
    }

    public interface MountainNoiseMixer {
        MESurfaceConfig.MountainNoiseMixer DEFAULT = (x, z, y, in, stone, top, rockDepth) -> stone;

        BlockState getReplacement(int var1, int var2, int var3, BlockState var4, BlockState var5, boolean var6, int var7);
    }
    public static class SubSoilLayer {
        private final BlockState material;
        private final int minDepth;
        private final int maxDepth;

        public SubSoilLayer(BlockState state, int min, int max) {
            this.material = state;
            this.minDepth = min;
            this.maxDepth = max;
        }

        public BlockState getMaterial() {
            return this.material;
        }

        public int getDepth(Random rand) {
            return MathHelper.nextInt(rand, this.minDepth, this.maxDepth);
        }
    }
    /*public static MESurfaceConfig deserialize(Dynamic<?> dyn) {
        BlockState top = (BlockState)dyn.get("top_material").map(BlockState::func_215698_a).orElse(Blocks.AIR.getDefaultState());
        BlockState filler = (BlockState)dyn.get("under_material").map(BlockState::func_215698_a).orElse(Blocks.AIR.getDefaultState());
        BlockState underwater = (BlockState)dyn.get("underwater_material").map(BlockState::func_215698_a).orElse(Blocks.AIR.getDefaultState());
        MESurfaceConfig config = new MESurfaceConfig(top, filler, underwater);
        List<MESurfaceConfig.SubSoilLayer> subSoilLayers = dyn.get("sub_soil_layers").asList((dynElem) -> {
            BlockState material = (BlockState)dynElem.get("sub_soil_material").map(BlockState::func_215698_a).orElse(Blocks.AIR.getDefaultState());
            int minDepth = dynElem.get("sub_soil_depth_min").asInt(0);
            int maxDepth = dynElem.get("sub_soil_depth_max").asInt(0);
            return new MESurfaceConfig.SubSoilLayer(material, minDepth, maxDepth);
        });
        config.rocky = dyn.get("rocky").asBoolean(true);
        config.podzol = dyn.get("podzol").asBoolean(true);
        config.marsh = dyn.get("marsh").asBoolean(false);
        return config;
    }*///TODO: FIX!!
}
