package com.github.amusingimpala75.lotr.block;

import net.minecraft.util.SignType;

import static com.github.amusingimpala75.lotr.mixin.SignTypeRegisterInvoker.invokeRegister;

public class ModSignType extends SignType{
    public static final SignType PINE = invokeRegister(new ModSignType("pine"));
    public static final SignType MALLORN = invokeRegister(new ModSignType("mallorn"));
    public static final SignType MIRK_OAK = invokeRegister(new ModSignType("mirk_oak"));
    public static final SignType CHARRED = invokeRegister(new ModSignType("charred"));
    public static final SignType APPLE = invokeRegister(new ModSignType("apple"));
    public static final SignType PEAR = invokeRegister(new ModSignType("pear"));
    public static final SignType CHERRY = invokeRegister(new ModSignType("cherry"));
    public static final SignType LEBETHRON = invokeRegister(new ModSignType("lebethron"));
    public static final SignType BEECH = invokeRegister(new ModSignType("beech"));
    public static final SignType MAPLE = invokeRegister(new ModSignType("maple"));
    public static final SignType ASPEN = invokeRegister(new ModSignType("aspen"));
    public static final SignType LAIRELOSSE = invokeRegister(new ModSignType("lairelosse"));
    public static final SignType CEDAR = invokeRegister(new ModSignType("cedar"));
    public static final SignType FIR = invokeRegister(new ModSignType("fir"));
    public static final SignType LARCH = invokeRegister(new ModSignType("larch"));
    public static final SignType HOLLY = invokeRegister(new ModSignType("holly"));
    public static final SignType GREEN_OAK = invokeRegister(new ModSignType("green_oak"));
    public static final SignType CYPRESS = invokeRegister(new ModSignType("cypress"));


    protected ModSignType(String name) {
        super(name);
    }
}
