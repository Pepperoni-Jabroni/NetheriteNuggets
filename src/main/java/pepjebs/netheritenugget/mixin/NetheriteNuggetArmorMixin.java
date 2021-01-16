package pepjebs.netheritenugget.mixin;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pepjebs.netheritenugget.item.NetheriteNuggetItems;

@Mixin(ArmorMaterials.class)
public class NetheriteNuggetArmorMixin {
    @Shadow
    private Lazy<Ingredient> repairIngredientSupplier;

    public NetheriteNuggetArmorMixin() {
        this.repairIngredientSupplier = null;
    }

    @Inject(
        method = "getRepairIngredient",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onGetRepairIngredient(CallbackInfoReturnable ci) {
        if (this.repairIngredientSupplier.get().test(new ItemStack(Items.NETHERITE_INGOT))) {
            ci.setReturnValue(Ingredient.ofItems(new ItemConvertible[]{NetheriteNuggetItems.NETHERITE_NUGGET}));
        }
    }
}
