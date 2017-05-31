/**
 * 
 */
package nu.nerd.Mjolnir;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

/**
 * @author challenger2
 *
 */
public class CmdThor implements CommandExecutor {

    private MjolnirPlugin plugin;
    
    public CmdThor(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }
    
    /**
     * USAGE: /thor <player> [<message>]
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        // Check args
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "USAGE: /thor <player> [<message>]");
            return true;
        }
        
        // Parse arguments
        String playerName = args[0];
        String msg = Util.Msgify(1, args);
        
        // Acquire target
        Player player = plugin.getServer().getPlayer(playerName);
        if(player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }
        
        Util.Thor(player, msg);
        return true;
        
    }

}
