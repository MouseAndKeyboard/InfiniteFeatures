package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;

import net.minecraft.entity.Entity;

public class TestEvent implements ISpecialEvent {

    @Override
    public void Execute(RandomBlock block, Entity relatedEntity) {
        block.setLightLevel(1f);
    }
}