package com.manchick.tales.world.feature;

import com.manchick.tales.world.feature.config.FallenTreeFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class FallenTreeFeature extends Feature<FallenTreeFeatureConfig> {

    public FallenTreeFeature(Codec<FallenTreeFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<FallenTreeFeatureConfig> context) {
        FallenTreeFeatureConfig config = context.getConfig();
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        int length = config.getLength();
        BlockStateProvider blockStateProvider = config.getBlockStateProvider();
        Direction direction = config.getDirection();
        Random random = world.getRandom();

        for(int i = 0; i < length; i++){
            BlockPos pos = origin.offset(direction, i);
            BlockState state = blockStateProvider.get(random, pos);
            world.setBlockState(pos, state, 2);
        }
        return true;
    }
}
