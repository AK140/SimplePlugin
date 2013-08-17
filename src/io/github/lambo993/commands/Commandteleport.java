package io.github.lambo993.commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class Commandteleport implements CommandExecutor {

	@SuppressWarnings("unused")
	private SimplePlugin plugin;

	public Commandteleport(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("teleport")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Error: Only in-game players can use teleport.");
				return true;
			}
			if (args.length < 2) {
				return false;
			}
			Player player = (Player)sender;
			if (args.length == 3) {
				try {
					Location loc = new Location(player.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
					player.teleport(loc, TeleportCause.COMMAND);
				} catch (NumberFormatException ex) {
					sender.sendMessage("§cError: §4" + ex.getMessage());
					return true;
				}
				return true;
			} else if (args.length == 5) {
				try {
					Location loc = new Location(player.getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4]));
					player.teleport(loc);
				} catch (NumberFormatException ex) {
					sender.sendMessage("§cError: §4" + ex.getMessage());
					return true;
				}
			}
			return true;
		}
		return false;
	}
}