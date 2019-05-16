package nu.nerd.Mjolnir;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Utility functions
 *
 */
public class Util {

    /**
     * Drop lightning on a particular entity
     * 
     * @param player
     */
    public static void Lightning(Player player) {

    }

    /**
     * Thor a player
     * 
     * @param player The player
     * @param msg Optional custom message
     */
    public static void Thor(Player player, String msg) {
        player.getWorld().strikeLightningEffect(player.getEyeLocation());
        Explode(player, false);

        if (msg == null) {
            // TODO: Load this from config
            msg = "You have been smote by Thor's Mighty Hammer!";
        }
        player.sendMessage(ChatColor.RED + msg);
    }

    /**
     * Play an explosion animation on a player.
     * 
     * @param entity The living entity to explode.
     */
    public static void Explode(LivingEntity entity, boolean playSound) {

        World w = entity.getWorld();
        double x = entity.getLocation().getX();
        double y = entity.getLocation().getY() + 1;
        double z = entity.getLocation().getZ();

        if (playSound) {
            w.playSound(new Location(w, x, y, z), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
        }

        w.spawnParticle(Particle.EXPLOSION_LARGE, x, y, z, 4, 1.0, 2.0, 1.0);
        w.spawnParticle(Particle.BLOCK_DUST, x, y, z, 256, 1.0, 2.0, 1.0, 0.0, Material.REDSTONE_BLOCK.createBlockData());
        w.spawnParticle(Particle.ITEM_CRACK, x, y, z, 256, 0.16, 0.12, 0.16, 0.20, new ItemStack(Material.PORKCHOP));
        entity.setHealth(0);
    }

    /**
     * Turn the end of a parameter list into a string with color code
     * substitution
     * 
     * @param start index in the argument array to start stringification
     * @param args An array of arguments to stringify
     */
    public static String Msgify(int start, String[] args) {
        if (start < 0 || start >= args.length) {
            return null;
        }
        StringBuilder builder = new StringBuilder(args[start]);
        start++;
        for (; start < args.length; start++) {
            builder.append(' ');
            builder.append(args[start]);
        }
        return ChatColor.translateAlternateColorCodes('&', builder.toString());

    }

}
