package nu.nerd.Mjolnir;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class CmdStriketrg implements CommandExecutor {

    private MjolnirPlugin plugin;
    
    public CmdStriketrg(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * /striketrg <region> [<message>]: /striket everyone in a region.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Get World Guard
        WorldGuardPlugin wg = plugin.getWorldGuard();
        if (wg == null) {
            sender.sendMessage(ChatColor.RED + "ERROR: World guard is not installed.");
            return true;
        }
        
        // Check player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can haz the powerz of striket.");
            return true;
        }
        Player player = (Player)sender;
        
        // Check args
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "USAGE: /striketrg <region> [<message>]");
            return true;
        }
        
        // Parse arguments
        String regionName = args[0];
        String msg = Util.Msgify(1, args);
        
        // Acquire the region of interest
        RegionManager rm = wg.getRegionManager(player.getWorld());
        ProtectedRegion rg = rm.getRegion(regionName);
        if(rg == null) {
            sender.sendMessage(ChatColor.RED + "Cannot find region.");
            return true;
        }
        
        // Now call lightning on everyone!
        for(Player selectedPlayer : plugin.getServer().getOnlinePlayers()) {
            if(player == selectedPlayer) {
                continue;
            }
            int x = selectedPlayer.getLocation().getBlockX();
            int y = selectedPlayer.getLocation().getBlockY();
            int z = selectedPlayer.getLocation().getBlockZ();
            if(rg.contains(x, y, z)) {
                selectedPlayer.getWorld().strikeLightningEffect(selectedPlayer.getEyeLocation());
                if(msg != null) {
                    selectedPlayer.sendMessage(ChatColor.RED + msg);
                }
            }
        }

        return true;
    }
}
