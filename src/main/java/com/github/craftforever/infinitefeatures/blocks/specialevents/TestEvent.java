package com.github.craftforever.infinitefeatures.blocks.specialevents;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class TestEvent implements ISpecialEvent {

    @Override
    public void Execute(Block block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
    	block.setLightLevel(1f);
    }
}