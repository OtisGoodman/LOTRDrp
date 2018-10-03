    package com.otis.LOTRDrp.Commands;

    import java.util.List;

    import com.otis.LOTRDrp.Util.LOTRDrpUpdateChecker;
    import net.minecraft.command.*;

    import static com.otis.LOTRDrp.LOTRDrpMain.OTISLog;

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
            OTISLog(sender.getCommandSenderName()+" Ran Command "+getCommandName());
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
