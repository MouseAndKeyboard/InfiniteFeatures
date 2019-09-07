package com.github.craftforever.infinitefeatures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.craftforever.infinitefeatures.gui.GuiCustomCreateWorld;
import com.github.craftforever.infinitefeatures.proxy.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "infeatures")
public class InfiniteFeatures
{
	
	public static final String modID = "infeatures";
	public static final String CLIENT_PROXY_CLASS = "com.github.craftforever.infinitefeatures.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.github.craftforever.infinitefeatures.proxy.CommonProxy";
	public static World world;
	public static File saveDir;
	public static long seed;
	public static long currentWorldSeed;
	public static String currentWorldFolder;
	public static String currentWorldFolderName;
	public static GuiScreen parentscreen;
	public static Logger logger = LogManager.getLogger();
	public static boolean continueRandomGeneration = true;
	public static boolean fastStart = false;
	
	//fast start variables
	public static WorldSettings fastWorldSettings;
	public static String fastWorldName;
	public static long fastSeed;
	public static GameType fastGameType;
	public static boolean fastEnabledFeatures;
	public static boolean fastHardcoreMode;
	public static boolean fastEnableBonusChest;
	public static boolean fastEnableCommands;
	public static int fastWorldTypeIndex;
	public static String fastchunkProviderSettings;
	
	@Instance
	public static InfiniteFeatures instance;
	
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{

	}
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{

	}
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}
	
	

	public InfiniteFeatures() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		File fastStartFile = new File("InfiniCraft/fastStartFlag");
		if (continueRandomGeneration) {
			try {
				currentWorldFolder = "saves/"+new String(Files.readAllBytes(Paths.get("InfiniCraft/currentworld")));
				currentWorldFolderName = new String(Files.readAllBytes(Paths.get("InfiniCraft/currentworld")));
			} catch (IOException e) {
				continueRandomGeneration = false;
				System.out.print("NO WORLD SELECTED\n");
			}
		}
		if(fastStartFile.exists()&&continueRandomGeneration) {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(fastStartFile));
			fastStart = true;
			fastWorldName =(String)in.readObject();
			fastSeed =(long)in.readObject();
			System.out.print("\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
			System.out.print(fastWorldName+"\n");
			System.out.print(fastSeed+"\n");
			fastGameType=(GameType)in.readObject();
			fastEnabledFeatures=(boolean)in.readObject();
			fastHardcoreMode=(boolean)in.readObject();
			fastEnableBonusChest=(boolean)in.readObject();
			fastEnableCommands=(boolean)in.readObject();
			fastWorldTypeIndex=(int)in.readObject();
			fastchunkProviderSettings=(String)in.readObject();
			in.close();
			fastStartFile.delete();
			fastWorldSettings = new WorldSettings(fastSeed, fastGameType, fastEnabledFeatures, fastHardcoreMode, WorldType.WORLD_TYPES[fastWorldTypeIndex]);
			fastWorldSettings.setGeneratorOptions(fastchunkProviderSettings);
			if(fastEnableBonusChest) {
				fastWorldSettings.enableBonusChest();
			}
			if(fastEnableCommands) {
				fastWorldSettings.enableCommands();
			}
		}
		if (continueRandomGeneration) {
			try {
				currentWorldSeed = ByteToLong(Files.readAllBytes(Paths.get(currentWorldFolder+"/infConfig/infFile")));
			} catch (IOException e) {
				continueRandomGeneration = false;
				System.out.print("SELECTED WORLD DOESN'T EXIST\n");
				System.out.print("SELECTED WORLD: "+currentWorldFolder+"/infConfig/infFile" );
			}
		}
		
		MinecraftForge.EVENT_BUS.register(getClass());
	}
	public static void saveInfFile(long Iseed, String saveDir, String worldName, Minecraft mc, WorldSettings worldSettings, int selectedIndex,String chunkProviderSettings) throws IOException
	{
		boolean shutItDown = false;
		seed = Iseed;
		File generationFolder = new File("saves/"+saveDir+"/infConfig");
		File infinicraftFolder = new File("InfiniCraft");
		generationFolder.mkdirs();
		infinicraftFolder.mkdirs();
		File generationFile = new File(generationFolder,"infFile");
		File currentWorldFile = new File(infinicraftFolder,"currentworld");
		
		if(!currentWorldFile.exists()){
			currentWorldFile.createNewFile();
			byte[] saveBytes = saveDir.getBytes();
			Files.write(currentWorldFile.toPath(), saveBytes);
		}
		if(!generationFile.exists()){
			generationFile.createNewFile();
			Files.write(generationFile.toPath(), longToByte(seed));
			logger.info("File generated here: " + generationFile.toPath().toString()+"\n");
			shutItDown = true;
		}
		if(shutItDown) {
			File fastStartFlag = new File(infinicraftFolder,"fastStartFlag");
			if (fastStartFlag.exists()) {
				fastStartFlag.delete();
			}
			fastStartFlag.createNewFile();
			FileOutputStream fout=new FileOutputStream(fastStartFlag.toString());
			ObjectOutputStream out=new ObjectOutputStream(fout);
			out.writeObject(worldName);
			out.flush();
			out.writeObject(worldSettings.getSeed());
			out.flush();
			out.writeObject(worldSettings.getGameType());
			out.flush();
			out.writeObject(worldSettings.isMapFeaturesEnabled());
			out.flush();
			out.writeObject(worldSettings.getHardcoreEnabled());
			out.flush();
			out.writeObject(worldSettings.isBonusChestEnabled());
			out.flush();
			out.writeObject(worldSettings.areCommandsAllowed());
			out.flush();
			out.writeObject(selectedIndex);
			out.flush();
			out.writeObject(chunkProviderSettings);
			out.flush();
			out.close();
			mc.shutdown();
		}
		
	}
	
	public static byte[] longToByte(long l) {
		byte[] b = new byte[] {
			       (byte) l,
			       (byte) (l >> 8),
			       (byte) (l >> 16),
			       (byte) (l >> 24),
			       (byte) (l >> 32),
			       (byte) (l >> 40),
			       (byte) (l >> 48),
			       (byte) (l >> 56)};
		return b;
	}
	public static long ByteToLong(byte[] b) {
		long l = ((long) b[7] << 56)
			       | ((long) b[6] & 0xff) << 48
			       | ((long) b[5] & 0xff) << 40
			       | ((long) b[4] & 0xff) << 32
			       | ((long) b[3] & 0xff) << 24
			       | ((long) b[2] & 0xff) << 16
			       | ((long) b[1] & 0xff) << 8
			       | ((long) b[0] & 0xff);
			return l;
	}
    @SubscribeEvent
    public static void onOpenGui(GuiOpenEvent event)
    {
    	if(event.getGui() != null && event.getGui().getClass() == GuiMainMenu.class)
        {
    		parentscreen = event.getGui();
    		if(fastStart) {
    			event.setGui(new GuiCustomCreateWorld(parentscreen));
    			//event.getGui().mc.launchIntegratedServer(currentWorldFolderName, fastWorldName, fastWorldSettings);
    			//event.getGui().mc.displayGuiScreen((GuiScreen)null);
    		}
        }
    	if(event.getGui() != null && event.getGui().getClass() == GuiWorldSelection.class)
        {
			parentscreen = event.getGui();
        }
        if(event.getGui() != null && event.getGui().getClass() == GuiCreateWorld.class)
        {
            event.setGui(new GuiCustomCreateWorld(parentscreen));
        }
    }
}