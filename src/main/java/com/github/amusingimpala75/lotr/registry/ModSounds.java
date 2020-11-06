package com.github.amusingimpala75.lotr.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class ModSounds {
    public static SoundEvent CERAMIC_BREAK = new SoundEvent(id("block.ceramic.break"));
    public static SoundEvent GATE_OPEN = new SoundEvent(id("block.gate.open"));
    public static SoundEvent GATE_CLOSE_STONE = new SoundEvent(id("block.gate.stone_close"));
    public static SoundEvent GATE_CLOSE = new SoundEvent(id("block.gate.close"));
    public static SoundEvent GATE_OPEN_STONE = new SoundEvent(id("block.gate.stone_open"));
    public static SoundEvent TREASURE_BREAK = new SoundEvent(id("block.treasure.break"));
    public static SoundEvent TREASURE_FALL = new SoundEvent(id("block.treasure.fall"));
    public static SoundEvent TREASURE_HIT = new SoundEvent(id("block.treasure.hit"));
    public static SoundEvent TREASURE_PLACE = new SoundEvent(id("block.treasure.place"));
    public static SoundEvent TREASURE_STEP = new SoundEvent(id("block.treasure.step"));
    public static SoundEvent MUG_FILL = new SoundEvent(id("item.mug_fill"));

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, id("block.ceramic.break"), CERAMIC_BREAK);
        Registry.register(Registry.SOUND_EVENT, id("block.gate.open"), GATE_OPEN);
        Registry.register(Registry.SOUND_EVENT, id("block.gate.close"), GATE_CLOSE);
        Registry.register(Registry.SOUND_EVENT, id("block.gate.stone_open"), GATE_OPEN_STONE);
        Registry.register(Registry.SOUND_EVENT, id("block.gate.stone_close"), GATE_CLOSE_STONE);
        Registry.register(Registry.SOUND_EVENT, id("block.treasure.break"), TREASURE_BREAK);
        Registry.register(Registry.SOUND_EVENT, id("block.treasure.fall"), TREASURE_FALL);
        Registry.register(Registry.SOUND_EVENT, id("block.treasure.hit"), TREASURE_HIT);
        Registry.register(Registry.SOUND_EVENT, id("block.treasure.place"), TREASURE_PLACE);
        Registry.register(Registry.SOUND_EVENT, id("block.treasure.step"), TREASURE_STEP);
        Registry.register(Registry.SOUND_EVENT, id("item.mug_fill"), MUG_FILL);

    }
}
