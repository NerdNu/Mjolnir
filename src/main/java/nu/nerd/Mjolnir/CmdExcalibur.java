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
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class CmdExcalibur implements CommandExecutor {

    @SuppressWarnings("unused")
    private MjolnirPlugin plugin;
    
    public CmdExcalibur(MjolnirPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * USAGE: /excalibur [<message>]
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use the power of Excalibur.");
            return true;
        }
        Player player = (Player)sender;
        
        // Parse arguments
        String msg = Util.Msgify(0, args);

        // Get the block the player is looking at, using the same search distance as Command Helper.
        // We cast the null to call the correct overload of getTargetBlock.
        Block block = player.getTargetBlock((Set<Material>)null, 10000);
        if(block == null) {
            player.sendMessage(ChatColor.RED + "No block in sight, or block too far.");
            return true;
        }
        
        World w = player.getWorld();
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        
        w.strikeLightning(new Location(w, x + 2, y, z));
        w.strikeLightning(new Location(w, x - 2, y, z));
        w.strikeLightning(new Location(w, x, y, z + 2));
        w.strikeLightning(new Location(w, x, y, z - 2));
        w.createExplosion(x, y, z, 8, true, true);
        
        // /explode everything in the vicinity
        for (Entity entity : w.getNearbyEntities(new Location(w, x, y, z), 3, 3, 3)) {
            if(entity instanceof LivingEntity) {
                Util.Explode((LivingEntity)entity, false);
                if(entity instanceof Player) {
                    Player p = (Player)entity;
                    p.sendMessage(ChatColor.RED + msg);
                }
            }
        }
        
        return true;
    }

}
