package com.github.amusingimpala75.lotr.client;

public class DataGen {
    public static String createBlockStateForSlabsLotr(String type, String doubleType) {
        return "{\n" +
                    "\"variants\": {" +
                        "\"type=bottom\": { \"model\": \"lotr:block/"+type+"_slab\" }" +
                        "\"type=top\": {\"model\": \"lotr:block/"+type+"_slab_top\" }" +
                        "\"type=double\": { \"model\": \"lotr:block/"+doubleType+"\" }" +
                        "\"type=north\": { \"model\": \"lotr:block/"+type+"_slab\", \"x\": 270, \"uvlock\": true }" +
                        "\"type=south\": { \"model\": \"lotr:block/"+type+"_slab_top\", \"x\": 270, \"uvlock\": true }" +
                        "\"type=east\": { \"model\": \"lotr:block/"+type+"_slab\", \"x\": 90, \"y\": 90, \"uvlock\": true }" +
                        "\"type=west\": { \"model\": \"lotr:block/"+type+"_slab_top\", \"x\": 90, \"y\": 90, \"uvlock\": true }" +
                    "}" +
                "}";
    }
    public static String createBlockStateForSlabsMinecraft(String type, String doubleType) {
        return "{\n" +
                    "\"variants\": {" +
                        "\"type=bottom\": { \"model\": \"minecraft:block/"+type+"_slab\" }" +
                        "\"type=top\": {\"model\": \"minecraft:block/"+type+"_slab_top\" }" +
                        "\"type=double\": { \"model\": \"minecraft:block/"+doubleType+"\" }" +
                        "\"type=north\": { \"model\": \"minecraft:block/"+type+"_slab\", \"x\": 270, \"uvlock\": true }" +
                        "\"type=south\": { \"model\": \"minecraft:block/"+type+"_slab_top\", \"x\": 270, \"uvlock\": true }" +
                        "\"type=east\": { \"model\": \"minecraft:block/"+type+"_slab\", \"x\": 90, \"y\": 90, \"uvlock\": true }" +
                        "\"type=west\": { \"model\": \"minecraft:block/"+type+"_slab_top\", \"x\": 90, \"y\": 90, \"uvlock\": true }" +
                    "}" +
                "}";
    }
}
