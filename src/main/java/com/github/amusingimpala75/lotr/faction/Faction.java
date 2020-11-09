package com.github.amusingimpala75.lotr.faction;
/*
General Collection of factions
 */
public enum Faction {
    HOBBIT("hobbit"),
    BREE("bree"),
    RANGER_NORTH("ranger"),
    BLUE_MOUNTAINS("blue_mountains"),
    HIGH_ELF("high_elf"),
    GUNDABAD("gundabad"),
    ANGMAR("angamr"),
    WOOD_ELF("wood_elf"),
    DOL_GULDUR("dol_guldur"),
    DALE("dale"),
    DURINS_FOLK("durins_folk"),
    LOTHLORIEN("lothlorien"),
    DUNLAND("dunland"),
    ISENGARD("isengard"),
    FANGORN("fangorn"),
    ROHAN("rohan"),
    GONDOR("gondor"),
    MORDOR("mordor"),
    DORWINION("dorwinion"),
    RHUDEL("rhun"),
    NEAR_HARAD("harad"),
    MORWAITH("morwaith"),
    TAURETHRIM("taurethrim"),
    HALF_TROLL("half_troll"),
    DARK_HUORN("dark_huorn"),
    UTUMNO("utumno");

    public final String name;
    Faction(String name) {
        this.name = name;
    }
}
