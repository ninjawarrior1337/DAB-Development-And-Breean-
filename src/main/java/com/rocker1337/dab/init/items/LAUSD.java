package com.rocker1337.dab.init.items;

import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class LAUSD extends Item
{
    public LAUSD()
    {
        setUnlocalizedName(ItemSetNames.DABItems.LAUSD.getUnlocalizedName());
        setRegistryName(ItemSetNames.DABItems.LAUSD.getRegistryName());

        maxStackSize = 1;
        setMaxDamage(20);




    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {

        playerIn.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("wither"), 525, 2));
        playerIn.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("hunger"), 525, 2));
        playerIn.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("levitation"), 525, 4));
        worldIn.createExplosion(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, 4.0F, true);

        itemStackIn.damageItem(1, playerIn);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }





}