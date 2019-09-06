package com.github.craftforever.infinitefeatures;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
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
		MinecraftForge.EVENT_BUS.register(getClass());
	}
	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event) throws IOException
	{
		world = event.getWorld();
		saveDir = world.getSaveHandler().getWorldDirectory();
		File generationFile = new File(saveDir, "infConfig");
		
		if(!generationFile.exists())
		{
			generationFile.createNewFile();
			logger.debug("File generated here: " + generationFile.toPath().toString());
		}
		else
		{
			logger.debug("File already exists: " + generationFile.toPath().toString());
		}
		
	}
}