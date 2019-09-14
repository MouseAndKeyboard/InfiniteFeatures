
package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;
import com.github.craftforever.infinitefeatures.helpers.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
public class ApplyPotionEffectRandomly extends ApplyPotionEffect implements ISpecialEvent {

    protected float probability;

    public ApplyPotionEffectRandomly(int ipotionID, int idurationTicks, int iPotionLevel, boolean iisAmbient,
            boolean ihasParticles, float iTriggerProbability) {
        super(ipotionID, idurationTicks, iPotionLevel, iisAmbient, ihasParticles);
        this.probability = iTriggerProbability;
    }


    @Override
    public void Execute(RandomBlock block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
        if(RandomHelper.getRandomBoolean(probability)){
            super.Execute(block, livingEntity, relatedEntity, relatedLivingEntity);
        }
    }
}