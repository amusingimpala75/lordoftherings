package com.github.amusingimpala75.lotr.block.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FactionCraftingJsonFormat {
    JsonArray input;
    String outputItem;
    int outputCount;
    String faction;


    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getFaction() {
        return faction;
    }


    public void setInputs(JsonArray inputArr) {
        input = inputArr;
    }

    public JsonArray getInputs() {
        return input;
    }

    public void setOutput(String itemId, int count) {
        outputItem = itemId;
        outputCount = count;
    }

    public String getOutputItemId() {
        return outputItem;
    }
    public int getOutputCount() {
        return outputCount;
    }
}
