package pin.macaroon.pyorite.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.mixin.itemgroup.ItemGroupAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pin.macaroon.pyorite.Pyorite;
import pin.macaroon.pyorite.block.plush.PinPlush;

import java.util.List;

public class ModBlocks {

    public static final Block PIN_PLUSH = registerBlock("pin_plush",
            new PinPlush(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).nonOpaque().noCollision()));

    //HELPER METHODS BY KAUPENJOE
    private static Block registerBlock(String name, Block block, String tooltipKey) {
        registerBlockItem(name, block, tooltipKey);
        return Registry.register(Registries.BLOCK, new Identifier(Pyorite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(Pyorite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Pyorite.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Pyorite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Pyorite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Pyorite.LOGGER.info("registering blocks for " + Pyorite.MOD_ID);
    }
}
