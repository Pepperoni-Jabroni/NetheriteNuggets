package pepjebs.netheritenugget.item;

import net.minecraft.item.Item;

public class NetheriteNuggetItem extends Item {

    public NetheriteNuggetItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFireproof() {
        return true;
    }
}
