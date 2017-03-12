package me.mattgd.buildcontest.cmds;

import org.bukkit.command.CommandSender;

import me.mattgd.buildcontest.MessageManager;

public abstract class SubCommand {
	
	public abstract void onCommand(CommandSender sender, String[] args);
	public abstract String name();
	public abstract String info();
	public abstract String[] aliases();
	public abstract String permission();
	
	protected final String PERMISSION_PREFIX = "buildcontest.";
	protected final String NO_PERMISSION = "You do not have permission to use this command.";
	protected final String INVALID_SUBCMD = "Invalid subcommand.";
	protected final String MISSING_PLAYER = "You must specify a player name.";
	
	protected String invalidPlayer(String name) {
		return "Could not find player " + name + ".";
	}
	
	protected static void severe(CommandSender sender, String message) {
		MessageManager.getInstance().severe(sender, message);
	}
	
	protected static void info(CommandSender sender, String message) {
		MessageManager.getInstance().info(sender, message);
	}
	
	protected static void good(CommandSender sender, String message) {
		MessageManager.getInstance().good(sender, message);
	}
	
}
