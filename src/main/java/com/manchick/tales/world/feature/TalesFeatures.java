package com.manchick.tales.world.feature;

import com.manchick.tales.Tales;
import com.manchick.tales.world.feature.config.FallenTreeFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.Feature;

public class TalesFeatures {

    public static final Feature<FallenTreeFeatureConfig> FALLEN_TREE = new FallenTreeFeature(FallenTreeFeatureConfig.CODEC);

    public static void register(){
        Registry.register(Registries.FEATURE, Tales.of("fallen_tree"), FALLEN_TREE);
    }
}
