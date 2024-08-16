package me.ultrusmods.sizeshiftingpotions;


import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsEffects;
import me.ultrusmods.sizeshiftingpotions.register.SizeShiftingPotionsPotions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class SizeShiftingPotionsNeoForge {

    public SizeShiftingPotionsNeoForge(IEventBus eventBus) {
        SizeShiftingPotionsMod.init();
        eventBus.addListener(this::onRegister);
    }

    public void onRegister(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.MOB_EFFECT) {
            SizeShiftingPotionsEffects.register((id, effect) -> Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, id, effect));

        }
        if (event.getRegistryKey() == Registries.POTION) {
            SizeShiftingPotionsPotions.register((id, potion) -> Registry.registerForHolder(BuiltInRegistries.POTION, id, potion));
        }
    }



}