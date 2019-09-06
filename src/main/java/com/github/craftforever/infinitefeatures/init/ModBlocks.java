package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RANDOM_BLOCK = new RandomBlock("random_block", Material.ROCK);
	
}
