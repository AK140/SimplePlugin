package io.github.lambo993.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandkillplayer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("killplayer")) {
			if (args.length != 1 || args[0].length() == 0) {
				sender.sendMessage("Kills a player.");
				return false;
			}
			Player target = sender.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("§cError: §4Player not found.");
				return true;
			}
			target.setHealth(0.0);
			sender.sendMessage("§6Killed§c " + target.getName() + "§6.");
			return true;
		}
		return false;
	}
}