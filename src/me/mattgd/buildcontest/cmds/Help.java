package me.mattgd.buildcontest.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.mattgd.buildcontest.MessageManager;

public class Help extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		MessageManager msg = MessageManager.getInstance();
		String msgStr = msg.messageTitle("BuildContest Help", ChatColor.AQUA, ChatColor.YELLOW);
		
		msgStr += "\n&a/buildcontest &7- &aview the build contest information";
		msgStr += "\n&a/buildcontest votecode &7- &aget your build contest vote code";
		
		if (sender.hasPermission("buildcontest.admin")) {
			msgStr += "\n&a/buildcontest setlink <url> &7- &aset the build contest link";
			msgStr += "\n&a/buildcontest settheme <description> &7- &aset the build contest theme";
		}
		
		msgStr += msg.messageTrail(ChatColor.YELLOW); // Add message trail
		good(sender, msgStr);
	}
	
	public String name() {
		return "help";
	}
	
	public String info() {
		return "BuildContest command help.";
	}
	
	public String[] aliases() {
		return new String[] { "h" };
	}

	public String permission() {
		return PERMISSION_PREFIX + "use";
	}
	
}