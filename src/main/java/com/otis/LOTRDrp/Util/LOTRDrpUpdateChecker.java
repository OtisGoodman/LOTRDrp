package com.otis.LOTRDrp.Util;
import com.otis.LOTRDrp.LOTRDrpMain;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
public class LOTRDrpUpdateChecker {

    private static String versionURL;
    protected static boolean checkedUpdate;
    public static void reloadUpdateCheck(){
    checkedUpdate = false;
    }
    public static void checkForUpdates() {
        if (!checkedUpdate) {
            final Thread checkThread = new Thread("LOTR Drp Update Checker") {
                public void run() {
                    try {
                        final URL url = new URL(versionURL);
                        final BufferedReader updateReader = new BufferedReader(new InputStreamReader(url.openStream()));
                        String updateVersion = "";
                        String line;
                        while ((line = updateReader.readLine()) != null) {
                            updateVersion = updateVersion.concat(line);
                        }
                        updateReader.close();
                        updateVersion = updateVersion.trim();
                        final String currentVersion = LOTRDrpMain.VERSION;
                       if (LOTRDrpMain.isDevBuild){
                           final IChatComponent devBuild = new ChatComponentText(
                                   "[LOTR Drp Update Checker] You Running A Dev Build! "+currentVersion);

                           devBuild.getChatStyle().setColor(EnumChatFormatting.DARK_PURPLE);
                           final EntityPlayer entityplayer = Minecraft.getMinecraft().thePlayer;

                           if (entityplayer != null) {
                               entityplayer.addChatComponentMessage(devBuild);
                           }
                       }else if (!updateVersion.equals(currentVersion)) {
                            final IChatComponent newUpdate = new ChatComponentText(
                                    "[LOTR Drp Update Checker] Update Available! "+updateVersion +" Click Here To Download The Latest Update");

                            newUpdate.getChatStyle().setColor(EnumChatFormatting.DARK_RED);
                            newUpdate.getChatStyle().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Check Out Our Wiki And Download The Latest Version Here!")));
                            newUpdate.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://lotrdrp.us.to/download.html"));
                            final EntityPlayer entityplayer = Minecraft.getMinecraft().thePlayer;

                            if (entityplayer != null) {
                            entityplayer.addChatComponentMessage(newUpdate);
                            }

                        }else{
                            final IChatComponent upToDate = new ChatComponentText(
                                    "[LOTR Drp Update Checker] LOTR Drp Is Up To Date!");

                            upToDate.getChatStyle().setColor(EnumChatFormatting.DARK_GREEN);
                            final EntityPlayer entityplayer = Minecraft.getMinecraft().thePlayer;

                            if (entityplayer != null) {
                                entityplayer.addChatComponentMessage(upToDate);
                            }


                        }
                    } catch (Exception e) {
                       LOTRDrpMain.OTISLog("Update Check Failed");
                        e.printStackTrace();
                    }
                }
            };
            checkThread.setDaemon(checkedUpdate = true);
            checkThread.start();
        }
    }

    static {
        versionURL = "https://dl.dropboxusercontent.com/s/emo7zxrfp86lvpz/VERSION_DRP.txt";
        checkedUpdate = false;
    }
    }


