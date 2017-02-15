/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.integrations.mods.jei.altar;

import com.google.common.collect.Lists;
import hellfirepvp.astralsorcery.client.gui.journal.page.IGuiRenderablePage;
import hellfirepvp.astralsorcery.common.crafting.IAccessibleRecipe;
import hellfirepvp.astralsorcery.common.crafting.altar.recipes.DiscoveryRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipeSlot;
import hellfirepvp.astralsorcery.common.integrations.mods.ModIntegrationJEI;
import hellfirepvp.astralsorcery.common.integrations.mods.jei.base.JEIBaseWrapper;
import hellfirepvp.astralsorcery.common.tile.TileAltar;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.List;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: AltarDiscoveryRecipeWrapper
 * Created by HellFirePvP
 * Date: 15.02.2017 / 16:50
 */
public class AltarDiscoveryRecipeWrapper extends JEIBaseWrapper {

    private DiscoveryRecipe recipe;

    public AltarDiscoveryRecipeWrapper(DiscoveryRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        IAccessibleRecipe underlyingRecipe = recipe.getNativeRecipe();

        List<List<ItemStack>> stackList = Lists.newArrayList();
        for (ShapedRecipeSlot srs : ShapedRecipeSlot.values()) {
            List<ItemStack> stacks = underlyingRecipe.getExpectedStackForRender(srs);
            stackList.add(stacks == null ? Lists.newArrayList() : stacks);
        }
        ingredients.setInputLists(ItemStack.class, stackList);

        ingredients.setOutput(ItemStack.class, recipe.getOutputForRender());
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        /*FontRenderer fr = minecraft.fontRendererObj;
        String toWrite = IGuiRenderablePage.GUI_INTERFACE.getDescriptionFromStarlightAmount(I18n.format("astralsorcery.journal.recipe.amt.desc"),
                recipe.getPassiveStarlightRequired(), TileAltar.AltarLevel.DISCOVERY.getStarlightMaxStorage());
        int w = fr.getStringWidth(toWrite);
        fr.drawString(toWrite, recipeWidth / 2 - w / 2 + 1, recipeHeight + 1, 0xCCCCFF);
        fr.drawString(toWrite, recipeWidth / 2 - w / 2, recipeHeight, 0x0044EE);*/
    }

    @Override
    public void drawAnimations(Minecraft minecraft, int recipeWidth, int recipeHeight) {}

    @Nullable
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return Lists.newArrayList();
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }
}