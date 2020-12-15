package pepjebs.netheritenugget.mixin;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pepjebs.netheritenugget.item.NetheriteNuggetItems;

@Mixin(ToolMaterials.class)
public class AnvilNetheriteNuggetMixin {
    @Shadow
    @Final
    private final Lazy<Ingredient> repairIngredient;

    public AnvilNetheriteNuggetMixin() {
        this.repairIngredient = null;
    }

    @Inject(
        method = "getRepairIngredient",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onGetRepairIngredient(CallbackInfoReturnable ci) {
        if (this.repairIngredient.get().test(new ItemStack(Items.NETHERITE_INGOT))) {
            ci.setReturnValue(Ingredient.ofItems(new ItemConvertible[]{NetheriteNuggetItems.NETHERITE_NUGGET}));
        }
    }
}
