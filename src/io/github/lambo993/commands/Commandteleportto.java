package io.github.lambo993.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandteleportto implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("teleportto")) {
			if (args.length == 0) {
				return false;
			}
			if (args.length == 1) {
				if (!(sender instanceof Player)) {
					return false;
				}
				Player player = (Player)sender;
				Player target = player.getServer().getPlayer(args[0]);
				if (target == null) {
					return true;
				}
				player.teleport(target);
				return true;
			} else if (args.length == 2) {
				Player target = sender.getServer().getPlayer(args[0]);
				Player otherTarget = sender.getServer().getPlayer(args[1]);
				if (target == null) {
					return true;
				}
				if (otherTarget == null) {
					return true;
				}
				target.teleport(otherTarget);
			}
			return true;
		}
		return false;
	}
}