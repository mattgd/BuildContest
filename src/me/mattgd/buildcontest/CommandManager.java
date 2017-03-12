package me.mattgd.buildcontest;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.mattgd.buildcontest.cmds.VoteCode;
import me.mattgd.buildcontest.cmds.Help;
import me.mattgd.buildcontest.cmds.Info;
import me.mattgd.buildcontest.cmds.Reload;
import me.mattgd.buildcontest.cmds.ResetVoteCodes;
import me.mattgd.buildcontest.cmds.SetLink;
import me.mattgd.buildcontest.cmds.SetTheme;
import me.mattgd.buildcontest.cmds.SubCommand;

public class CommandManager implements CommandExecutor {
	
	public static ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	
	public void setup() {
		commands.add(new VoteCode());
		commands.add(new Help());
		commands.add(new Info());
		commands.add(new Reload());
		commands.add(new ResetVoteCodes());
		commands.add(new SetTheme());
		commands.add(new SetLink());
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length == 0) {
			try {
				commands.get(1).onCommand(sender, args);
			} catch (Exception e) {
				MessageManager.getInstance().severe(sender, "An error has occured: " + e.getCause());
				e.printStackTrace();
			}
			
			return true;
		}
		
		SubCommand target = get(args[0]);
		
		if (target == null) {
			MessageManager.getInstance().severe(sender, "/" + cmd.getName() + " " + args[0] + " is not a valid command.");
			return true;
		}
		
		if (sender.hasPermission(target.permission())) {
			ArrayList<String> a = new ArrayList<String>();
			a.addAll(Arrays.asList(args));
			a.remove(0);
			args = a.toArray(new String[a.size()]);
			
			try {
				target.onCommand(sender, args);
			} catch (Exception e) {
				MessageManager.getInstance().severe(sender, "An error has occured: " + e.getCause());
				e.printStackTrace();
			}
		} else {
			MessageManager.getInstance().severe(sender, "You do not have permission to use that command.");
		}
		return true;
	}
	
	private SubCommand get(String name) {
		for (SubCommand cmd : commands) {
			if (cmd.name().equalsIgnoreCase(name))
				return cmd;
			
			for (String alias : cmd.aliases())
				if (name.equalsIgnoreCase(alias))
					return cmd;
		}
		
		return null;
	}
	
}