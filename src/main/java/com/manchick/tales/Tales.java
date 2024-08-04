package com.manchick.tales;

import com.manchick.tales.world.feature.TalesFeatures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Tales implements ModInitializer {

    @Override
    public void onInitialize() {
        TalesFeatures.register();
    }

    public static Identifier of(String path){
        return Identifier.of("tales", path);
    }
}
