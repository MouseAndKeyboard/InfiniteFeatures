package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;
import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.RandomBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {
	public static String[] textpartarray= {"pa","pe","pi","po","pu","ta","te","ti","to","tu","ga","ge","gi","go","gu","fa","fe","fi","fo","fu","ka","ke","ki","ko","ku","ha","he","hi",
			"ho","hu","la","le","li","lo","lu","na","ne","ni","no","nu","ra","re","ri","ro","ru"};
	static long seed = InfiniteFeatures.currentWorldSeed;
	public static void initarray() {

	}
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RANDOM_BLOCK = new RandomBlock(textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]
	+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+"_ore", Material.ROCK).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	public static final Block RANDOM_BLOCK2 = new RandomBlock(textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]
	+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+"_ore", Material.ROCK).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	public static final Block RANDOM_BLOCK3 = new RandomBlock(textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]
	+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+"_ore", Material.ROCK).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	
	
	
}
