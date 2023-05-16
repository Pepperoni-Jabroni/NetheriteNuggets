package pepjebs.netheritenugget.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pepjebs.netheritenugget.NetheriteNuggetMod;

public class NetheriteNuggetItems {

    public static final NetheriteNuggetItem NETHERITE_NUGGET = new NetheriteNuggetItem(new Item.Settings().fireproof());

    public static void onLoad() {
        Registry.register(Registries.ITEM,
                new Identifier(NetheriteNuggetMod.MODID, "netherite_nugget"), NETHERITE_NUGGET);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(NETHERITE_NUGGET);
        });
    }
}
