package com.otis.LOTRDrp;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordEventHandlers.OnReady;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

public class LOTRDrpConnector {

	private static final String APP_ID = "432578629461999636";
    public static boolean EnableDrp;
	private DiscordRPC lib;
	private DiscordEventHandlers handlers;
    public static  String v = "";
    private DiscordRichPresence presence;


    public LOTRDrpConnector() {
		
		lib = DiscordRPC.INSTANCE;
		handlers = new DiscordEventHandlers();
		
		handlers.ready = new OnReady() {
			@Override
			public void accept() {
				com.otis.LOTRDrp.LOTRDrpMain.OTISLog("LOTR Drp Is Ready!");


			}

		};
		
		if (EnableDrp){
            lib.Discord_Initialize(APP_ID, handlers, true, "");
        }

		
		presence = new DiscordRichPresence();
		presence.startTimestamp = System.currentTimeMillis() / 1000;
		presence.largeImageKey = "simple";
		presence.details = "LOTR Mod V"+ v;
		presence.state = "In Menu IGN:"+ Minecraft.getMinecraft().getSession().getUsername();
		presence.largeImageText = "Snazzy Presence Brought To You By LOTR Drp!";
		lib.Discord_UpdatePresence(presence);
		
	}
	
	public void run() {
		new Thread("RPC-Callback-Handler") {
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					lib.Discord_UpdatePresence(presence);
					lib.Discord_RunCallbacks();
					try {
						Thread.sleep(2000);
					} catch(InterruptedException ignored) {}
				}
			}
		}.start();
	}
	
	public void updateTimestamp() {
		presence.startTimestamp = System.currentTimeMillis() / 1000;
	}
	public void updateTimestamp(long timestamp) {
		presence.startTimestamp = timestamp;
	}
	public void updateState(String state, String details) {
		presence.state = state;
		presence.details = details;
	}
    public void updateText(String small, String large) {
        presence.largeImageText = large;
        presence.smallImageText = small;
    }
    public void updateImages(String small, String large) {
       presence.largeImageKey = large;
       presence.smallImageKey = small;
    }
	
}
