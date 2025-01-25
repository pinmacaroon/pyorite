package pin.macaroon.pyorite.etc;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.Pyorite;

public class ModParticles {
    public static final DefaultParticleType SCYTHE_SWEEP = registerParticle("scythe_sweep", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String id, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(Pyorite.MOD_ID, id), particleType);
    }
    public static void regParticles(){
        Pyorite.LOGGER.info("registering particles");
    }
}