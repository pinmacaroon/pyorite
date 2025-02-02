package pin.macaroon.pyorite.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class FreezingEffect extends StatusEffect {
    protected FreezingEffect() {
        super(StatusEffectCategory.HARMFUL, 0x00AAAA);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        BlockPos pos = entity.getBlockPos();
        if ((entity instanceof LivingEntity)) {
            entity.slowMovement(null, new Vec3d(0.9F, 1.5, 0.9F));
            if (world.isClient) {
                Random random = world.getRandom();
                boolean bl = entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ();
                if (bl && random.nextBoolean()) {
                    world.addParticle(
                            ParticleTypes.SNOWFLAKE,
                            entity.getX(),
                            (double)(pos.getY() + 1),
                            entity.getZ(),
                            (double)(MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F),
                            0.05F,
                            (double)(MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F)
                    );
                }
            }
        }

        entity.setInPowderSnow(true);
        if (!world.isClient) {

            entity.setOnFire(false);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
