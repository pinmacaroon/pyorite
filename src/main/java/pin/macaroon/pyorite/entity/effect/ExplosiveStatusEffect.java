package pin.macaroon.pyorite.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class ExplosiveStatusEffect extends StatusEffect {
    protected ExplosiveStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x800080);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    /*
    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if(Math.random() > 0.5d){
            //float force = (float) amplifier;
            Bloomery.LOGGER.debug("!!explode!!");
            Bloomery.LOGGER.info("!!explode!!");
            float force = 4F;
            target.getWorld().createExplosion(target, target.getPos().x, target.getPos().z + (double) (target.getHeight() / 16.0f), target.getPos().z, force, World.ExplosionSourceType.MOB);
        }
        super.applyInstantEffect(source, attacker, target, amplifier, proximity);
    }
    */

    @Override
    public void applyUpdateEffect(LivingEntity target, int amplifier) {
        //Bloomery.LOGGER.info("!!starting to explode!!");
        if(target.isPlayer()){
            //float force = (float) amplifier;
            //Bloomery.LOGGER.info("!!explode!!");
            float force = 3F;

            float explosionRadius = amplifier / 100F;


            target.getWorld().createExplosion(target, target.getX(), target.getY(), target.getZ(), (float)explosionRadius * force, World.ExplosionSourceType.MOB);
            target.kill();
            //spawnEffectsCloud(target);
        }else {
            //ignore
        }
        super.applyUpdateEffect(target, amplifier);
    }
}
