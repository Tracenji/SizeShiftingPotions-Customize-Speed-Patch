package me.ultrusmods.sizeshiftingpotions.effect;

import me.ultrusmods.sizeshiftingpotions.config.SizeShiftingPotionsConfig;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleType;

public class MultiplyingSizeMobEffect extends MobEffect implements SizeModifyingEffect {
    private final ScaleType scaleType;

    public MultiplyingSizeMobEffect(MobEffectCategory category, int color, ScaleType scaleType) {
        super(category, color);
                this.scaleType = scaleType;
    }

    @Override
    public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
        super.onEffectStarted(livingEntity, amplifier);
        ScaleData scaleData = scaleType.getScaleData(livingEntity);
        double newScale = (amplifier + 1) * SizeShiftingPotionsConfig.sizeChangeFactor;
        newScale = Math.min(newScale, SizeShiftingPotionsConfig.maxSize);
        scaleData.setTargetScale((float) newScale);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());
    }

    @Override
    public void removed(LivingEntity livingEntity, int amplifier) {
        ScaleData scaleData = scaleType.getScaleData(livingEntity);
        scaleData.setTargetScale(1.0F);
        scaleData.setScaleTickDelay(scaleData.getScaleTickDelay());

    }

}





