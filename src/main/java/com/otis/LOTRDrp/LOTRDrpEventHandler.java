package com.otis.LOTRDrp;

import com.otis.LOTRDrp.Client.Config.LOTRDrpConfig;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import net.minecraft.client.Minecraft;

public class LOTRDrpEventHandler {


    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void connectedToServer(FMLNetworkEvent.ClientConnectedToServerEvent e) {
        LOTRDrpUpdateChecker.reloadUpdateCheck();
        LOTRDrpMain.drp.discord.updateTimestamp();

        if (!e.isLocal && LOTRDrpConfig.cfgEnableServers) {

            if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("LOTRFestive.beastmc.com")) {
                LOTRDrpMain.drp.setPlayingOnFest(true);
                LOTRDrpMain.drp.discord.updateImages("fest", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("Festivals Of Middle Earth", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "Festivals Of Middle Earth",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Fest Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("fow.amuzil.com")) {
                LOTRDrpMain.drp.setPlayingOnFlames(true);
                LOTRDrpMain.drp.discord.updateImages("flames", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("Flames of War", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "Flames of War",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Flame Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("fellowships.g.akliz.net")) {
                LOTRDrpMain.drp.setPlayingOnFellowships(true);
                LOTRDrpMain.drp.discord.updateImages("fellowships", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("Fellowships of Middle-Earth", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "Fellowships of Middle-Earth",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Fellowships Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("kpabr.com")) {
                LOTRDrpMain.drp.setPlayingOnTime(true);
                LOTRDrpMain.drp.discord.updateImages("time", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("The Timeless Halls", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "The Timeless Halls",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Timeless Halls Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("lotr.g.akliz.net")) {
                LOTRDrpMain.drp.setPlayingOnTos(true);
                LOTRDrpMain.drp.discord.updateImages("tos", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("LOTR Mod: Official Server", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "LOTR Mod: Official Server",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );




            }else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("gatesoftheeast.g.akliz.net")) {
                LOTRDrpMain.drp.setPlayingOnTos(true);
                LOTRDrpMain.drp.discord.updateImages(null, "gote");
                LOTRDrpMain.drp.discord.updateText("Gate Of The East", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "Gates Of The East",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To GOTE Theme");




            }else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("54.39.28.42")||Minecraft.getMinecraft().func_147104_D().serverIP.contains("54.39.28.42:25566")||Minecraft.getMinecraft().func_147104_D().serverIP.contains("54.39.28.42:25566")) {
                LOTRDrpMain.drp.setPlayingOnSecond(true);
                LOTRDrpMain.drp.discord.updateImages("second", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("The Second Server That Wont Rule Anything", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "The Second Server That Wont Rule Anything",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );

                              LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To Second Server Theme");


            }else
                if (!e.isLocal) {
                    LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
                    LOTRDrpMain.drp.discord.updateText("", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                    LOTRDrpMain.drp.discord.updateState(
                            "On: " + Minecraft.getMinecraft().func_147104_D().serverIP.toString(),
                            "Playing On An Unknown Server ");
                    LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To Playing On " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());

                } else {
                    LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
                    LOTRDrpMain.drp.discord.updateText("", "Singleplayer");
                    LOTRDrpMain.drp.discord.updateState(
                            "On: " + Minecraft.getMinecraft().getIntegratedServer().getWorldName(),
                            "Playing Singleplayer"
                    );
                    LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To Singleplayer");

                }
            }else if (!e.isLocal) {
                LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("", "Playing Server " +Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "On: " + Minecraft.getMinecraft().func_147104_D().serverIP.toString(),
                        "Playing On An Unknown Server ");
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To Playing On " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());

            } else {
                LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("", "Singleplayer");
                LOTRDrpMain.drp.discord.updateState(
                            "On: " + Minecraft.getMinecraft().getIntegratedServer().getWorldName(),
                        "Playing Singleplayer"
                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To Singleplayer");

            }
        }
    @SubscribeEvent
    public void disconnectedFromServer(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
        if(LOTRDrpMain.drp.isPlayingOnFest())
            if(LOTRDrpMain.drp.isPlayingOnFellowships())
                if(LOTRDrpMain.drp.isPlayingOnFlames())
                    if(LOTRDrpMain.drp.isPlayingOnTime())
                        if(LOTRDrpMain.drp.isPlayingOnTos())
                            if(LOTRDrpMain.drp.isPlayingOnBfme())
                                if(LOTRDrpMain.drp.isPlayingOnGote())

        LOTRDrpMain.drp.setPlayingOnFest(false);
        LOTRDrpMain.drp.setPlayingOnGote(false);

        LOTRDrpMain.drp.setPlayingOnFellowships(false);
        LOTRDrpMain.drp.setPlayingOnFlames(false);
        LOTRDrpMain.drp.setPlayingOnFest(false);
        LOTRDrpMain.drp.setPlayingOnTos(false);
        LOTRDrpMain.drp.setPlayingOnBfme(false);
        LOTRDrpMain.drp.setPlayingOnSecond(false);

        LOTRDrpMain.drp.discord.updateTimestamp();

        LOTRDrpMain.drp.discord.updateState("In Menu IGN:"+ Minecraft.getMinecraft().getSession().getUsername(), "LOTR Mod "+ LOTRDrpConnector.v);
        LOTRDrpMain.drp.discord.updateText("","Snazzy Presence Brought To You By LOTR Drp!");
        LOTRDrpMain.drp.discord.updateImages("","simple");
    }

}