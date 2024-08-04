package com.manchick.tales.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class FallenTreeFeatureConfig implements FeatureConfig {

    public static final Codec<FallenTreeFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(Codecs.rangedInt(1, 16).fieldOf("length").forGetter(FallenTreeFeatureConfig::getLength),
                BlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter(FallenTreeFeatureConfig::getBlockStateProvider),
                Direction.CODEC.fieldOf("direction").forGetter(FallenTreeFeatureConfig::getDirection))
        .apply(instance, FallenTreeFeatureConfig::new);
    });

    private final int length;
    private final BlockStateProvider blockStateProvider;
    private final Direction direction;

    public FallenTreeFeatureConfig(int length, BlockStateProvider blockStateProvider, Direction direction) {
        this.length = length;
        this.blockStateProvider = blockStateProvider;
        this.direction = direction;
    }

    public int getLength() {
        return this.length;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public BlockStateProvider getBlockStateProvider() {
        return this.blockStateProvider;
    }
}
