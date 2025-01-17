package pin.macaroon.pyorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import pin.macaroon.pyorite.items.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CREEPER_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELEMENTITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELEMENTITE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AEROBLADE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HANDGUN, Models.HANDHELD);
    }
}
