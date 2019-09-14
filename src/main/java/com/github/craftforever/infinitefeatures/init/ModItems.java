package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.items.ItemIngotBase;

import net.minecraft.item.Item;

public class ModItems
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static Item[] ingotArray = generateingotarray();
	public static Item[] gemArray = generategemarray();
	public static Item[] itemArray = ArrayUtils.addAll(ingotArray, gemArray);
	//public static Item RANDOM_INGOT1 = new ItemIngotBase(ModBlocks.minerals[0].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static Item RANDOM_INGOT2 = new ItemIngotBase(ModBlocks.minerals[1].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static Item RANDOM_INGOT3 = new ItemIngotBase(ModBlocks.minerals[2].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);

	private static Item[] generateingotarray()
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] itemarray = new Item[ModBlocks.ingotorecount];
			for (int i = 0; i < ModBlocks.ingotorecount; i++)
			{
				itemarray[i] = new ItemIngotBase(ModBlocks.minerals[i].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
			}
			return itemarray;
		}
		else 
		{
			Item[] itemarray = null;
			return itemarray;
		}
		
	}	
	
	private static Item[] generategemarray()
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] itemarray = new Item[ModBlocks.gemorecount];
			for (int i = 0; i < ModBlocks.gemorecount; i++)
			{
				itemarray[i] = new ItemIngotBase(ModBlocks.minerals[i+ModBlocks.ingotorecount].name+"_gem").setCreativeTab(InfiniteFeatures.InfiniTab);
			}
			return itemarray;
		}
		else 
		{
			Item[] itemarray = null;
			return itemarray;
		}
		
	}
}