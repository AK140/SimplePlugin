package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandhealthy implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandhealthy(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("healthy") && args.length == 1 ){
			Player target = sender.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("§4Player not found.");
				return false;
			}
			target.sendMessage("§6You have been healed.");
			sender.sendMessage("§6Healed " + target.getDisplayName() + "§6.");
			target.setHealth(20);
			target.setFoodLevel(20);
			target.setFireTicks(0);
			return true;
		}
		return false;
	}
}
