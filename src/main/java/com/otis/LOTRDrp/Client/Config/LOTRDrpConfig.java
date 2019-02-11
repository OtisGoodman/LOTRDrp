package com.otis.LOTRDrp.Client.Config;

import com.otis.LOTRDrp.LOTRDrpMain;
import com.otis.LOTRDrp.Util.UtilGetSeason;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.common.LOTREventHandler;
import lotr.common.LOTRMod;
import net.minecraftforge.common.config.Configuration;

import javax.rmi.CORBA.Util;

import static com.otis.LOTRDrp.LOTRDrpMain.OTISLog;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

import static com.otis.LOTRDrp.LOTRDrpMain.theme;

public class LOTRDrpConfig {
    public static String[] allThemesId = {"minecraft-lord-of-the-rings-mod", "mithril", "pvp", "quest", "book", "smokeship", "fest", "coin", "horn", "truesilver", "kingsfoil", "compass","bounty"};

    private static String[] allThemes = {"default", "mithril", "pvp", "quest", "book", "smoke-ship", "pipe", "coin", "horn", "true-silver", "kings-foil", "compass", "random","bounty"};

    public static String getAllThemeNames() {

        return Arrays.toString(allThemes) + "random";
    }

    public static Configuration config;
    public static String cfgVersion;
    public static boolean cfgEnableServers;
    public static boolean cfgEnableDrp;
    public static boolean enableVersionCheck;
    public static boolean enableIngameLoging;
    public static boolean hasSeenChnagelog;

    public static String theme;
    public static Integer themeNo;

    public static void init(String cfgDir) {

        if (config == null) {
            File path = new File(cfgDir + "/LOTRDrp/" + LOTRDrpMain.MODID + ".cfg");
            config = new Configuration(path);
            loadConfig();
            OTISLog("Config Inited");

        }
    }


    private static void loadConfig() {
        ///     cfgVersion = config.getString("Config File Version",Configuration.CATEGORY_GENERAL,LOTRDrpMain.VERSION,"PLEASE DON'T MESS WITH THIS!!!!");
        cfgEnableServers = config.getBoolean("Enable Server Icons", Configuration.CATEGORY_GENERAL, true, "If This Is On It Will Display Custom Server Icons And Text");
        enableVersionCheck = config.getBoolean("Enable Version Check", Configuration.CATEGORY_GENERAL, true, "If This Is Off The Version Checker Will Not Run");

        cfgEnableDrp = config.getBoolean("Enable Presence", Configuration.CATEGORY_GENERAL, true, "If This Is Off The Discord Ritch Presence  Will Not Display");
        theme = config.getString("DRP Theme", Configuration.CATEGORY_GENERAL, "default", "Themes " + LOTRDrpConfig.getAllThemeNames());
        enableIngameLoging = config.getBoolean("Enable Ingame Loging", Configuration.CATEGORY_GENERAL, false, "If This Is On All Logs Will Be Show Up In Chat");


        if (theme != allThemes[0] || theme != (allThemes[1]) || theme != (allThemes[2]) || theme != (allThemes[3])
                || theme != (allThemes[4]) || theme != (allThemes[5]) || theme != (allThemes[6]) || theme != (allThemes[7])
                || theme != (allThemes[8]) || theme != (allThemes[9]) || theme != (allThemes[10]) || theme != (allThemes[11]) || theme != (allThemes[13]) || theme != (allThemes[14])) {
        }
        Random rand = new Random();
        themeNo = rand.nextInt(allThemesId.length);
        LOTRDrpMain.theme = "minecraft-lord-of-the-rings-mod";
        OTISLog("Invalid Theme " + theme);

        if (theme.equalsIgnoreCase("default")) {
            LOTRDrpMain.theme = "minecraft-lord-of-the-rings-mod";
            OTISLog("theme set to default");

        } else if (theme.equalsIgnoreCase("mithril")) {
            LOTRDrpMain.theme = "mithril";
            OTISLog("theme set to mithril");

        } else if (theme.equalsIgnoreCase("pvp")) {
            LOTRDrpMain.theme = "pvp";
            OTISLog("theme set to pvp");

        } else if (theme.equalsIgnoreCase("quest")) {
            LOTRDrpMain.theme = "quest";
            OTISLog("theme set to quest");

        } else if (theme.equalsIgnoreCase("kings-foil")) {
            LOTRDrpMain.theme = "kingsfoil";
            OTISLog("theme set to kings-foil");

        } else if (theme.equalsIgnoreCase("book")) {
            LOTRDrpMain.theme = "book";
            OTISLog("theme set to book");

        } else if (theme.equalsIgnoreCase("smoke-ship")) {
            LOTRDrpMain.theme = "smokeship";
            OTISLog("theme set to smoke-ship");

        }
        if (theme.equalsIgnoreCase("coin")) {
            LOTRDrpMain.theme = "coin";
            OTISLog("theme set to coin");

        } else if (theme.equalsIgnoreCase("pipe")) {
            LOTRDrpMain.theme = "fest";
            OTISLog("theme set to pipe");

        } else if (theme.equalsIgnoreCase("horn")) {
            LOTRDrpMain.theme = "horn";
            OTISLog("theme set to horn");

        } else if (theme.equalsIgnoreCase("compass")) {
            LOTRDrpMain.theme = "compass";
            OTISLog("theme set to compass");

        } else if (theme.equalsIgnoreCase("true-silver")) {
            LOTRDrpMain.theme = "truesilver";
            OTISLog("theme set to true-silver");
        } else if (theme.equalsIgnoreCase("random")) {
            LOTRDrpMain.theme = allThemesId[themeNo];
            OTISLog("theme set to random");
        }else if (theme.equalsIgnoreCase("bounty")) {
            LOTRDrpMain.theme = "bounty";
            OTISLog("theme set to bounty");
        }








    if(config.hasChanged())

    {
        config.save();
        OTISLog("Config Saved");
    }

}



    @SubscribeEvent
    public void onCfgChnageEvent (ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equals(LOTRDrpMain.MODID)){
            loadConfig();
            OTISLog("Config Has Been Changed");

        }


    }
    public static Configuration getConfig(){
        return config;
    }


}





