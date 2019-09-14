package com.github.craftforever.infinitefeatures.blocks;

import java.util.HashMap;
import java.util.List;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ISpecialEvent;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModBlocks;
import com.github.craftforever.infinitefeatures.init.ModItems;
import com.github.craftforever.infinitefeatures.util.Mineral;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class RandomBlock extends Block implements IHasModel {
	public enum SpecialEventTrigger {
		ONDESTROY, ONEXPLODEDESTROY, ONACTIVATED, ONWALKEDON, ONCLICKED, ONCOLLIDED, ONPLACED, ONFALLENON, ONLANDED,
		ONHARVESTED, ONEXPLODED, ONPLANTGROW, ONNEIGHBOURCHANGE
	}

	public Mineral mineral;

	public String toolType;
	public Material material;
	public float lightlevel, hardness, resistance;
	public int harvestLevel;
	public SoundType sound;
	public HashMap<SpecialEventTrigger, List<ISpecialEvent>> UniqueActions;

	private void invokeSpecialEvents(List<ISpecialEvent> events) {
		events.forEach(event -> event.Execute(this));
	}

	public RandomBlock(Mineral imineral, Material imaterial, float ilightLevel, String itoolType, int iharvestLevel,
			float ihardness, float iresistance, SoundType isound,
			HashMap<SpecialEventTrigger, List<ISpecialEvent>> iuniqueActions) {
		super(imaterial);
		setTranslationKey(imineral.name + "_ore");
		setRegistryName(imineral.name + "_ore");
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

		setSoundType(isound);
		setHardness(ihardness);
		setResistance(iresistance);
		setHarvestLevel(itoolType, iharvestLevel);
		setLightLevel(ilightLevel);

		this.UniqueActions = iuniqueActions;
		this.mineral = imineral;
		this.toolType = itoolType;
		this.material = imaterial;
		this.lightlevel = ilightLevel;
		this.hardness = ihardness;
		this.resistance = iresistance;
		this.harvestLevel = iharvestLevel;
		this.sound = isound;
	}

	// #region Potential function overrides
	@Override
	public void onPlayerDestroy(net.minecraft.world.World p_onPlayerDestroy_1_,
			net.minecraft.util.math.BlockPos p_onPlayerDestroy_2_,
			net.minecraft.block.state.IBlockState p_onPlayerDestroy_3_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONDESTROY;

		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onExplosionDestroy(net.minecraft.world.World p_onExplosionDestroy_1_,
			net.minecraft.util.math.BlockPos p_onExplosionDestroy_2_,
			net.minecraft.world.Explosion p_onExplosionDestroy_3_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONEXPLODEDESTROY;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public boolean onBlockActivated(net.minecraft.world.World p_onBlockActivated_1_,
			net.minecraft.util.math.BlockPos p_onBlockActivated_2_,
			net.minecraft.block.state.IBlockState p_onBlockActivated_3_,
			net.minecraft.entity.player.EntityPlayer p_onBlockActivated_4_,
			net.minecraft.util.EnumHand p_onBlockActivated_5_, net.minecraft.util.EnumFacing p_onBlockActivated_6_,
			float p_onBlockActivated_7_, float p_onBlockActivated_8_, float p_onBlockActivated_9_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONACTIVATED;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
		return false;
	}

	@Override
	public void onEntityWalk(net.minecraft.world.World p_onEntityWalk_1_,
			net.minecraft.util.math.BlockPos p_onEntityWalk_2_, net.minecraft.entity.Entity p_onEntityWalk_3_) {

		SpecialEventTrigger triggerName = SpecialEventTrigger.ONWALKEDON;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onBlockClicked(net.minecraft.world.World p_onBlockClicked_1_,
			net.minecraft.util.math.BlockPos p_onBlockClicked_2_,
			net.minecraft.entity.player.EntityPlayer p_onBlockClicked_3_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONCLICKED;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onEntityCollision(net.minecraft.world.World p_onEntityCollision_1_,
			net.minecraft.util.math.BlockPos p_onEntityCollision_2_,
			net.minecraft.block.state.IBlockState p_onEntityCollision_3_,
			net.minecraft.entity.Entity p_onEntityCollision_4_) {

		SpecialEventTrigger triggerName = SpecialEventTrigger.ONCOLLIDED;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onBlockPlacedBy(net.minecraft.world.World p_onBlockPlacedBy_1_,
			net.minecraft.util.math.BlockPos p_onBlockPlacedBy_2_,
			net.minecraft.block.state.IBlockState p_onBlockPlacedBy_3_,
			net.minecraft.entity.EntityLivingBase p_onBlockPlacedBy_4_,
			net.minecraft.item.ItemStack p_onBlockPlacedBy_5_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONPLACED;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onFallenUpon(net.minecraft.world.World p_onFallenUpon_1_,
			net.minecraft.util.math.BlockPos p_onFallenUpon_2_, net.minecraft.entity.Entity p_onFallenUpon_3_,
			float p_onFallenUpon_4_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONFALLENON;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onLanded(net.minecraft.world.World p_onLanded_1_, net.minecraft.entity.Entity p_onLanded_2_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONLANDED;
		p_onLanded_2_.motionY = 0.0D;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onBlockHarvested(net.minecraft.world.World p_onBlockHarvested_1_,
			net.minecraft.util.math.BlockPos p_onBlockHarvested_2_,
			net.minecraft.block.state.IBlockState p_onBlockHarvested_3_,
			net.minecraft.entity.player.EntityPlayer p_onBlockHarvested_4_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONHARVESTED;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onBlockExploded(net.minecraft.world.World p_onBlockExploded_1_,
			net.minecraft.util.math.BlockPos p_onBlockExploded_2_, net.minecraft.world.Explosion p_onBlockExploded_3_) {

		SpecialEventTrigger triggerName = SpecialEventTrigger.ONEXPLODED;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onPlantGrow(net.minecraft.block.state.IBlockState p_onPlantGrow_1_,
			net.minecraft.world.World p_onPlantGrow_2_, net.minecraft.util.math.BlockPos p_onPlantGrow_3_,
			net.minecraft.util.math.BlockPos p_onPlantGrow_4_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONPLANTGROW;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}

	@Override
	public void onNeighborChange(net.minecraft.world.IBlockAccess p_onNeighborChange_1_,
			net.minecraft.util.math.BlockPos p_onNeighborChange_2_,
			net.minecraft.util.math.BlockPos p_onNeighborChange_3_) {
		SpecialEventTrigger triggerName = SpecialEventTrigger.ONNEIGHBOURCHANGE;
		if (UniqueActions.containsKey(triggerName)) {
			invokeSpecialEvents(UniqueActions.get(triggerName));
		}
	}
	// #endregion

	@Override
	public void registerModels() {
		InfiniteFeatures.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}