package me.mattgd.buildcontest.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.mattgd.buildcontest.BuildContest;

public class SetLink extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		if (args.length == 0) {
			severe(sender, "You must specify a link to set.");
		} else {
			String link = args[0];
			BuildContest plugin = BuildContest.getPlugin();
			FileConfiguration config = plugin.getConfig();
			
			config.set("contest.link", link);
			
			try {
				config.save(plugin.getDataFolder() + File.separator + "config.yml");
			} catch (IOException e) {
				throw new IllegalArgumentException("Could not save configuration file.");
			}
			
			good(sender, "Build contest link set to: &e" + link);
		}
	}
	
	public String name() {
		return "setlink";
	}
	
	public String info() {
		return "Set the build contest link.";
	}
	
	public String[] aliases() {
		return new String[] { "sl" };
	}
	
	public String permission() {
		return PERMISSION_PREFIX + "admin";
	}
	
}