package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.world.MESurfaceBuilder;
import com.github.amusingimpala75.lotr.world.MESurfaceConfig;
import com.swordglowsblue.artifice.api.Artifice;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.*;

import static com.github.amusingimpala75.lotr.Lotr.*;

/*
Altitude - actual; low (-1.0F) -> high (1.0F)
Humidity - "modified"; not (0.0F) -> yes (1.0F)
offset - always 0.0F;
temperature - "sea-ness"; ocean (-1.0F) -> beach (-0.3F) -> land (-0.2F)
weirdness - "goodness"; bad (-1.0F) -> good (1.0F)
 */
public class ModDimensions {
    public static final SurfaceBuilder<MESurfaceConfig> ME_SURFACE_CONFIG = new MESurfaceBuilder(MESurfaceBuilder.CODEC);
    public static final RegistryKey<World> MIDDLE_EARTH = RegistryKey.of(Registry.DIMENSION, id("middle_earth"));
    //public static final ChunkGenerator ME_CHUNK_GEN = new MEChunkGenerator();     //TODO: Fix MEChunkGenerator

    public static void registerDimensions() {
        Artifice.registerDataPack(id("dimensions"), (pack) -> {
            pack.setDisplayName("Lotr Dimensions");
            pack.setDescription("Dimensions added by the Lord of the Rings Mod");
            //Dimension Type need to be added as file to prevent server issues, so not included here
            pack.addDimension(id("middle_earth_classic"), dimensionBuilder -> dimensionBuilder
                    .dimensionType(id("middle_earth_classic"))
                    .noiseGenerator(noiseChunkGeneratorTypeBuilder -> {
                        noiseChunkGeneratorTypeBuilder.multiNoiseBiomeSource(multiNoiseBiomeSourceBuilder -> {
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:shire");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.0F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.8F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:mordor");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.2F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.8F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:rohan");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.0F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.7F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:misty_mountains");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.8F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.1F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:misty_mountains_foothills");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.5F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.1F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:shire_woodlands");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.0F);
                                            biomeParametersBuilder.humidity(1.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.8F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:river");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(-0.3F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.0F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:trollshaws");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.2F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.5F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:blue_mountains");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.7F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.6F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:blue_mountains_foothills");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.5F);
                                            biomeParametersBuilder.humidity(1.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.6F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:eriador");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.15F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.2F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:lone_lands");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.1F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.2F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:ithilien");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.3F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.05F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:brown_lands");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.15F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.25F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:lothlorien");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.4F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.8F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:iron_hills");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.6F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.6F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:dunland");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.2F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.3F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:emyn_muil");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.0F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(-0.15F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder
                                    .addBiome(biomeBuilder -> {
                                        biomeBuilder.biome("lotr:lindon");
                                        biomeBuilder.parameters(biomeParametersBuilder -> {
                                            biomeParametersBuilder.altitude(0.1F);
                                            biomeParametersBuilder.humidity(0.0F);
                                            biomeParametersBuilder.offset(0.0F);
                                            biomeParametersBuilder.temperature(-0.2F);
                                            biomeParametersBuilder.weirdness(0.75F);
                                        });
                                    });
                            multiNoiseBiomeSourceBuilder.altitudeNoise(noiseSettings -> {
                                noiseSettings.amplitudes(1.0F, 1.0F);
                                noiseSettings.firstOctave(-7);
                            });
                            multiNoiseBiomeSourceBuilder.humidityNoise(noiseSettings -> {
                                noiseSettings.amplitudes(1.0F, 1.0F);
                                noiseSettings.firstOctave(-7);
                            });
                            multiNoiseBiomeSourceBuilder.temperatureNoise(noiseSettings -> {
                                noiseSettings.amplitudes(1.0F, 1.0F);
                                noiseSettings.firstOctave(-7);
                            });
                            multiNoiseBiomeSourceBuilder.weirdnessNoise(noiseSettings -> {
                                noiseSettings.amplitudes(1.0F, 1.0F);
                                noiseSettings.firstOctave(-7);
                            });
                            multiNoiseBiomeSourceBuilder.seed((int)(new Random().nextLong()));
                        })
                                .type("minecraft:multi_noise");
                        noiseChunkGeneratorTypeBuilder.seed((int)(new Random().nextLong()));
                        noiseChunkGeneratorTypeBuilder.noiseSettings("minecraft:overworld");
                        noiseChunkGeneratorTypeBuilder.type("minecraft:noise");
                    }));
            pack.shouldOverwrite();
        });
        Registry.register(Registry.SURFACE_BUILDER, id("middle_earth_surface_builder"), ME_SURFACE_CONFIG);
        //Registry.register(Registry.CHUNK_GENERATOR, id("middle_earth_chunk_generator"), );
    }
}
