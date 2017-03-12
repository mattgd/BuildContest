package me.mattgd.buildcontest.cmds;

import org.bukkit.command.CommandSender;

import me.mattgd.buildcontest.BuildContest;
import me.mattgd.buildcontest.MessageManager;

public class Reload extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		BuildContest plugin = BuildContest.getPlugin();
		plugin.reloadConfig();
		MessageManager msg = MessageManager.getInstance();
		plugin.getLogger().info("[BuildContest] Configuration data reloaded.");
		msg.good(sender, "Reloaded!");
	}
	
	public String name() {
		return "reload";
	}
	
	public String info() {
		return "Reload the plugin.";
	}
	
	public String[] aliases() {
		return new String[] { "rload" };
	}
	
	public String permission() {
		return PERMISSION_PREFIX + "admin";
	}
	
}