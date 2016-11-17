package com.rocker1337.dab;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

public class ConfigHandler {

    public static Configuration config;

    //Settings
    public static boolean chestplateMagnet;
    public static int swordxpmultiplier;
    public static boolean multitoolaoemining;
    public static float thoriumleggingstepassist;
    public static boolean noTallGrass;

    public static void init(File file)
    {
        if(config == null)
        {
            config = new Configuration(file);
            syncConfig();
        }
    }

    public static void syncConfig()
    {
        chestplateMagnet = config.getBoolean("Thorium Chestplate Item Magnet", CATEGORY_GENERAL, true, "True to enable magnet");
        swordxpmultiplier = config.getInt("Thorium Sword & Shickaxe XP Multiplier", CATEGORY_GENERAL, 2, 1, 2147483647, "This is the XP multiplier when a player is holding the Thorium Sword");
        multitoolaoemining = config.getBoolean("Shickaxe Ore AOE Mining", CATEGORY_GENERAL, true, "When you click all ores around you get mined and put into inventory");
        thoriumleggingstepassist = config.getFloat("Thorium Legging Step Assist Height", CATEGORY_GENERAL, 1.0F, 0F, 2147483647F, "How many blocks you can go up without jumping");
        noTallGrass = config.getBoolean("Generate Tall Grass (Requires Restart Of Minecraft)", CATEGORY_GENERAL, true, "This will turn off the generation of tall and doubble tall grass (You can still use bonemeal)");
        if(config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.getModID().equalsIgnoreCase(Reference.MODID))
        {
            syncConfig();
        }

    }
}
