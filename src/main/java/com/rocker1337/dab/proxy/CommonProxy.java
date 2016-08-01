package com.rocker1337.dab.proxy;

import com.rocker1337.dab.ConfigHandler;
import com.rocker1337.dab.Reference;
import com.rocker1337.dab.events.*;
import com.rocker1337.dab.init.SoundEvents.RegisterSoundEvents;
import com.rocker1337.dab.init.blocks.DABBlocks;
import com.rocker1337.dab.init.items.DABItems;
import com.rocker1337.dab.init.crafting.DABCrafting;
import com.rocker1337.dab.world.DABBiomeRegistry;
import com.rocker1337.dab.world.DabWorldGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;


public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        System.out.println("Starting Pre Init");
        //Init Biomes
        DABBiomeRegistry.MainRegistry();
        //Init and Register Items
        DABItems.init();
        DABItems.register();
        //Init and Register Blocks
        DABBlocks.init();
        DABBlocks.register();
        //Init Sounds
        RegisterSoundEvents.init();
    }
    public void init(FMLInitializationEvent e)
    {
        System.out.println("Starting Init");
        DABItems.setCreativeTab();
        DABBlocks.setCreativeTab();
        DABCrafting.initCrafting();
        GameRegistry.registerWorldGenerator(new DabWorldGen(), 0);
        MinecraftForge.EVENT_BUS.register(new StrengthSword());
        MinecraftForge.EVENT_BUS.register(new SuperEvent());
        MinecraftForge.EVENT_BUS.register(new Gamerules());
        MinecraftForge.EVENT_BUS.register(new DisableWeather());
        MinecraftForge.EVENT_BUS.register(new PlayerNameChanger());
        MinecraftForge.EVENT_BUS.register(new AllowCheats());
        MinecraftForge.EVENT_BUS.register(new ThoriumChestplateMagnet());
    }
    public void postInit(FMLPostInitializationEvent e)
    {
        System.out.println("Starting Post Init");
        System.out.println("9+10=21");
    }
}
