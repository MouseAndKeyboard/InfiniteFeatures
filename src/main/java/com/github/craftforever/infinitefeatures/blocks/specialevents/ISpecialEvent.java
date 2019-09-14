package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;

import net.minecraft.entity.Entity;

public interface ISpecialEvent 
{
	public void Execute(RandomBlock block, Entity relatedEntity);
}
