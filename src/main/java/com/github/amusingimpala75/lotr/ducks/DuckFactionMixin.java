package com.github.amusingimpala75.lotr.ducks;

import com.github.amusingimpala75.lotr.faction.Faction;

public interface DuckFactionMixin {
    void setFactionAmount(int amount, String faction);
    void setFactionAmount(int[] amount);
    int[] getFactionAmount();
    int getFactionAmount(String faction);
    boolean isFactionGreater(Faction testFaction, int testValue);
}
