package me.ultrusmods.sizeshiftingpotions;

import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class SizeShiftingPotionsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        SizeShiftingPotionsMod.init();
        SizeShiftingPotionsEffects.register((id, effect) -> Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, id, effect));
        SizeShiftingPotionsPotions.register((id, potion) -> Registry.registerForHolder(BuiltInRegistries.POTION, id, potion));
//        SizeShiftingPotionsMod.registerRecipes()
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            SizeShiftingPotionsMod.registerRecipes(builder::addMix);
        });
    }
}
