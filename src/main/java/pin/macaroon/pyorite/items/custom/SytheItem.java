package pin.macaroon.pyorite.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SytheItem extends SwordItem {

    private final int attackdamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributemodifiers;

    public SytheItem(ToolMaterial toolMaterial, float attackSpeed, Settings settings, int attackDamage) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.attackdamage = attackDamage;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "weapon mod", attackdamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "weapon mod", attackSpeed, EntityAttributeModifier.Operation.ADDITION));

        //TODO reach lil bro 💀

        this.attributemodifiers = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributemodifiers : super.getAttributeModifiers(slot);


    }


}
