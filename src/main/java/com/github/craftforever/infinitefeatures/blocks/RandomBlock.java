package com.github.craftforever.infinitefeatures.blocks;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RandomBlock extends BlockBase {
	float rndom1 = (float) (0.01+ InfiniteFeatures.getSeededRandom(1).nextFloat() * (10 - 0.01));
	float rndom2 = (float) (0.01+ InfiniteFeatures.getSeededRandom(1).nextFloat() * (10 - 0.01));
	
	public RandomBlock(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(rndom1);
		setResistance(rndom2);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(InfiniteFeatures.getSeededRandom(1).nextFloat());
	}

}
