package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static Item RANDOM_INGOT1 = new ItemBase(ModBlocks.name1+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	public static Item RANDOM_INGOT2 = new ItemBase(ModBlocks.name2+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	public static Item RANDOM_INGOT3 = new ItemBase(ModBlocks.name3+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	
}
