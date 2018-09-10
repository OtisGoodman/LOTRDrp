package com.otis.LOTRDrp;

import com.otis.LOTRDrp.Client.LOTRDrpClientProxy;
import com.otis.LOTRDrp.Commands.CommandCheckForUpdates;
import com.otis.LOTRDrp.Util.UtilGetLOTRVersion;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = LOTRDrpMain.MODID, version = LOTRDrpMain.VERSION, name = LOTRDrpMain.NAME, canBeDeactivated = true,acceptedMinecraftVersions = "1.7.10")
public class LOTRDrpMain {
    @SidedProxy(clientSide = "com.otis.LOTRDrp.Client.LOTRDrpClientProxy")
    public static LOTRDrpClientProxy proxy;
    public static final String MODID = "lotrdrp";
    public static final String VERSION = "1.3";
    public static final String NAME = "LOTR Drp";

    private static LOTRDrpConfig config ;
    @Mod.Instance
    public static LOTRDrpMain drp = new LOTRDrpMain();

    public LOTRDrpConnector discord;
    private boolean playingOnFest = false;
    private boolean playingOnFellowships= false;
    private boolean playingOnFlames= false;
    private boolean playingOnTime= false;
    private boolean playingOnBfme= false;
    private boolean playingOnTos= false;
    private boolean playingOnSecond= false;
    protected static String theme = "";





        @Mod.EventHandler
        public void preInit (FMLPreInitializationEvent event){
            UtilGetLOTRVersion.getLotrV();
            config.loadConfig(event);

        LOTRDrpEventHandler handler = new LOTRDrpEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
        OTISLog("Thanks For Using LOTR Drp V"+VERSION);
            proxy.preload();
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
    }



    public static void OTISLog (String text){
        System.out.println("[LOTR Drp] "+text);
    }
///List Of Supported Servers
    public void setPlayingOnFest(boolean b) {
        this.playingOnFest = b;
    }

    public boolean isPlayingOnFest() {
        return this.playingOnFest;
    }
    public void setPlayingOnFellowships(boolean b) {
        this.playingOnFellowships= b;
    }

    public boolean isPlayingOnFellowships() {
        return this.playingOnFellowships;
    }

    public void setPlayingOnFlames(boolean b) {
        this.playingOnFlames= b;
    }

    public boolean isPlayingOnFlames() {
        return this.playingOnFlames;
    }

    public void setPlayingOnTime(boolean b) {
        this.playingOnTime= b;
    }

    public boolean isPlayingOnTime() {
        return this.playingOnTime;
    }



    public void setPlayingOnBfme(boolean b) {
        this.playingOnBfme= b;
    }

    public boolean isPlayingOnBfme() {
        return this.playingOnBfme;
    }

    public void setPlayingOnTos(boolean b) {
        this.playingOnTos= b;
    }

    public boolean isPlayingOnTos() {
        return this.playingOnTos;
    }

    public void setPlayingOnSecond(boolean b) {
        this.playingOnSecond= b;
    }

    public boolean isPlayingOnSecond() {
        return this.playingOnSecond;
    }

    }


