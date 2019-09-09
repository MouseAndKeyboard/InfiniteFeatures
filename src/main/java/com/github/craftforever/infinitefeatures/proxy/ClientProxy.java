package com.github.craftforever.infinitefeatures.proxy;


import java.io.File;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		/*
		try {
			registerResources();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	public static void registerResources() throws NoSuchFieldException, SecurityException {
		List<IResourcePack> defaultResourcePacks = null;
		defaultResourcePacks = ObfuscationReflectionHelper.getPrivateValue(Minecraft.class,Minecraft.getMinecraft(),"defaultResourcePacks");
		FolderResourcePack boby = new FolderResourcePack(new File("InfiniCraft/Resources"));
		defaultResourcePacks.add(boby);
		FMLClientHandler.instance().refreshResources();
	}
}
