package me.mattgd.buildcontest.cmds;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import me.mattgd.buildcontest.BuildContest;

public class Info extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		FileConfiguration config = BuildContest.getPlugin().getConfig();
		
		String theme = config.getString("contest.theme").trim();
		String link = config.getString("contest.link").trim();
		String msg = String.format("The current build contest theme is: &b%s%n&aEnter here: &e%s", theme, link).replaceAll("\\r", "");;
		good(sender, msg);
	}
	
	public String name() {
		return "info";
	}
	
	public String info() {
		return "Get build contest information.";
	}
	
	public String[] aliases() {
		return new String[] { "information" };
	}
	
	public String permission() {
		return PERMISSION_PREFIX + "use";
	}
	
}