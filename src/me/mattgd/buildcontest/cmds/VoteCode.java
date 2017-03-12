package me.mattgd.buildcontest.cmds;

import java.util.Random;
import java.util.UUID;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.mattgd.buildcontest.BuildContest;

public class VoteCode extends SubCommand {
	
	public void onCommand(CommandSender sender, String[] args) {
		BuildContest plugin = BuildContest.getPlugin();
		FileConfiguration config = plugin.getConfig();
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			UUID uuid = p.getUniqueId();
			int uuidHash = (int) Math.abs(uuid.hashCode());
			String uuidHashStr = Integer.toString(uuidHash);
			uuidHashStr = uuidHashStr.length() > 5 ? uuidHashStr.substring(0, 4) : uuidHashStr;
			String code = config.getString("codes." + uuid, null);
			
			if (code == null) {
				code = uuidHashStr + getSaltString();
				config.set("codes." + uuid, code);
			}
			
			good(sender, "Your build contest code is: &e" + code);
		} else {
			severe(sender, "Only players can use this command.");
		}
	}
	
	public String name() {
		return "votecode";
	}
	
	public String info() {
		return "Get your build contest vote code.";
	}
	
	public String[] aliases() {
		return new String[] { "code", "c" };
	}
	
	public String permission() {
		return PERMISSION_PREFIX + "use";
	}
	
	private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        
        while (salt.length() < 4) {
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        
        String saltStr = salt.toString();
        return saltStr;
    }
	
}