package pin.macaroon.pyorite.items.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.BuiltinBiomes;
import pin.macaroon.pyorite.Pyorite;
import pin.macaroon.pyorite.entity.effect.ModStatusEffects;

public class IceSwordItem extends SwordItem {
    public IceSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity attacker) {
        entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.FREEZING, 200), attacker);
        if(attacker.getWorld().getBiome(attacker.getBlockPos()).value().getTemperature() <= 0.2F){
            entity.damage(attacker.getDamageSources().freeze(), 2F);
        }
        return super.postHit(stack, entity, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity.getWorld().getBiome(entity.getBlockPos()).value().getTemperature() <= 0.2F){
            Pyorite.LOGGER.info("ice sword item inventory tick");
            entity.setInPowderSnow(false);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
