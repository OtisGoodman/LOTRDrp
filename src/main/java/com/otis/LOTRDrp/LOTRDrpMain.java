package com.otis.LOTRDrp;

import com.otis.LOTRDrp.Client.LOTRDrpClientProxy;
import com.otis.LOTRDrp.Client.Config.LOTRDrpConfig;
import com.otis.LOTRDrp.Util.UtilGetLOTRVersion;
import com.otis.LOTRDrp.Util.UtilGetSeason;
import com.otis.LOTRDrp.Util.UtilRemoveHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


@Mod(modid = LOTRDrpMain.MODID, version = LOTRDrpMain.VERSION, name = LOTRDrpMain.NAME, acceptedMinecraftVersions = "1.7.10", guiFactory = "com.otis.LOTRDrp.Client.Config.LOTRDrpGui")
public class LOTRDrpMain {
    @SidedProxy(clientSide = "com.otis.LOTRDrp.Client.LOTRDrpClientProxy")
    public static LOTRDrpClientProxy proxy;
    public static File configDir;
    public static final String MODID = "lotrdrp";
    public static final String VERSION = "1.5.1";
    public static Boolean isDevBuild = false;
    public static final String NAME = "LOTR Drp";
    @Mod.Instance
    public static LOTRDrpMain drp = new LOTRDrpMain();
    public LOTRDrpConnector discord;
    private boolean playingOnSupportedServer = false;


    public static String theme = "";
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        UtilGetSeason.getSeason();
        UtilGetLOTRVersion.getLotrV();
        LOTRDrpEventHandler handler = new LOTRDrpEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
        OTISLog("Thanks For Using LOTR Drp V" + VERSION);
        proxy.preload();
        String cfgDir = event.getModConfigurationDirectory().toString();
        LOTRDrpConfig.init(cfgDir);
        FMLCommonHandler.instance().bus().register(new LOTRDrpConfig());
        UtilRemoveHandler.removeOldConfig(event);
        configDir = event.getModConfigurationDirectory();


}





    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        discord = new LOTRDrpConnector();
        discord.run();
        proxy.postload();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.load();
       if (UtilGetSeason.isSeason){
           theme = UtilGetSeason.seasonId;
       }

    }


    public static void OTISLog(String text) {
        System.out.println("[LOTR Drp] " + text);
        if (LOTRDrpConfig.enableIngameLoging) {
            Timer timer = new Timer();

            timer.schedule(new TimerTask() {

                public void run() {
                    final IChatComponent log = new ChatComponentText(
                            text);
                    log.getChatStyle().setItalic(true);

                    log.getChatStyle().setColor(EnumChatFormatting.GRAY);
                    final EntityPlayer entityplayer = Minecraft.getMinecraft().thePlayer;

                    if (entityplayer != null) {
                        entityplayer.addChatComponentMessage(log);
                    }
                }
            }, 10*1000);//perform run() for 5 seconds

        }
        }






    ///List Of Supported Servers
    public void setPlayingOnSupportedServer(boolean b) {
        this.playingOnSupportedServer = b;
    }

    public boolean isPlayingOnSupportedServer() {
        return this.playingOnSupportedServer;
    }


}



