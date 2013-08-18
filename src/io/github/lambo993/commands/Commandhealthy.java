package io.github.lambo993.commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandhealthy implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandhealthy(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("healthy")) {
			if (args.length != 1 || args[0].length() == 0) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("Heals you or the given player.");
					return false;
				}
				Player player = (Player)sender;
				player.setHealth(20.0);
				player.setFoodLevel(20);
				player.setFireTicks(0);
				sender.sendMessage("§6You have been healed.");
				return true;
			}
			if (sender.hasPermission("simpleplugin.healthy.others")) {
				Player target = sender.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage("Heals you or the given player.");
					sender.sendMessage("§4Player not found.");
					return false;
				}
				if (target.isDead()) {
					sender.sendMessage("§cError:§4 You cannot heal someone who is dead!");
					return true;
				}
				target.sendMessage("§6You have been healed.");
				sender.sendMessage("§6Healed " + target.getDisplayName() + "§6.");
				target.setHealth(20.0);
				target.setFoodLevel(20);
				target.setFireTicks(0);
			} else {
				sender.sendMessage("§4You do not have permissions to heal others");
			}
			return true;
		}
		return false;
	}
}