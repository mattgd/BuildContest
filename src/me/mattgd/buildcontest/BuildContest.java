package me.mattgd.buildcontest;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * BuildContest plugin main class.
 * 
 * @author mattgd
 */
public class BuildContest extends JavaPlugin {

	/** The current instance of this class for use in other classes */
	private static BuildContest plugin;
	
    /**
     * Enable the StartupCommand plugin.
     */
	@Override
	public void onEnable() {
		plugin = this;
		
 		saveDefaultConfig(); // Create default the configuration if config.yml doesn't exist
		
 		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("buildcontest").setExecutor(cm); // Setup BuildContest command
		
		getLogger().info("Enabled!");
	}
	
	/**
     * Disable the BuildContest plugin.
     */
	@Override
	public void onDisable() {       
        Bukkit.getScheduler().cancelAllTasks(); // Cancel scheduled tasks
		this.getConfig().options().copyDefaults(true);
		getLogger().info("Disabled!");
	}
	
	/**
     * Returns the BuildContest plugin instance.
     * @return the BuildContest plugin instance.
     */
    public static BuildContest getPlugin() {
    	return plugin;
    }
	
}
