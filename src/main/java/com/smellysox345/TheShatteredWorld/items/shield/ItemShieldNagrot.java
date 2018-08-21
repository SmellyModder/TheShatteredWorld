package com.smellysox345.TheShatteredWorld.items.shield;

import java.util.List;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.items.ItemBase;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldNagrot extends ItemBase{

	public ItemShieldNagrot(String name) {
		super(name);
		this.maxStackSize = 1;
		this.setCreativeTab(Main.shatteredworldweapons);
		this.setMaxDamage(2985);
		this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
		{
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
            return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
        }
		});
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
    if (stack.getSubCompound("BlockEntityTag") != null)
    {
        EnumDyeColor enumdyecolor = TileEntityBanner.getColor(stack);
        return I18n.translateToLocal("item.shield." + enumdyecolor.getUnlocalizedName() + ".name");
    }
    else
    {
        return I18n.translateToLocal("item.crystalshield.name");
    }
	}

/**
 * allows items to add custom lines of information to the mouseover description
 */
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
    ItemBanner.appendHoverTextFromTileEntityTag(stack, tooltip);
	}

/**
 * returns the action that specifies what animation to play when the items is being used
 */
public EnumAction getItemUseAction(ItemStack stack)
{
    return EnumAction.BLOCK;
}

/**
 * How long it takes to use or consume an item
 */
public int getMaxItemUseDuration(ItemStack stack)
{
    return 30000;
}

/**
 * Called when the equipped item is right clicked.
 */
public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
{
    ItemStack itemstack = playerIn.getHeldItem(handIn);
    playerIn.setActiveHand(handIn);
    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
}

/**
 * Return whether this item is repairable in an anvil.
 *  
 * @param toRepair the {@code ItemStack} being repaired
 * @param repair the {@code ItemStack} being used to perform the repair
 */
public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
{
    return repair.getItem() == Item.getItemFromBlock(ModBlocks.EYE_TREE_DEFAULT) ? true : super.getIsRepairable(toRepair, repair);
}
}
