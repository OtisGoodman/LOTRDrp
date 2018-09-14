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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UtilGetLOTRVersion {
    private static String versionURL;
    protected static boolean checkedVersion;
    public static void getLotrV() {
        if (!checkedVersion) {
            final Thread checkThread = new Thread("Checker") {
                public void run() {
                    try {
                        final URL url = new URL(versionURL);
                        final BufferedReader versionReader = new BufferedReader(new InputStreamReader(url.openStream()));
                        String lotrVersion = "";
                        String line;
                        while ((line = versionReader.readLine()) != null) {
                            lotrVersion = lotrVersion.concat(line);
                        }
                        versionReader.close();
                        lotrVersion = lotrVersion.trim();

                        LOTRDrpConnector.v = " "+lotrVersion;

                    
                    } catch (Exception e) {
                        LOTRDrpMain.OTISLog("LOTR Version Check Failed");
                        e.printStackTrace();
                    }
                }
            };
            checkThread.setDaemon(checkedVersion = true);
            checkThread.start();
        }
    }

    static {
        versionURL = "https://dl.dropboxusercontent.com/s/mhulh7fd9ek1d67/VERSION_LOTR.txt";
        checkedVersion = false;
    }
}
