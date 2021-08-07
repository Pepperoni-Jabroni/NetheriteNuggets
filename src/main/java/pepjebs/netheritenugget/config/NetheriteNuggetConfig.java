package pepjebs.netheritenugget.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import pepjebs.netheritenugget.NetheriteNuggetMod;

@Config(name = NetheriteNuggetMod.MODID)
public class NetheriteNuggetConfig implements ConfigData {

    @Comment("The [0-1] (0%-100%) chance of a Piglin Brute dropping a Netherite Nugget on death.")
    public float piglinBruteNetheriteNuggetDropChance = 0.5F;
}
