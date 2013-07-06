package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandkillplayer implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandkillplayer(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("Killplayer") && args.length == 1 ) {
			Player target = sender.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("§cError: §4Player not found.");
			}
			target.setHealth(0);
			sender.sendMessage("§6Killed§c " + target.getDisplayName() + "§6.");
			return true;
		}
		return false;
	}
}