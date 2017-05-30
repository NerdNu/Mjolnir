package nu.nerd.Mjolnir;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdExplode implements CommandExecutor {

    private MjolnirPlugin plugin;
    
    public CmdExplode(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * USAGE: /explode
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can haz the powerz of explode.");
            return true;
        }
        Player player = (Player)sender;
        
        // Check args
        if (args.length != 0) {
            player.sendMessage(ChatColor.RED + "USAGE: /explode");
            return true;
        }
        
        Util.Explode(player, true);
        plugin.getServer().broadcastMessage("* " + player.getName() + " explodes");

        return true;
    }

}
