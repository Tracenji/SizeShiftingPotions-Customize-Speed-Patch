package me.ultrusmods.sizeshiftingpotions;

import eu.midnightdust.core.config.MidnightLibConfig;
import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import org.apache.logging.log4j.util.TriConsumer;

public class SizeShiftingPotionsMod {


    public static void init() {
        MidnightLibConfig.init(Constants.MOD_ID, SizeShiftingPotionsConfig.class);
        CustomScaleTypes.init();
    }

    // Holder<Potion> input, Item reagent, Holder<Potion> result
    public static void registerRecipes(TriConsumer<Holder<Potion>, Item, Holder<Potion>> consumer) {
        final Item growItem = SizeShiftingPotionsConfig.useNetherFungus ? Items.CRIMSON_FUNGUS : Items.RED_MUSHROOM;
        final Item shrinkItem = SizeShiftingPotionsConfig.useNetherFungus ? Items.WARPED_FUNGUS : Items.BROWN_MUSHROOM;

        if (SizeShiftingPotionsConfig.growingPotion) {
            consumer.accept(Potions.STRENGTH, growItem, SizeShiftingPotionsPotions.GROWING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.GROWING_POTION, Items.REDSTONE, SizeShiftingPotionsPotions.LONG_GROWING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.GROWING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_GROWING_POTION);
        }

        if (SizeShiftingPotionsConfig.shrinkingPotion) {
            consumer.accept(Potions.WEAKNESS, shrinkItem, SizeShiftingPotionsPotions.SHRINKING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.REDSTONE, SizeShiftingPotionsPotions.LONG_SHRINKING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.GLOWSTONE_DUST, SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION);
        }

        if (SizeShiftingPotionsConfig.wideningPotion) {
            consumer.accept(SizeShiftingPotionsPotions.GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.WIDENING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.STRONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_WIDENING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.LONG_GROWING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_WIDENING_POTION);
        }
        if (SizeShiftingPotionsConfig.thinningPotion) {
            consumer.accept(SizeShiftingPotionsPotions.SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.THINNING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.STRONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.STRONG_THINNING_POTION);
            consumer.accept(SizeShiftingPotionsPotions.LONG_SHRINKING_POTION, Items.FERMENTED_SPIDER_EYE, SizeShiftingPotionsPotions.LONG_THINNING_POTION);
        }

    }
}