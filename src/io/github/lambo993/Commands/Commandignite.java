package io.github.lambo993.commands;

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
	    if (label.equalsIgnoreCase("ignite")) {
	    	if (args.length < 2 || args[0].trim().length() < 2 || args[1].trim().isEmpty()) {
				sender.sendMessage("Set a player on fire.");
				return false;
			}
	    	Player target = sender.getServer().getPlayer(args[0]);
	    	if (target == null) {
	    		sender.sendMessage("§cError: §4Player not found.");
	    		return true;
	    	} try {
	    	    target.setFireTicks(Integer.parseInt(args[1]) * 20);
	    	} catch (NumberFormatException ex) {
	    	    sender.sendMessage("§cError: §4" + ex.getMessage());
	    	    return true;
	    	}
	    	sender.sendMessage("§6You set§c " + target.getDisplayName() + " §6on fire for§c " + Integer.parseInt(args[1]) + " seconds§6.");
	        return true;
	    }
	    return false;
	}
}