package me.ultrusmods.sizeshiftingpotions.effect;

import net.minecraft.world.entity.LivingEntity;

public interface SizeModifyingEffect {

    void removed(LivingEntity livingEntity, int amplifier);
}
