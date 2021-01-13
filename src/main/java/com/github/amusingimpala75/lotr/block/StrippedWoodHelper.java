package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.state.property.Properties;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

public class StrippedWoodHelper extends AxeItem {
    private static Map<Supplier<Block>, Supplier<Block>> preparedWoods = new HashMap();

    public StrippedWoodHelper(ToolMaterial tier, float atk, float speed, Settings properties) {
        super(tier, atk, speed, properties);
        throw new IllegalArgumentException("This class should not be instantiated! It only extends AxeItem to access a protected field!");
    }

    public static void prepareStrippedWood(Supplier<Block> wood, Supplier<Block> stripped) {
        preparedWoods.put(wood, stripped);
    }

    public static Map<Block, Block> getStrippingMap() {
        return AxeItem.STRIPPED_BLOCKS;
    }

    //TODO: Check this method
    /*public static void register(Register<Block> event) {
        if (event.getRegistry() == ForgeRegistries.BLOCKS) {
            try {
                Field foundField = null;
                Field[] fs = AxeItem.class.getDeclaredFields();
                Field[] var3 = fs;
                int var4 = fs.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Field f = var3[var5];
                    LOTRUtil.unlockFinalField(f);
                    if (f.get((Object)null) == getStrippingMap()) {
                        foundField = f;
                        break;
                    }
                }

                Map<Block, Block> strippedMap = (Map)foundField.get((Object)null);
                Map<Block, Block> newMap = new HashMap(strippedMap);
                Iterator var12 = preparedWoods.entrySet().iterator();

                while(var12.hasNext()) {
                    Map.Entry<Supplier<Block>, Supplier<Block>> e = (Map.Entry)var12.next();
                    Supplier<Block> wood = (Supplier)e.getKey();
                    Supplier<Block> stripped = (Supplier)e.getValue();
                    newMap.put(wood.get(), stripped.get());
                }

                foundField.set((Object)null, newMap);
                LOTRLog.info("Auto-registered %d stripped wood blocks", new Object[]{preparedWoods.size()});
            } catch (IllegalAccessException | IllegalArgumentException var9) {
                LOTRLog.error("Error auto-registering stripped wood blocks");
                var9.printStackTrace();
            }

        }
    }*/
}
