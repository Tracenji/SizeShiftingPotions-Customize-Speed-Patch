package me.ultrusmods.sizeshiftingpotions.register;

import me.ultrusmods.sizeshiftingpotions.Constants;
import me.ultrusmods.sizeshiftingpotions.CustomScaleTypes;
import me.ultrusmods.sizeshiftingpotions.effect.DividingSizeMobEffect;
import me.ultrusmods.sizeshiftingpotions.effect.MultiplyingSizeMobEffect;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.util.function.BiFunction;

public class SizeShiftingPotionsEffects {
    public static Holder<MobEffect> GROWING;
    public static Holder<MobEffect> SHRINKING;
    public static Holder<MobEffect> WIDENING;
    public static Holder<MobEffect> THINNING;

    public static void register(BiFunction<ResourceLocation,MobEffect, Holder<MobEffect>> consumer) {
        GROWING = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "growing"), new MultiplyingSizeMobEffect(MobEffectCategory.NEUTRAL, 0xda086a, CustomScaleTypes.SIZE));
        SHRINKING = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "shrinking"), new DividingSizeMobEffect(MobEffectCategory.NEUTRAL, 0xcca468, CustomScaleTypes.SIZE));
        WIDENING = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "widening"), new MultiplyingSizeMobEffect(MobEffectCategory.NEUTRAL, 0xb3ffc2, CustomScaleTypes.THICKNESS));
        THINNING = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "thinning"), new DividingSizeMobEffect(MobEffectCategory.NEUTRAL, 0xe3b3ff, CustomScaleTypes.THICKNESS));
    }
}
