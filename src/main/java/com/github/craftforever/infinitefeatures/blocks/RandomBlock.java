package com.github.craftforever.infinitefeatures.blocks;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModBlocks;
import com.github.craftforever.infinitefeatures.init.ModItems;
import com.github.craftforever.infinitefeatures.util.Mineral;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class RandomBlock extends Block implements IHasModel
{
	public Mineral mineral;
	
	public String toolType;
	public Material material;
	public float lightlevel, hardness, resistance;
	public int harvestLevel;
	public SoundType sound;

	public RandomBlock(Mineral imineral, Material imaterial, float ilightLevel, String itoolType, int iharvestLevel, 
	float ihardness, float iresistance, SoundType isound)
	{
		super(imaterial);
		setTranslationKey(imineral.name+"_ore");
		setRegistryName(imineral.name+"_ore");
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
		setSoundType(isound);
		setHardness(ihardness);
		setResistance(iresistance);
		setHarvestLevel(itoolType,iharvestLevel);
		setLightLevel(ilightLevel);

		this.mineral = imineral;
		this.toolType = itoolType;
		this.material = imaterial;
		this.lightlevel = ilightLevel;
		this.hardness = ihardness;
		this.resistance = iresistance;
		this.harvestLevel = iharvestLevel;
		this.sound = isound;
	}
	
	@Override
	public void registerModels()
	{
		InfiniteFeatures.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}