package com.rocker1337.dab.proxy;

import com.rocker1337.dab.ConfigHandler;
import com.rocker1337.dab.events.*;
import com.rocker1337.dab.helper.FuelHandler;
import com.rocker1337.dab.init.SoundEvents.RegisterSoundEvents;
import com.rocker1337.dab.init.TileEntity.InitTile;
import com.rocker1337.dab.init.blocks.DABBlocks;
import com.rocker1337.dab.init.crafting.DABCrafting;
import com.rocker1337.dab.init.items.DABItems;
import com.rocker1337.dab.init.items.thoriumpickaxe;
import com.rocker1337.dab.world.DabWorldGen;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vazkii.botania.api.BotaniaAPI;


public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        System.out.println("Starting Pre Init");
        //Init and Register Items
        DABItems.init();
        DABItems.register();
        //Init and Register Blocks
        DABBlocks.init();
        DABBlocks.register();
        //Init Sounds
        RegisterSoundEvents.init();
        //Init Fuel
        GameRegistry.registerFuelHandler(new FuelHandler());

    }
    public void init(FMLInitializationEvent e)
    {
        System.out.println("Starting Init");
        DABItems.setCreativeTab();
        DABBlocks.setCreativeTab();
        DABCrafting.initCrafting();
        achievementCreativeKill.registerStat();
        achievementSamsungExplode.registerStat();
        GameRegistry.registerWorldGenerator(new DabWorldGen(), 0);
        MinecraftForge.EVENT_BUS.register(new StrengthSword());
        MinecraftForge.EVENT_BUS.register(new SuperEvent());
        MinecraftForge.EVENT_BUS.register(new Gamerules());
        MinecraftForge.EVENT_BUS.register(new DisableWeather());
        MinecraftForge.EVENT_BUS.register(new PlayerNameChanger());
        MinecraftForge.EVENT_BUS.register(new AllowCheats());
        MinecraftForge.EVENT_BUS.register(new ThoriumChestplateMagnet());
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new thoriumpickaxe());
        MinecraftForge.EVENT_BUS.register(new FastFlyBreak());
        MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainEventHandler());
        //Init Tile
        InitTile.init();

        AchievementPage.registerAchievementPage(new AchievementPage("DAB Achievements", new Achievement[] {CommonProxy.achievementCreativeKill, CommonProxy.achievementSamsungExplode}));
        DABItems.registerOreDict();

        System.out.println("Checking If Botania is installed");
        if (Loader.isModLoaded("Botania"))
        {
            System.out.println("Botania has been detected");
            loadBotania();
        }
        else
        {
            System.out.println("Botania has not been detected");
        }
    }
    public void postInit(FMLPostInitializationEvent e)
    {
        System.out.println("Starting Post Init");
        System.out.println("9+10=21");
    }

    //Achivements
    public static Achievement achievementCreativeKill = new Achievement("achievements.creative_kill", "creative_kill", 1, 1, new ItemStack(DABItems.thoriumsword), (Achievement)null);
    public static Achievement achievementSamsungExplode = new Achievement("achievements.samsung_explode", "samsung_explode", 3, 1, new ItemStack(DABItems.samsungs7), (Achievement)null);

    //Optional Methods
    @Optional.Method(modid = "Botania")
    private void loadBotania()
    {
        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(DABItems.ThoriumCoal), new ItemStack(Blocks.COAL_BLOCK), 1000000);
        BotaniaAPI.registerRuneAltarRecipe(new ItemStack(DABItems.ThoriumCoal), 250000, new Object[]{new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.COAL_BLOCK)});
    }
}
