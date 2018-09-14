package com.otis.LOTRDrp.Client;

import com.otis.LOTRDrp.Client.Config.LOTRDrpConfig;
import com.otis.LOTRDrp.LOTRDrpUpdateChecker;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

public class LOTRDrpClientTickHandler {



    LOTRDrpClientTickHandler() {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onPreRenderGameOverlay(RenderGameOverlayEvent.Pre event) {

        if (LOTRDrpConfig.enableVersionCheck) {
        LOTRDrpUpdateChecker.checkForUpdates();
        }
    }
}

