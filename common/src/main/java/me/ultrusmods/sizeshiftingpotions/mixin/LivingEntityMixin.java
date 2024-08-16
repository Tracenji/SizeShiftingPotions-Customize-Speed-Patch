package me.ultrusmods.sizeshiftingpotions.mixin;

import me.ultrusmods.sizeshiftingpotions.Constants;
import me.ultrusmods.sizeshiftingpotions.effect.SizeModifyingEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "onEffectRemoved", at = @At("HEAD"))
    public void onEffectRemovedTriggerer(MobEffectInstance effectInstance, CallbackInfo ci) {
        if (effectInstance.getEffect().value() instanceof SizeModifyingEffect sizeModifyingEffect) {
            sizeModifyingEffect.removed((LivingEntity) (Object) this, effectInstance.getAmplifier());
        }
    }
}
