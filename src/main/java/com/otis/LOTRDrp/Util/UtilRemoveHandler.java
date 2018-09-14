package com.otis.LOTRDrp.Util;

import com.google.common.base.Charsets;
import com.otis.LOTRDrp.LOTRDrpMain;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import static com.otis.LOTRDrp.LOTRDrpMain.OTISLog;


public class UtilRemoveHandler {
    public static void removeOldConfig(FMLPreInitializationEvent event) {
        File oldconfig = new File(event.getModConfigurationDirectory(), "LOTRDrpCfg.txt");
        if (oldconfig.exists()) {
            oldconfig.deleteOnExit();
            OTISLog("Removed Old Config File");
        }


    }

    public static void resetConfig(FMLPreInitializationEvent event) {
        File config = new File(event.getModConfigurationDirectory(), LOTRDrpMain.MODID+".cfg");
        if (config.exists()) {
            config.deleteOnExit();
            OTISLog("Reset Config File");
        }

    }
}