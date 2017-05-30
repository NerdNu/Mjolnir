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
            getLogger().info("Found WorldGuard");
        }

        // TODO: Load config
        // this.saveDefaultConfig();
        // config = new MjolnirConfig(this);
        
        // Setup commands
        this.getCommand("striket").setExecutor(new CmdStriket(this));
        this.getCommand("striketrg").setExecutor(new CmdStriketrg(this));
        this.getCommand("thor").setExecutor(new CmdThor(this));
        this.getCommand("thorrg").setExecutor(new CmdThorrg(this));
        this.getCommand("explode").setExecutor(new CmdExplode(this));
        this.getCommand("explodeplayer").setExecutor(new CmdExplodePlayer(this));
        this.getCommand("ladycalin").setExecutor(new CmdLadyCalin(this));
        this.getCommand("armageddon").setExecutor(new CmdArmageddon(this));
        this.getCommand("excalibur").setExecutor(new CmdExcalibur(this));
        
    }
    
    /**
     * Get the world guard plugin, if present.
     * @return
     */
    public WorldGuardPlugin getWorldGuard() {
        return wg;
    }
    
}

