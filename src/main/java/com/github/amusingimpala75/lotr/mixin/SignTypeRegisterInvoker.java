package com.github.amusingimpala75.lotr.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
/*
attempt to fix non vanilla signs
TODO: actually work
 */
@Mixin(SignType.class)
public interface SignTypeRegisterInvoker {
    @Invoker
    static SignType invokeRegister(SignType type) {
        throw new AssertionError();
    }
}
