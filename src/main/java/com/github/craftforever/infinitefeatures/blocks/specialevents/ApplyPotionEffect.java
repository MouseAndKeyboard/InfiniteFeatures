
package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomBlock;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
public class ApplyPotionEffect implements ISpecialEvent {

    protected PotionEffect effect;

    public ApplyPotionEffect(PotionEffect ieffect){
        this.effect = ieffect;
    }

    @Override
    public void Execute(RandomBlock block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
        if (livingEntity){
            relatedLivingEntity.addPotionEffect(effect);
        }

    }
}