package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;

public class TestEvent implements ISpecialEvent {

    @Override
    public void Execute(RandomBlock block) {
        block.setLightLevel(1f);
    }
}