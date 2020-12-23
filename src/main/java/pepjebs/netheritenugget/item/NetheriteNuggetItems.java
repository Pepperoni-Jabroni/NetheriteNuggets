package pepjebs.netheritenugget.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import pepjebs.netheritenugget.NetheriteNuggetMod;

public class NetheriteNuggetItems {

    public static final NetheriteNuggetItem NETHERITE_NUGGET = new NetheriteNuggetItem(new Item.Settings().group(ItemGroup.MISC).fireproof());

    public static void onLoad() {
        Registry.register(Registry.ITEM, new Identifier(NetheriteNuggetMod.MODID, "netherite_nugget"), NETHERITE_NUGGET);
    }
}
