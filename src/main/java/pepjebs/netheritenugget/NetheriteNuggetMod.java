package pepjebs.netheritenugget;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pepjebs.netheritenugget.config.NetheriteNuggetConfig;
import pepjebs.netheritenugget.item.NetheriteNuggetItems;

public class NetheriteNuggetMod implements ModInitializer {

    public static final String MODID = "netherite_nugget";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize(){
        NetheriteNuggetItems.onLoad();
        AutoConfig.register(NetheriteNuggetConfig.class, JanksonConfigSerializer::new);

        NetheriteNuggetConfig conf = AutoConfig.getConfigHolder(NetheriteNuggetConfig.class).getConfig();
        if (conf.piglinBruteNetheriteNuggetDropChance > 1.0F) conf.piglinBruteNetheriteNuggetDropChance = 1.0F;
        if (conf.piglinBruteNetheriteNuggetDropChance < 0.0F) conf.piglinBruteNetheriteNuggetDropChance = 0.0F;
        if (conf.piglinBruteNetheriteNuggetDropChance > 0) {
            LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
                if (id.equals(EntityType.PIGLIN_BRUTE.getLootTableId())) {
                    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                            .rolls(BinomialLootNumberProvider.create(1, conf.piglinBruteNetheriteNuggetDropChance))
                            .withEntry(ItemEntry.builder(NetheriteNuggetItems.NETHERITE_NUGGET).build());

                    supplier.withPool(poolBuilder.build());
                }
            });
        }
    }
}