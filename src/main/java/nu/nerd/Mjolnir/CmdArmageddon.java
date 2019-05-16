package nu.nerd.Mjolnir;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdArmageddon implements CommandExecutor {

    private final MjolnirPlugin plugin;

    public CmdArmageddon(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * USAGE: /armageddon [<message>]
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Parse arguments
        String msg = Util.Msgify(0, args);

        // Now call lightning on everyone!
        for (Player selectedPlayer : plugin.getServer().getOnlinePlayers()) {
            Util.Thor(selectedPlayer, msg);
        }
        return true;
    }

}
