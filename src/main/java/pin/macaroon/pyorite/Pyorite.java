package pin.macaroon.pyorite;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pin.macaroon.pyorite.items.ModItems;

public class Pyorite implements ModInitializer {
	public static final String MOD_ID = "pyorite";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.regModItems();

		LOGGER.info("I am alive and ready to take over your world :)");
	}
}