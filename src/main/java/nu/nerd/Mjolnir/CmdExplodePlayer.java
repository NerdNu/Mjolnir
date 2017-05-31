package nu.nerd.Mjolnir;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdExplodePlayer implements CommandExecutor {

    private MjolnirPlugin plugin;
    
    public CmdExplodePlayer(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * USAGE: /explodeplayer <player> [<message>]: Explode thine enemy.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check args
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "USAGE: /explodeplayer <player> [<message>]: Explode thine enemy.");
            return true;
        }
        
        // Parse arguments
        String playerName = args[0];
        String msg = Util.Msgify(1, args);

        Player player = plugin.getServer().getPlayer(playerName);
        if(player == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }
        
        Util.Explode(player, true);
        plugin.getServer().broadcastMessage("* " + player.getName() + " explodes");
        
        if(msg != null) {
            player.sendMessage(ChatColor.RED + msg);
        }

        return true;
    }


}
