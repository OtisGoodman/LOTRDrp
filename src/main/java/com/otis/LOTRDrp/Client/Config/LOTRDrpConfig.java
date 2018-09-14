package com.otis.LOTRDrp.Client.Config;

import com.otis.LOTRDrp.LOTRDrpMain;
import com.otis.LOTRDrp.Util.UtilRemoveHandler;
import cpw.mods.fml.client.config.IConfigElement;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.common.LOTRConfig;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import static com.otis.LOTRDrp.LOTRDrpMain.OTISLog;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LOTRDrpConfig {


    public static Configuration config;
    public static String cfgVersion;
    public static boolean cfgEnableServers;
    public static boolean cfgEnableDrp;
    public static boolean enableVersionCheck;

    public static String theme;



    public static void init(String cfgDir) {

        if (config == null) {
            File path = new File(cfgDir + "/" + LOTRDrpMain.MODID + ".cfg");
            config = new Configuration(path);
            loadConfig();
            OTISLog("Config Inited");
        }
    }


private static void loadConfig (){
   ///     cfgVersion = config.getString("Config File Version",Configuration.CATEGORY_GENERAL,LOTRDrpMain.VERSION,"PLEASE DON'T MESS WITH THIS!!!!");
    cfgEnableServers = config.getBoolean("Enable Server Icons",Configuration.CATEGORY_GENERAL,true,"If This Is On It Will Display Custom Server Icons And Text");
    enableVersionCheck = config.getBoolean("Enable Version Check",Configuration.CATEGORY_GENERAL,true,"If This Is Off The Version Checker Will Not Run");

    cfgEnableDrp = config.getBoolean("Enable Presence",Configuration.CATEGORY_GENERAL,true,"If This Is Off The Discord Ritch Presence  Will Not Display");
    theme = config.getString("DRP Theme",Configuration.CATEGORY_GENERAL,"default","Themes default,pvp,book,quest,smoke-ship");


        if (config.hasChanged()){
            config.save();
           OTISLog("Config Saved");
        }



    if (theme.equalsIgnoreCase("default")) {
        com.otis.LOTRDrp.LOTRDrpMain.theme = "minecraft-lord-of-the-rings-mod";
        com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To default");
    }else
    if (theme.equalsIgnoreCase("pvp")) {
        com.otis.LOTRDrp.LOTRDrpMain.theme = "pvp";
        com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To pvp");

    }else
    if (theme.equalsIgnoreCase("book")) {
        com.otis.LOTRDrp.LOTRDrpMain.theme = "book";
        com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To book");

    }else
    if (theme.equalsIgnoreCase("quest")) {
        com.otis.LOTRDrp.LOTRDrpMain.theme = "quest";
        com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To quest");

    }else
    if (theme.equalsIgnoreCase("smoke-ship")) {
        com.otis.LOTRDrp.LOTRDrpMain.theme = "smokeship";
        com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To smokeship");

    }else {
        com.otis.LOTRDrp.LOTRDrpMain.theme = "minecraft-lord-of-the-rings-mod";
        com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Invalid Theme");

    }


}



   @SubscribeEvent
    public void onCfgChnageEvent (ConfigChangedEvent.OnConfigChangedEvent event){
    if (event.modID.equalsIgnoreCase(LOTRDrpMain.MODID)){
        loadConfig();
        OTISLog("Config Has Been Changed");
    }


   }

public static Configuration getConfig(){
        return config;
}



    }





