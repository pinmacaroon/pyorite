package pin.macaroon.pyorite.etc;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.Pyorite;

public class ModSoundEvents {
    public static final SoundEvent PLUSH_SQUEAK = register("plush_squeak");

    public static void regSounds(){
        Pyorite.LOGGER.info("registering sounds.json");
    }

    //GOT FROM FABRIC SOURCE


    private static SoundEvent register(String id) {
        Identifier identifier = Identifier.of(Pyorite.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
}
