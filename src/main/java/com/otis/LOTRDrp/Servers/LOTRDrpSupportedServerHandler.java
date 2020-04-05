package com.otis.LOTRDrp.Servers;

import com.otis.LOTRDrp.LOTRDrpConnector;
import com.otis.LOTRDrp.LOTRDrpMain;
import com.otis.LOTRDrp.Client.Config.LOTRDrpConfig;

import cpw.mods.fml.common.network.FMLNetworkEvent;
import net.minecraft.client.Minecraft;

public class LOTRDrpSupportedServerHandler {

	public static void handleServerJoin(String ip,FMLNetworkEvent.ClientConnectedToServerEvent e) {
		LOTRDrpMain.OTISLog("handling srver join event!");
			if (e.isLocal) {
				handleSPJoin();
			}else {
				if (LOTRDrpServers.getServers().containsKey(ip)){
				handleSSJoin(ip);
			}else {
				 handleUSJoin(ip);
			}
		
		}
		}
	public static void handleSPJoin() {
		if (!LOTRDrpConfig.incognitoMode) {
		LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
        LOTRDrpMain.drp.discord.updateText("", "Singleplayer");
        LOTRDrpMain.drp.discord.updateState(
                "On: " + Minecraft.getMinecraft().getIntegratedServer().getWorldName(),
                "Playing Singleplayer"
        );
          LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "is playing on singleplayer");
	}else {
	handleIncognitoMode();	
	}
	}
	private static void handleIncognitoMode() {
		LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
        LOTRDrpMain.drp.discord.updateText("", "Incognito Mode");
        LOTRDrpMain.drp.discord.updateState(
                "Playing LOTR Mod" + LOTRDrpConnector.v,
                "Minecraft 1.7.10"
        );
          LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "Enabled Incognito Mode");
	}
	private static void handleSSJoin(String ip) {
		if (!LOTRDrpConfig.incognitoMode) {
		LOTRDrpMain.OTISLog("Found supported server!");
		ISupportedServer server = LOTRDrpServers.getServers().get(ip);
		  LOTRDrpMain.drp.setPlayingOnSupportedServer(true);
          LOTRDrpMain.drp.discord.updateImages(server.iconName(), LOTRDrpMain.theme);
          LOTRDrpMain.drp.discord.updateText(server.name(), "Playing Server " + server.ip());
          LOTRDrpMain.drp.discord.updateState(
                  server.name(),
                  server.ip()

          );

          LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "is playing on "+server.name());
	}else {
	handleIncognitoMode();	
	}
	}
	private static void handleUSJoin(String ip) {
		if (!LOTRDrpConfig.incognitoMode) { 
		LOTRDrpMain.drp.discord.updateImages("", LOTRDrpMain.theme);
          LOTRDrpMain.drp.discord.updateText("", "Playing Server " +ip);
          LOTRDrpMain.drp.discord.updateState(
                  "On: " + ip,
                  "Playing On An Unknown Server ");
            LOTRDrpMain.OTISLog(Minecraft.getMinecraft().getSession().getUsername() + "is playing on a server with the ip of "+ip);
	}else {
		handleIncognitoMode();
	}
	}
	}


