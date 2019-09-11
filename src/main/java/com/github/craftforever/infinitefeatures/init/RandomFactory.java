package com.github.craftforever.infinitefeatures.init;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.util.Mineral;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.awt.*;

import static com.github.craftforever.infinitefeatures.helpers.randomhelper.*;
import static com.github.craftforever.infinitefeatures.helpers.randomhelper.getRandomNumberInRange;

public class RandomFactory {

    private static final int RGB_MAX = 255;

    // TODO: allow users to customise min/max values via config file
    private static final int LIGHTLEVEL_MAX = 15;
    private static final int LIGHTLEVEL_MIN = 0;
    private static final int HARDNESS_MIN = 1;
    private static final int HARDNESS_MAX = 10;
    private static final double BLAST_RESISTANCE_MEAN = 15.0D;
    private static final double BLAST_RESISTANCE_STD = 5.0D;
    private static final double BLAST_RESISTANCE_MIN = 0.0D;
    private static final double BLAST_RESISTANCE_MAX = 6000.0D;

    private static final int HARVEST_LEVEL_MIN = 0;
    private static final int HARVEST_LEVEL_MAX = 3;

    public static Mineral randomMineralFactory(String[] textpartarray){

        String randomName =
                  textpartarray[getRandomNumberInRange(0,textpartarray.length, InfiniteFeatures.getSeededRandom(1))]
                + textpartarray[getRandomNumberInRange(0,textpartarray.length, InfiniteFeatures.getSeededRandom(1))]
                + textpartarray[getRandomNumberInRange(0,textpartarray.length, InfiniteFeatures.getSeededRandom(1))]
                + textpartarray[getRandomNumberInRange(0,textpartarray.length, InfiniteFeatures.getSeededRandom(1))];

        // TODO: randomly pick a material
        Material randomMaterial = Material.ROCK;
        // ...

        // Not sure why we're dividing by LIGHTLEVEL_MAX, this is only necessary if the lightlevel is constrained between 0 and 1
        // Someone with more Minecraft experience can fix this here.
        float randomLightLevel = (float)getRandomNumberInRange(
                LIGHTLEVEL_MIN,
                LIGHTLEVEL_MAX,
                InfiniteFeatures.getSeededRandom(1)) / LIGHTLEVEL_MAX;

        // TODO: pick tool type based off the base texture, (sand/dirt base textures probably makes sense to use a shovel)
        // Depending on the direction/extent you want to take the randomisation this could be generated randomly although that would make for poor experiences
        String randomToolType = "pickaxe";
        // ...

        int randomHarvestLevel = getRandomNumberInRange(
                HARVEST_LEVEL_MIN,
                HARVEST_LEVEL_MAX,
                InfiniteFeatures.getSeededRandom(1)
        );

        // How long it takes to mine
        float randomHardness = (float)getRandomNumberInRange(
                HARDNESS_MIN,
                HARDNESS_MAX,
                InfiniteFeatures.getSeededRandom(1));

        // Blast resistance
        float randomBlastResistance = (float)getRandomGaussianInRange(
                BLAST_RESISTANCE_MEAN,
                BLAST_RESISTANCE_STD,
                BLAST_RESISTANCE_MIN,
                BLAST_RESISTANCE_MAX,
                InfiniteFeatures.getSeededRandom(1)
        );

        // TODO: pick a sound type randomly or based on something
        SoundType randomSoundType = SoundType.STONE;
        //...

        Color randomColor = new Color(
                InfiniteFeatures.getSeededRandom(2).nextInt(RGB_MAX),
                InfiniteFeatures.getSeededRandom(2).nextInt(RGB_MAX),
                InfiniteFeatures.getSeededRandom(2).nextInt(RGB_MAX)
        );

        Mineral randomMineral = new Mineral(
                randomName,
                randomMaterial,
                randomLightLevel,
                randomToolType,
                randomHarvestLevel,
                randomHardness,
                randomBlastResistance,
                randomSoundType,
                randomColor
        );

        return randomMineral;
    }
}
