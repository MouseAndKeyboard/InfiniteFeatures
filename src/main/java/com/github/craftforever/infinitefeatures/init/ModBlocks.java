package com.github.craftforever.infinitefeatures.init;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.RandomBlock;
import com.github.craftforever.infinitefeatures.util.Mineral;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModBlocks {
	public static String[] textpartarray= {"pa","pe","pi","po","pu","ta","te","ti","to","tu","ga","ge","gi","go","gu","fa","fe","fi","fo","fu","ka","ke","ki","ko","ku","ha","he","hi",
			"ho","hu","la","le","li","lo","lu","na","ne","ni","no","nu","ra","re","ri","ro","ru"};
	public static void initarray() {

	}
//	public static String name1 = textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]
//			+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)];
	public static Mineral[] minerals = generatemineralarray();
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block[] blockArray = generateblockarray();
	
	//public static final Block RANDOM_BLOCK = new RandomBlock(minerals[0]).setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static final Block RANDOM_BLOCK2 = new RandomBlock(minerals[1]).setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static final Block RANDOM_BLOCK3 = new RandomBlock(minerals[2]).setCreativeTab(InfiniteFeatures.InfiniTab);
	
	public static Mineral getRandomMineral() {
		Color color = new Color(InfiniteFeatures.getSeededRandom(2).nextInt(255),InfiniteFeatures.getSeededRandom(2).nextInt(255),InfiniteFeatures.getSeededRandom(2).nextInt(255));
		String name = textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]
				+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)];
		float lightlevel = ((float)InfiniteFeatures.getSeededRandom(1).nextInt(15))/15.0F;
		float hardness =(float)InfiniteFeatures.getSeededRandom(1).nextInt(10);
		float resistance =(float)InfiniteFeatures.getSeededRandom(1).nextInt(10);
		
		//float lightlevel = ((float)InfiniteFeatures.getSeededRandom(2).nextInt(15))/15.0F;
		Mineral mineral = new Mineral(name,Material.ROCK,lightlevel,"pickaxe",InfiniteFeatures.getSeededRandom(1).nextInt(3),hardness,resistance,SoundType.STONE,color);
		return mineral;
	}
	private static Mineral[] generatemineralarray() {
		Mineral[] mineralarray = new Mineral[InfiniteFeatures.ORE_QTY];
		for (int i = 0; i < InfiniteFeatures.ORE_QTY; i++) {
			mineralarray[i] = getRandomMineral();
			}
		return mineralarray;
	}
	public static Block[] generateblockarray(){
		Block[] blockarray = new Block[InfiniteFeatures.ORE_QTY];
		for (int i = 0; i < InfiniteFeatures.ORE_QTY; i++) {
			blockarray[i] = new RandomBlock(minerals[i]).setCreativeTab(InfiniteFeatures.InfiniTab);
			}
		return blockarray;
	}
	
}
