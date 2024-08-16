package me.ultrusmods.sizeshiftingpotions.platform;

import me.ultrusmods.sizeshiftingpotions.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class SizeShiftingPotionsPlatformHelperFabric implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
