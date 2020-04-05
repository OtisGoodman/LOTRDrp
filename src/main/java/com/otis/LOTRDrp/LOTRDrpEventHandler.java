package com.otis.LOTRDrp;

import com.otis.LOTRDrp.Client.Config.LOTRDrpConfig;
import com.otis.LOTRDrp.Servers.LOTRDrpServers;
import com.otis.LOTRDrp.Servers.LOTRDrpSupportedServerHandler;
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

        if (LOTRDrpConfig.cfgEnableServers && !e.isLocal) {
         LOTRDrpSupportedServerHandler.handleServerJoin(Minecraft.getMinecraft().func_147104_D().serverIP, e);
        }else {
        	 if (e.isLocal) {
        		 LOTRDrpSupportedServerHandler.handleSPJoin();
        	 }
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