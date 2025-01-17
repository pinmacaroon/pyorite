package pin.macaroon.pyorite.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AerobladeItem extends SwordItem {

    private final Multimap<EntityAttribute, EntityAttributeModifier> attributemodifiers;
    int coolDown;
    double velocity;

    public AerobladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int coolDown, double velocity) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "weapon mod", attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "weapon mod", attackSpeed, EntityAttributeModifier.Operation.ADDITION));

        //TODO reach lil bro 💀

        this.attributemodifiers = builder.build();
        this.coolDown = coolDown;
        this.velocity = velocity;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributemodifiers : super.getAttributeModifiers(slot);


    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity){
                if(((PlayerEntity) entity).getEquippedStack(EquipmentSlot.MAINHAND).getItem() == this){
                    PlayerEntity player = (PlayerEntity) entity;

                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20));
                }}
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()){

            BlockPos positionClicked = user.getBlockPos();

            world.playSound(
                    null, // Player - if non-null, will play sound for every nearby player *except* the specified player
                    user.getBlockPos(), // The position of where the sound will come from
                    SoundEvents.ENTITY_ENDER_DRAGON_FLAP, // The sound that will play
                    SoundCategory.BLOCKS, // This determines which of the volume sliders affect this sound
                    1f, //Volume multiplier, 1 is normal, 0.5 is half volume, etc
                    1f // Pitch multiplier, 1 is normal, 0.5 is half pitch, etc
            );

        }

        Vec3d lookVec = user.getRotationVector();
        double x = lookVec.x;
        double y = lookVec.y;
        double z = lookVec.z;

        world.addParticle(
                ParticleTypes.POOF,
                true,
                user.getBlockX(),
                user.getBlockY(),
                user.getBlockZ(),
                -x + 0.5,
                -y,
                -z
        );
        world.addParticle(
                ParticleTypes.POOF,
                true,
                user.getBlockX(),
                user.getBlockY(),
                user.getBlockZ(),
                -x,
                -y,
                -z + 0.5
        );
        world.addParticle(
                ParticleTypes.POOF,
                true,
                user.getBlockX(),
                user.getBlockY(),
                user.getBlockZ(),
                -x,
                -y,
                -z
        );

        user.addVelocity(x * this.velocity, y * (this.velocity * ( 120F /100F)), z * this.velocity);



        user.getItemCooldownManager().set(this, this.coolDown);
        return super.use(world, user, hand);
    }
}
