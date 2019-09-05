package com.github.craftforever.infinitefeatures;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
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
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public static void onWorldLoad(WorldEvent.Load event)
	{
		world = Minecraft.getMinecraft().world;
		saveDir = world.getSaveHandler().getWorldDirectory();
		
		final File generationFIle = new File(saveDir, "infConfig");
		logger.info("File generated here: " + generationFIle.toPath().toString());
	}
}
