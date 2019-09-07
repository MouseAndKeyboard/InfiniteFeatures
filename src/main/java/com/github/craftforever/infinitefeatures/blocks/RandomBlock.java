package com.github.craftforever.infinitefeatures.blocks;

import java.util.Random;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RandomBlock extends BlockBase {
	long seed = InfiniteFeatures.currentWorldSeed;
	Random r1 = new Random(seed);
	Random r2 = new Random(seed+1);
	Random r3 = new Random(seed+2);
	float rndom1 = (float) (0.01+ r1.nextFloat() * (10 - 0.01));
	float rndom2 = (float) (0.01+ r2.nextFloat() * (10 - 0.01));
	
	public RandomBlock(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(rndom1);
		setResistance(rndom2);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(r3.nextFloat());
		//setLightOpacity(1);
		//setBlockUnbreakable();
	}

}
