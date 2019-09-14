
package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
public class ApplyPotionEffect implements ISpecialEvent {

    protected PotionEffect effect;

    public ApplyPotionEffect(int ipotionID, int idurationTicks, int iPotionLevel, boolean iisAmbient, boolean ihasParticles){
        // isAmbient Makes potion effect produce more, translucent, particles.

        this.effect = new PotionEffect(Potion.getPotionById(ipotionID), idurationTicks, iPotionLevel - 1, iisAmbient, ihasParticles);
    }

    @Override
    public void Execute(RandomBlock block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
        if (livingEntity){
            relatedLivingEntity.addPotionEffect(effect);
        }

    }
}