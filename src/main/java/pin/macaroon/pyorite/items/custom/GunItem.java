package pin.macaroon.pyorite.items.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.function.Predicate;

/**
 * <h1>GunItem</h1>
 * <code>GunItem</code> class
 * <ul>
 * <li><code>Stettings settings</code>: FabricItemSettings as regular</li>
 * <li><code>int cooldown</code>: cooldown between uses in ticks</li>
 * <li><code>TagKey&lt;Item&gt; ammotag</code>: tag of usable ammo items</li>
 * <li><b>deprecated</b> <s><code>double recoil</code>: recoil, set to <code>0d</code> to disable</s></li>
 * </ul>
 * sigma class by pin <sub>:3</sub>
 */
public class GunItem extends Item {

    //Item ammo;
    public static Predicate<ItemStack> PROJECTILES = null;
    int coolDown;
    double recoil;

    public GunItem(Settings settings, int cooldown, TagKey<Item> ammotag, @Deprecated double recoil) {
        super(settings);
        this.coolDown = cooldown;
        //this.ammo = ammo;
        this.recoil = recoil;
        PROJECTILES = stack -> stack.isIn(ammotag);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (PROJECTILES.test(user.getOffHandStack()) || user.getAbilities().creativeMode) {
            world.playSoundFromEntity(null, user, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 2F, Random.create().nextBetween(8, 12) / 10F);
            SmallFireballEntity projectile = new SmallFireballEntity(world, user, user.getRotationVector().x, user.getRotationVector().y, user.getRotationVector().z);
            Vec3d upos = user.getPos();
            Vec3d npos = new Vec3d(upos.x, upos.y + 1.5D, upos.z);
            projectile.setPosition(npos);
            world.spawnEntity(projectile);
            if (!user.getAbilities().creativeMode) {
                user.getItemCooldownManager().set(this, this.coolDown);
                user.getOffHandStack().decrement(1);
            }
            return TypedActionResult.success(user.getMainHandStack(), true);
        } else {
            return TypedActionResult.fail(user.getMainHandStack());
        }
    }

    public Predicate<ItemStack> getProjectiles() {
        return PROJECTILES;
    }
}
