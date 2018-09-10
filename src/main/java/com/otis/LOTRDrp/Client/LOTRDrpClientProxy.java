package com.otis.LOTRDrp.Client;

import com.otis.LOTRDrp.Commands.CommandCheckForUpdates;
import net.minecraftforge.client.ClientCommandHandler;

public class LOTRDrpClientProxy {


        public static LOTRDrpClientTickHandler tickHandler = new LOTRDrpClientTickHandler();

        public void preload() {

        }
        public void postload() {

        }
        public void load() {
                ClientCommandHandler.instance.registerCommand(new CommandCheckForUpdates());

        }

}