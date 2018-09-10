package com.otis.LOTRDrp;

import java.io.*;


import net.minecraftforge.common.MinecraftForge;

import com.google.common.base.Charsets;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class LOTRDrpConfig {

    public LOTRDrpConfig() {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void loadConfig(FMLPreInitializationEvent event) {
        File config = new File(event.getModConfigurationDirectory(), "LOTRDrpCfg.txt");
        if (config.exists()) {
            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Reading Config File...");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(config), Charsets.UTF_8.name()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("#")) {
                        continue;
                    }

                    if (line.startsWith("[Enable-Servers]")) {
                        if (line.endsWith("True")) {
                            LOTRDrpEventHandler.enableServers = true;
                            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Enabled Servers");
                        } else {
                            LOTRDrpEventHandler.enableServers = false;
                            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Disabled Servers");
                        }

                    }
                    if (line.startsWith("[Enable-Drp]")) {
                        if (line.endsWith("True")) {
                            LOTRDrpConnector.EnableDrp = true;
                            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Enabled Drp");
                        } else {
                            LOTRDrpConnector.EnableDrp = false;
                            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Disabled Drp");
                        }

                    }

                        if (line.startsWith("[Theme]")) {
                            if (line.endsWith("default")) {
                                com.otis.LOTRDrp.LOTRDrpMain.theme = "minecraft-lord-of-the-rings-mod";
                                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To default");
                            }
                            if (line.endsWith("pvp")) {
                                com.otis.LOTRDrp.LOTRDrpMain.theme = "pvp";
                                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To pvp");

                            }
                            if (line.endsWith("book")) {
                                com.otis.LOTRDrp.LOTRDrpMain.theme = "book";
                                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To book");

                            }
                            if (line.endsWith("quest")) {
                                com.otis.LOTRDrp.LOTRDrpMain.theme = "quest";
                                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To quest");

                            }
                            if (line.endsWith("kebab")) {
                                com.otis.LOTRDrp.LOTRDrpMain.theme = "kebab";
                                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To kebab");

                            }
                            if (line.endsWith("smoke-ship")) {
                                com.otis.LOTRDrp.LOTRDrpMain.theme = "smokeship";
                                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Theme Set To smokeship");

                            }
                        }


                    if (line.startsWith("[File Version]")) {
                        if (line.endsWith(LOTRDrpMain.VERSION)) {
                            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Config File Up To Date");
                        } else {
                            com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Config File Is Not Up To Date\nForcing File Reset!");
                           config.deleteOnExit();
                        }

                    }




                }

                reader.close();
            } catch (IOException e) {
                LOTRDrpMain.OTISLog("Uho There Seems To Be A Config Problem");
                e.printStackTrace();
            }
        } else {
            try {
                config.createNewFile();
                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("Creating Config File...");
                PrintStream writer = new PrintStream(new FileOutputStream(config));

                writer.println("# LOTR Drp Config File");
                writer.println("#");
                writer.println("[File Version] = "+  com.otis.LOTRDrp.LOTRDrpMain.VERSION);
                writer.println("#");
                writer.println("# This is a config file. Lines starting with # will be ignored.");
                writer.println("# Changes Take Effect When You Restart You Game");
                writer.println("#");
                writer.println("# Enable = True");
                writer.println("# Disable = False");
                writer.println("#");
                writer.println("#");
                writer.println("#");
                writer.println("# Enable Servers");
                writer.println("# If This Is On It Will Display Custom Server Icons And Text");
                writer.println("[Enable-Servers] = True");
                writer.println("#");
                writer.println("#");
                writer.println("#");
                writer.println("# Enable Drp");
                writer.println("# If This Is Off The Discord Ritch Presence  Will Not Display");
                writer.println("[Enable-Drp] = True");
                writer.println("#");
                writer.println("#");
                writer.println("#");
                writer.println("# Theme");
                writer.println("# This Changes The Image That Is Show During All Times Accept When You Are In The Menu");
                writer.println("# Themes: default,pvp,book,quest,kebab,smoke-ship");
                writer.println("[Theme] = default");
                writer.close();
            } catch (IOException e) {
                com.otis.LOTRDrp.LOTRDrpMain.OTISLog("There Was A Problem Creating The Cfg File");
                e.printStackTrace();
            }
        }
    }
}



