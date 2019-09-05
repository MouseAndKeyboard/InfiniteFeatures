package com.github.craftforever.infinitefeatures;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "infeatures")
public class InfiniteFeatures
{
	public static final String modID = "infeatures";
	public static World world;
	public static File saveDir;
	public static Logger logger = LogManager.getLogger();

	public InfiniteFeatures()
	{
		
	}
	
	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event)
	{
		world = Minecraft.getMinecraft().world;
		saveDir = world.getSaveHandler().getWorldDirectory();
		
		final File generationFIle = new File(saveDir, "infConfig");
		if (world.getBlockState(new BlockPos(new Vec3d(0D,0D,0D))) == null) // get if (not) world is generated at 0,0,0, or similar effect, which is essentially true whenever the world is generated
		{
			
		}
	}
}
