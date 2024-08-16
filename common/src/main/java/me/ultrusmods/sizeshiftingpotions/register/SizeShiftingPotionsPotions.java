package me.ultrusmods.sizeshiftingpotions.register;

import me.ultrusmods.sizeshiftingpotions.Constants;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.BiFunction;

// Gotta stick with my name convention, even if it leads to this.
public class SizeShiftingPotionsPotions {

    public static Holder<Potion> GROWING_POTION;
    public static Holder<Potion> LONG_GROWING_POTION;
    public static Holder<Potion> STRONG_GROWING_POTION;

    public static Holder<Potion> SHRINKING_POTION;
    public static Holder<Potion> LONG_SHRINKING_POTION;
    public static Holder<Potion> STRONG_SHRINKING_POTION;

    public static Holder<Potion> WIDENING_POTION;
    public static Holder<Potion> LONG_WIDENING_POTION;
    public static Holder<Potion> STRONG_WIDENING_POTION;

    public static Holder<Potion> THINNING_POTION;
    public static Holder<Potion> LONG_THINNING_POTION;
    public static Holder<Potion> STRONG_THINNING_POTION;

    public static void register(BiFunction<ResourceLocation, Potion, Holder<Potion>> consumer) {

        GROWING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "growing"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.GROWING, 3600)));
        LONG_GROWING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "growing_long"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.GROWING, 9600)));
        STRONG_GROWING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "growing_strong"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.GROWING, 1800, 1)));

        SHRINKING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "shrinking"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.SHRINKING, 3600)));
        LONG_SHRINKING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "shrinking_long"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.SHRINKING, 9600)));
        STRONG_SHRINKING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "shrinking_strong"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.SHRINKING, 1800, 1)));

        WIDENING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "widening"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.WIDENING, 3600)));
        LONG_WIDENING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "widening_long"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.WIDENING, 9600)));
        STRONG_WIDENING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "widening_strong"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.WIDENING, 1800, 1)));

        THINNING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "thinning"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.THINNING, 3600)));
        LONG_THINNING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "thinning_long"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.THINNING, 9600)));
        STRONG_THINNING_POTION = consumer.apply(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "thinning_strong"), new Potion(new MobEffectInstance(SizeShiftingPotionsEffects.THINNING, 1800, 1)));
    }
}
