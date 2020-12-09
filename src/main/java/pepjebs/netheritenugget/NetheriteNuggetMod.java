package pepjebs.netheritenugget;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pepjebs.netheritenugget.item.NetheriteNuggetItems;

public class NetheriteNuggetMod implements ModInitializer {

    public static final String MODID = "netherite_nugget";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize(){
        NetheriteNuggetItems.onLoad();
    }
}