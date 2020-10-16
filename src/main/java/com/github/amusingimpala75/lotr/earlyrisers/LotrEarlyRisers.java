package com.github.amusingimpala75.lotr.earlyrisers;

import com.github.amusingimpala75.lotr.registry.ModBlocks;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import com.chocohead.mm.api.ClassTinkerers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LotrEarlyRisers implements Runnable{
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void run() {
        LOGGER.info("Lord of the Fabric Early Risers activated");

        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

        String boat = remapper.mapClassName("intermediary", "net.minecraft.class_1690$class_1692");
        String block = 'L' + remapper.mapClassName("intermediary", "net.minecraft.class_2248") + ';';
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("PINE", () -> new Object[] {ModBlocks.PINE_PLANKS, "pine"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("MALLORN", () -> new Object[] {ModBlocks.MALLORN_PLANKS, "mallorn"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("MIRK_OAK", () -> new Object[] {ModBlocks.MIRK_OAK_PLANKS, "mirk"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("CHARRED", () -> new Object[] {ModBlocks.CHARRED_PLANKS, "charred"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("APPLE", () -> new Object[] {ModBlocks.APPLE_PLANKS, "apple"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("PEAR", () -> new Object[] {ModBlocks.PEAR_PLANKS, "pear"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("CHERRY", () -> new Object[] {ModBlocks.CHERRY_PLANKS, "cherry"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("LEBETHRON", () -> new Object[] {ModBlocks.LEBETHRON_PLANKS, "lebethron"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("BEECH", () -> new Object[] {ModBlocks.BEECH_PLANKS, "beech"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("MAPLE", () -> new Object[] {ModBlocks.MAPLE_PLANKS, "maple"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("ASPEN", () -> new Object[] {ModBlocks.ASPEN_PLANKS, "aspen"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("LAIRELOSSE", () -> new Object[] {ModBlocks.LAIRELOSSE_PLANKS, "lairelosse"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("CEDAR", () -> new Object[] {ModBlocks.CEDAR_PLANKS, "cedar"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("FIR", () -> new Object[] {ModBlocks.FIR_PLANKS, "fir"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("LARCH", () -> new Object[] {ModBlocks.LARCH_PLANKS, "larch"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("HOLLY", () -> new Object[] {ModBlocks.HOLLY_PLANKS, "holly"}).build();
        ClassTinkerers.enumBuilder(boat, block, "Ljava/lang/String;").addEnum("GREEN_OAK", () -> new Object[] {ModBlocks.GREEN_OAK_PLANKS, "green_oak"}).build();
    }
}
