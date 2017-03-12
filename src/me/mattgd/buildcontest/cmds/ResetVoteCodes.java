package me.mattgd.buildcontest.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.mattgd.buildcontest.BuildContest;

public class ResetVoteCodes extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		BuildContest plugin = BuildContest.getPlugin();
		FileConfiguration config = plugin.getConfig();
		config.set("codes", null);
		
		try {
			config.save(plugin.getDataFolder() + File.separator + "config.yml");
		} catch (IOException e) {
			throw new IllegalArgumentException("Could not save configuration file.");
		}
		
		info(sender, "Build contest codes reset.");
	}
	
	public String name() {
		return "resetcodes";
	}
	
	public String info() {
		return "Reset build contest vote codes.";
	}
	
	public String[] aliases() {
		return new String[] { "resetcodes", "rc" };
	}
	
	public String permission() {
		return PERMISSION_PREFIX + "admin";
	}
	
}