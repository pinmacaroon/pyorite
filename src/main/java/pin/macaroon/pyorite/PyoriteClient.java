package pin.macaroon.pyorite;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SweepAttackParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import pin.macaroon.pyorite.block.ModBlocks;
import pin.macaroon.pyorite.etc.ModParticles;

@Environment(EnvType.CLIENT)
public class PyoriteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.SCYTHE_SWEEP, SweepAttackParticle.Factory::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PIN_PLUSH, RenderLayer.getCutout());
        //ParticleFactoryRegistry.getInstance().register(, EndRodParticle.Factory::new);
    }
}
