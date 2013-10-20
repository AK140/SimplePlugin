package io.github.lambo993.commands;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

public class Commandhelmet implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("helmet")) {
			if (!(sender instanceof Player)) {
				return true;
			}
			Player player = (Player)sender;
			ItemStack itemhand = player.getItemInHand();
			if (player.getItemInHand().getType() != Material.AIR) {
				player.getInventory().setHelmet(itemhand);
			} else {
				sender.sendMessage("Error: You must have an itme in your hand!");
			}
			return true;
		}
		return false;
	}
}