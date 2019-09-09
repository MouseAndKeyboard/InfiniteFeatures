package com.github.craftforever.infinitefeatures.util.handler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

import org.apache.commons.lang3.text.WordUtils;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModBlocks;
import com.github.craftforever.infinitefeatures.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event){
		if (InfiniteFeatures.continueRandomGeneration == true){
			event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		}
	}
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event){
		if (InfiniteFeatures.continueRandomGeneration == true){
			ModBlocks.initarray();
			event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		}
		
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event){
		if (InfiniteFeatures.continueRandomGeneration == true){
			for(Item item : ModItems.ITEMS) {
				if(item instanceof IHasModel) {
					((IHasModel)item).registerModels();
				}
			}
			for(Block block : ModBlocks.BLOCKS) {
				if(block instanceof IHasModel) {
					((IHasModel)block).registerModels();
				}
			}
		}
	}
	 public static void generateLangFile() throws IOException {
		 Charset charset = Charset.forName("UTF-8");
		 File langFolder = new File("InfiniCraft/Resources/assets/infeatures/lang");
		 langFolder.mkdirs();
		 File langFile = new File("InfiniCraft/Resources/assets/infeatures/lang/en_us.lang");
		 if (!langFile.exists()) {
			 langFile.createNewFile();
		 }else {
			 langFile.delete();
			 langFile.createNewFile();
		 }
		 BufferedWriter writer = Files.newBufferedWriter(langFile.toPath(), charset);
		 for(Block block : ModBlocks.BLOCKS) {
			 String blockName = block.getTranslationKey().substring(5);
			 blockName = blockName.replace("_", " ");
			 blockName = WordUtils.capitalize(blockName);
			 String langinput = block.getTranslationKey()+".name="+blockName+"\n";
			 writer.write(langinput);
			 writer.flush();
		 }
		 writer.close();
	 }
	 public static void generateTextures() throws IOException {
		 File blockTextureFolder = new File("InfiniCraft/Resources/assets/infeatures/textures/blocks");
		 blockTextureFolder.mkdirs();
		 InputStream streambases = InfiniteFeatures.class.getClassLoader().getResourceAsStream("assets/infeatures/textures/block/base");
		 BufferedReader reader = new BufferedReader(new InputStreamReader(streambases));
		 List<String> bases = new ArrayList<String>();
		 int baseammount = 0;
		 while( reader.ready() ) {
			 baseammount ++;
			 String line = reader.readLine();
			 bases.add(line);
		 }
		 //System.out.print(reader.readLine());
		 InputStream streamores = InfiniteFeatures.class.getClassLoader().getResourceAsStream("assets/infeatures/textures/block/ore");
		 reader = new BufferedReader(new InputStreamReader(streamores));
		 List<String> ores = new ArrayList<String>();
		 int oreammount = 0;
		 while( reader.ready() ) {
			 oreammount ++;
			 String line = reader.readLine();
			 System.out.print("\n\n\n"+line+"\n\n\n");
			 ores.add(line);
			 
		 }
		 for(Block block : ModBlocks.BLOCKS) {
			 InputStream stream = InfiniteFeatures.class.getClassLoader().getResourceAsStream("assets/infeatures/textures/block/base/"+bases.get(InfiniteFeatures.getSeededRandom(2).nextInt(baseammount)));
			 BufferedImage baseImg = ImageIO.read(stream);
			 stream = InfiniteFeatures.class.getClassLoader().getResourceAsStream("assets/infeatures/textures/block/ore/"+ores.get(InfiniteFeatures.getSeededRandom(3).nextInt(oreammount)));
			 BufferedImage oreImg = ImageIO.read(stream);
			 BufferedImage finalImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			 Graphics g = finalImg.getGraphics();
			 g.drawImage(baseImg, 0, 0, null);
			 dye(oreImg,new Color(InfiniteFeatures.getSeededRandom(2).nextInt(255),InfiniteFeatures.getSeededRandom(2).nextInt(255),InfiniteFeatures.getSeededRandom(2).nextInt(255)));
			 g.drawImage(oreImg, 0, 0, null);
			 ImageIO.write(finalImg, "PNG", new File("InfiniCraft/Resources/assets/infeatures/textures/blocks/"+block.getTranslationKey().substring(5)+".png"));
		 }
	 }
	 public static void generateModels() throws IOException {
		 Charset charset = Charset.forName("UTF-8");
		 File blockModelFolder = new File("InfiniCraft/Resources/assets/infeatures/models/block");
		 File itemModelFolder = new File("InfiniCraft/Resources/assets/infeatures/models/item");
		 File blockstateFolder = new File("InfiniCraft/Resources/assets/infeatures/blockstates");
		 blockModelFolder.mkdirs();
		 itemModelFolder.mkdirs();
		 blockstateFolder.mkdirs();
		 for(Block block : ModBlocks.BLOCKS) {
			 File blockModelFile = new File("InfiniCraft/Resources/assets/infeatures/models/block/"+block.getTranslationKey().substring(5)+".json");
			 File itemModelFile = new File("InfiniCraft/Resources/assets/infeatures/models/item/"+block.getTranslationKey().substring(5)+".json");
			 File BlockstatelFile = new File("InfiniCraft/Resources/assets/infeatures/blockstates/"+block.getTranslationKey().substring(5)+".json");
			 if (!blockModelFile.exists()) {
				 blockModelFile.createNewFile();
			 }
			 if (!itemModelFile.exists()) {
				 itemModelFile.createNewFile();
			 }
			 if (!BlockstatelFile.exists()) {
				 BlockstatelFile.createNewFile();
			 }
			 BufferedWriter writer = Files.newBufferedWriter(blockModelFile.toPath(), charset);
			 String modelInput = "{\r\n" + 
			 		"   \"parent\": \"block/cube_all\",\r\n" + 
			 		"   \"textures\": {\r\n" + 
			 		"       \"all\": \""+InfiniteFeatures.modID+":blocks/"+block.getTranslationKey().substring(5)+"\"\r\n" + 
			 				"   }\r\n" + 
			 				"}";
			 writer.write(modelInput);
			 writer.flush();
			 writer.close();
			 writer = Files.newBufferedWriter(itemModelFile.toPath(), charset);
			 modelInput ="{\r\n" + 
			 		"   \"parent\": \""+InfiniteFeatures.modID+":block/"+block.getTranslationKey().substring(5)+"\"\r\n" + 
			 				"}";
			 writer.write(modelInput);
			 writer.flush();
			 writer.close();
			 writer = Files.newBufferedWriter(BlockstatelFile.toPath(), charset);
			 modelInput ="{\r\n" + 
			 		"    \"variants\": {\r\n" + 
			 		"        \"normal\": { \"model\": \""+InfiniteFeatures.modID+":"+block.getTranslationKey().substring(5)+"\" }\r\n" + 
			 				"    }\r\n" + 
			 				"}";
			 writer.write(modelInput);
			 writer.flush();
			 writer.close();
			 
		 }
	 }
	 private static void dye(BufferedImage image, Color color){
		 for (int x = 0; x < image.getWidth(); x++) {
			 for (int y = 0; y < image.getHeight(); y++) {
				 Color pixelColor = new Color(image.getRGB(x, y), true);
				 int r =(int)((float)pixelColor.getRed() * color.getRed() / 255);
				 int g =(int)((float)pixelColor.getGreen() * color.getGreen() / 255);
				 int b =(int)((float)pixelColor.getBlue() * color.getBlue() / 255);
				 int a = pixelColor.getAlpha();
				 int rgba = (a << 24) | (r << 16) | (g << 8) | b;
				 image.setRGB(x, y, rgba);
			 }
		 }
	 }
}