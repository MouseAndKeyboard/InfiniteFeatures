
package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;
import com.github.craftforever.infinitefeatures.helpers.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
public class ApplyPotionEffectRandomly extends ApplyPotionEffect implements ISpecialEvent {

    private float probability;

    public ApplyPotionEffectRandomly(PotionEffect ieffect, float iprobability){
        super(ieffect);
        this.probability = iprobability;
    }

    @Override
    public void Execute(RandomBlock block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
        if(RandomHelper.getRandomBoolean(probability)){
            super.Execute(block, livingEntity, relatedEntity, relatedLivingEntity);
        }
    }
}