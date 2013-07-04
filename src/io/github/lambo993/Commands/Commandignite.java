package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandignite implements CommandExecutor {
 
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
 
	public Commandignite(SimplePlugin plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if(cmd.getName().equalsIgnoreCase("ignite") && args.length == 2 ) {
	    	if (args.length < 2) {
	    		sender.sendMessage("Set a player on fire.");
	    		return false;
	    	}
	    	if (args[0].trim().length() < 2) {
	    		sender.sendMessage("You need to specify a player to burn.");
	    	}
	    	Player target = sender.getServer().getPlayer(args[0]);
	    	target.setFireTicks(Integer.parseInt(args[1]) * 20);
	    	sender.sendMessage("§6You set§c " + target.getDisplayName() + " §6on fire for§c " + Integer.parseInt(args[1]) + " seconds§6.");
	        return true;
	    }
	    return false;
	}
}