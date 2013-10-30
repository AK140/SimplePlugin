package io.github.lambo993.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandunhideme implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("unhideme")) {
			if (sender instanceof Player) {
				if (args.length != 1) {
					return false;
				}
				Player player = (Player)sender;
				Player target = player.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(args[0] + " is not online!");
					return true;
				}
				target.showPlayer(player);
			} else {
				sender.sendMessage("§cError: §4hideme can only be used by players.");
			}
			return true;
		}
		return false;
	}
}