package com.otis.LOTRDrp;

import com.otis.LOTRDrp.Client.Config.LOTRDrpConfig;
import com.otis.LOTRDrp.Util.LOTRDrpUpdateChecker;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import net.minecraft.client.Minecraft;

import java.util.Random;

public class LOTRDrpEventHandler {


    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void connectedToServer(FMLNetworkEvent.ClientConnectedToServerEvent e) {
        LOTRDrpUpdateChecker.reloadUpdateCheck();
        LOTRDrpMain.drp.discord.updateTimestamp();

        if (!e.isLocal && LOTRDrpConfig.cfgEnableServers) {

            if (Minecraft.getMinecraft().func_147104_D().serverIP.equalsIgnoreCase("148.251.40.254:25652") || Minecraft.getMinecraft().func_147104_D().serverIP.equalsIgnoreCase("harda.tournier.org:25575")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages("harda", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("It's A hArda World", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "It's A hArda World",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Harda Theme");

            } else
                if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("lotr.mine.bz")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages("serv", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("LOTR Survival", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "LOTR Survival",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Flame Theme");

            } else
                if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("fow.amuzil.com")) {
                    LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                    LOTRDrpMain.drp.discord.updateImages("flames", LOTRDrpMain.theme);
                    LOTRDrpMain.drp.discord.updateText("Flames of War", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                    LOTRDrpMain.drp.discord.updateState(
                            "Flames of War",
                            Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                    );
                    LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Flame Theme");

                }else
                    if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("96.43.140.122:25625")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages("dt", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("Dark Times", "Playing Server Dark Times");
                LOTRDrpMain.drp.discord.updateState(
                        "Dark Times",
                       "**********************"

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Dt Theme Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.equalsIgnoreCase("trop.g.akliz.net")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages("trop", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("The Ring of Power", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "The Ring of Power",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Trop Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("kpabr.com")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages("time", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("The Timeless Halls", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "The Timeless Halls",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To The Timeless Halls Theme");

            } else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("lotr.g.akliz.net")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages("tos", LOTRDrpMain.theme);
                LOTRDrpMain.drp.discord.updateText("LOTR Mod: Official Server", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "LOTR Mod: Official Server",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );




            }else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("gatesoftheeast.g.akliz.net")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
                LOTRDrpMain.drp.discord.updateImages(null, "gote");
                LOTRDrpMain.drp.discord.updateText("Gate Of The East", "Playing Server " + Minecraft.getMinecraft().func_147104_D().serverIP.toString());
                LOTRDrpMain.drp.discord.updateState(
                        "Gates Of The East",
                        Minecraft.getMinecraft().func_147104_D().serverIP.toString()

                );
                LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "'s Pressence Is Now Set To GOTE Theme");




            }else if (Minecraft.getMinecraft().func_147104_D().serverIP.contains("54.39.28.42")||Minecraft.getMinecraft().func_147104_D().serverIP.contains("54.39.28.42:25566")||Minecraft.getMinecraft().func_147104_D().serverIP.contains("54.39.28.42:25566")) {
                LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
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
        Random rand = new Random();
        LOTRDrpConfig.themeNo = rand.nextInt(LOTRDrpConfig.allThemesId.length) + 1;
        if(LOTRDrpMain.drp.isPlayingOnSupportedServer())


        LOTRDrpMain.drp.setPlayingOnSupportedServer(false);


        LOTRDrpMain.drp.discord.updateTimestamp();

        LOTRDrpMain.drp.discord.updateState("In Menu IGN:"+ Minecraft.getMinecraft().getSession().getUsername(), "LOTR Mod "+ LOTRDrpConnector.v);
        LOTRDrpMain.drp.discord.updateText("","Snazzy Presence Brought To You By LOTR Drp!");
        LOTRDrpMain.drp.discord.updateImages("","simple");
    }

}