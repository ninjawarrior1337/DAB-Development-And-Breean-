package com.rocker1337.dab.init.items;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by ninjawarrior1337 on 7/28/16.
 */
public class thoriumpickaxe extends ItemPickaxe {

    public static float speed = 15F;

    public static Item.ToolMaterial firststage = EnumHelper.addToolMaterial("firststage", 2147483647, -1, speed, 2147483647.0F, 2147483647);

    public thoriumpickaxe() {
        super(firststage);
        this.attackSpeed = 2147483647.0F;
        setUnlocalizedName(SetItemNames.DABItems.THORIUMPICKAXE.getUnlocalizedName());
        setRegistryName(SetItemNames.DABItems.THORIUMPICKAXE.getRegistryName());
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getStrVsBlock(stack, state) : speed;
    }
}
