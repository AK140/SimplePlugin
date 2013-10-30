package io.github.lambo993.commands;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

public class Commandfreegift implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("freegift") && args.length == 3 ) {
			Player target = sender.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage("§cError: §4Player not found.");
				return true;
			}
			PlayerInventory inventory = target.getInventory();
			try {
				ItemStack itemstack = new ItemStack(Material.matchMaterial(args[1]), Integer.parseInt(args[2]));
				inventory.addItem(itemstack);
			} catch (NullPointerException e) {
				sender.sendMessage("§cError:§4 Unknown item name: " + args[1] + "§4.");
				return true;
			} catch (NumberFormatException e) {
				return true;
			}
			return true;
		}
		return false;
	}
}