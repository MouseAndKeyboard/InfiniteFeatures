package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.RandomBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static String[] textpartarray= {"pa","pe","pi","po","pu","ta","te","ti","to","tu","ga","ge","gi","go","gu","fa","fe","fi","fo","fu","ka","ke","ki","ko","ku"};
	static long seed = InfiniteFeatures.currentWorldSeed;
	static Random r0 = new Random(seed);
	static Random r1 = new Random(seed+1);
	static Random r2 = new Random(seed+2);
	static Random r3 = new Random(seed+3);
	static Random r4 = new Random(seed+4);
	static Random r5 = new Random(seed+5);
	static Random r6 = new Random(seed+6);
	static Random r7 = new Random(seed+7);
	public static void initarray() {

	}
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RANDOM_BLOCK = new RandomBlock(textpartarray[r0.nextInt(24)]+textpartarray[r1.nextInt(24)]+textpartarray[r2.nextInt(24)]+textpartarray[r3.nextInt(24)]+"_ore", Material.ROCK);
	public static final Block RANDOM_BLOCK2 = new RandomBlock(textpartarray[r4.nextInt(24)]+textpartarray[r5.nextInt(24)]+textpartarray[r6.nextInt(24)]+textpartarray[r7.nextInt(24)]+"_ore", Material.ROCK);
	//public static final Block RANDOM_BLOCK = new RandomBlock(textpartarray[r0.nextInt(24)]+textpartarray[r1.nextInt(24)]+textpartarray[r2.nextInt(24)]+textpartarray[r3.nextInt(24)]+"_ore", Material.ROCK);
	
	
	
}
