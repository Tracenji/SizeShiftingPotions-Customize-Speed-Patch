package me.ultrusmods.sizeshiftingpotions;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class SizeShiftingPotionsEvents {

    @SubscribeEvent
    public static void onBrewingRecipeEvent(RegisterBrewingRecipesEvent event) {
        SizeShiftingPotionsMod.registerRecipes(event.getBuilder()::addMix);
    }
}
