package pin.macaroon.pyorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.Pyorite;
import pin.macaroon.pyorite.block.ModBlocks;
import pin.macaroon.pyorite.items.ModItems;

import java.util.function.Consumer;

public class ModAdvancementGenerator extends FabricAdvancementProvider {
    public ModAdvancementGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootADV = Advancement.Builder.create()
                .display(
                        ModItems.PRETTY_PINK_HEART,
                        Text.translatable("advancement.pyorite.plush_adv.title"),
                        Text.translatable("advancement.pyorite.plush_adv.description"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("plush_got", InventoryChangedCriterion.Conditions.items(ModBlocks.PIN_PLUSH))
                .build(consumer, Pyorite.MOD_ID + "/root");
    }
}
