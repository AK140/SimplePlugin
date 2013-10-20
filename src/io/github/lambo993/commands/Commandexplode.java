package io.github.lambo993.commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandexplode implements CommandExecutor {

	private SimplePlugin plugin;

	public Commandexplode(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("explode")) {
			if (args.length != 1 || args[0].length() == 0) {
				sender.sendMessage("Explodes the target.");
				return false;
			}
			Player target = sender.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("�cError: �4Player not found.");
				return true;
			}
			sender.sendMessage("�6Creating explosion at�c " + target.getDisplayName());
			target.sendMessage("�6Boom!");
			target.getWorld().createExplosion(target.getLocation(), 10F, plugin.getConfig().getBoolean("explosion-fire", false));
			target.damage(10.0);
			return true;
		}
		return false;
	}
}