package nu.nerd.Mjolnir;

import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdStriket implements CommandExecutor {
    
    @SuppressWarnings("unused")
    private MjolnirPlugin plugin;
    
    public CmdStriket(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,
            String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can haz the powerz of striket.");
            return true;
        }
        Player player = (Player)sender;
        
        // Get the block the player is looking at, using the same search distance as Command Helper.
        // We cast the null to call the correct variant of getTargetBlock.
        Block block = player.getTargetBlock((Set<Material>)null, 10000);
        if(block == null) {
            player.sendMessage(ChatColor.RED + "No block in sight, or block too far.");
            return true;
        }
        
        // Call down the thunder
        World w = block.getWorld();
        int x = block.getX();
        int y = block.getY() + 1;
        int z = block.getZ();
        Location loc = new Location(w, x, y, z);
        w.strikeLightning(loc);

        return true;
    }

}
