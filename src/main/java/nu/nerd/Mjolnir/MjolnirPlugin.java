package nu.nerd.Mjolnir;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class MjolnirPlugin extends JavaPlugin {

    /** WorldGuard plugin. null if World Guard is not available */
    private WorldGuardPlugin wg = null;
    
    /**
     * Enable Mjolnir
     */
    @Override
    public void onEnable() {
        
        getLogger().info("Starting...");
        
        // Try to get a reference to World Guard
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
        if (plugin instanceof WorldGuardPlugin) {
            wg = (WorldGuardPlugin)plugin;
        }

        // TODO: Load config
        // this.saveDefaultConfig();
        // config = new MjolnirConfig(this);
        
        // Setup commands
        this.getCommand("striket").setExecutor(new CmdStriket(this));
        
    }
    
}
