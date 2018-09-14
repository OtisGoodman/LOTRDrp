package com.otis.LOTRDrp.Client.Config;

import com.otis.LOTRDrp.LOTRDrpMain;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class LOTRDrpGuiConfig extends GuiConfig {

public LOTRDrpGuiConfig(GuiScreen guiScreen){
    super(guiScreen,new ConfigElement(LOTRDrpConfig.getConfig().getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
            LOTRDrpMain.MODID,
            false,
            false,GuiConfig.getAbridgedConfigPath(LOTRDrpConfig.getConfig().toString()));

}


}
