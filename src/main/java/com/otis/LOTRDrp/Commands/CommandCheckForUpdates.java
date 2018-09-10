    package com.otis.LOTRDrp.Commands;

    import java.util.List;

    import com.otis.LOTRDrp.LOTRDrpUpdateChecker;
    import net.minecraft.command.*;
    import net.minecraft.entity.player.EntityPlayer;
    import net.minecraft.util.ChunkCoordinates;
    import net.minecraft.world.WorldServer;
    import cpw.mods.fml.common.FMLLog;

    public class CommandCheckForUpdates extends CommandBase
    {
        @Override
        public String getCommandName()
        {
            return "checkForUpdates";
        }


        @Override
        public String getCommandUsage(ICommandSender sender)
        {
            return "/checkForUpdates";
        }

        @Override
        public void processCommand(ICommandSender sender, String[] args) {
          LOTRDrpUpdateChecker.checkForUpdates();
         LOTRDrpUpdateChecker.reloadUpdateCheck();

        }

        @Override
        public List addTabCompletionOptions(ICommandSender sender, String[] args)
        {
            return null;
        }

        @Override
        public boolean isUsernameIndex(String[] args, int i)
        {
            return false;
        }

        @Override
        public boolean canCommandSenderUseCommand(ICommandSender sender) {
            return true;
        }


    }
