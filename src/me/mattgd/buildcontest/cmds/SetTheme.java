package me.mattgd.buildcontest.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.mattgd.buildcontest.BuildContest;
import me.mattgd.buildcontest.MessageManager;

public class SetTheme extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		if (args.length == 0) {
			severe(sender, "You must specify a theme to set.");
		} else {
			String theme = MessageManager.getInstance().assembleMessage(args, 0, args.length);
			BuildContest plugin = BuildContest.getPlugin();
			FileConfiguration config = plugin.getConfig();
			
			config.set("contest.theme", theme);
			
			try {
				config.save(plugin.getDataFolder() + File.separator + "config.yml");
			} catch (IOException e) {
				throw new IllegalArgumentException("Could not save configuration file.");
			}
			
			good(sender, "Build contest theme set to: &e" + theme);
		}
	}
	
	public String name() {
		return "settheme";
	}
	
	public String info() {
		return "Set the build contest theme.";
	}
	
	public String[] aliases() {
		return new String[] { "st" };
	}
	
	public String permission() {
		return PERMISSION_PREFIX + "admin";
	}
	
}