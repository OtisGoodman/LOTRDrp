package com.otis.LOTRDrp.Util;

import com.otis.LOTRDrp.LOTRDrpConnector;
import com.otis.LOTRDrp.LOTRDrpMain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import static com.otis.LOTRDrp.LOTRDrpMain.LOG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UtilGetSeason {
    private static String seasonUrl;
    protected static boolean checkedseason;
    public static boolean isSeason;
    public static String seasonId ;
    public static void getSeason() {
        if (!checkedseason) {
            final Thread checkThread = new Thread("Checker") {
                public void run() {
                    try {
                        LOG.info("Checking Season");
                        final URL url = new URL(seasonUrl);
                        final BufferedReader seasonReader = new BufferedReader(new InputStreamReader(url.openStream()));
                        String season = "";
                        String line;
                        while ((line = seasonReader.readLine()) != null) {
                            season = season.concat(line);
                        }
                        if (season.contains("true")){
                            isSeason = true;
                            seasonId = "season";
                            LOTRDrpMain.LOG.info("Found Season");
                        }else {
                            LOTRDrpMain.LOG.info("No Season Found");

                            return;
                        }

                        seasonReader.close();
                        season = season.trim();




                    } catch (Exception e) {
                        LOTRDrpMain.LOG.error("Season Check Failed");
                        e.printStackTrace();
                    }
                }
            };
            checkThread.setDaemon(checkedseason = true);
            checkThread.start();
        }
    }
    static {
        seasonUrl = "https://dl.dropboxusercontent.com/s/2uhkzfogyh97v25/SEASON_DRP.txt";
        checkedseason = false;
    }
}
