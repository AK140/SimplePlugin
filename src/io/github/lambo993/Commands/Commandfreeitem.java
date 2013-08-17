package io.github.lambo993.commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

public class Commandfreeitem implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandfreeitem(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("freeitem")) {
			if (sender instanceof Player) {
				if (args.length == 0) {
					return false;
				}
				Player player = (Player) sender;
				PlayerInventory inventory = player.getInventory();
				if (args.length == 1) {
					try {
						ItemStack itemstack = new ItemStack(Material.matchMaterial(args[0]), 1);
						inventory.addItem(itemstack);
						sender.sendMessage("§6Giving§c 1 §6of§c " + Material.matchMaterial(args[0]) + "§6.");
					} catch (NullPointerException ex) {
						sender.sendMessage("§cError:§4 Unknown item name: " + args[0] + "§4.");
						return true;
					}
					return true;
				} else if (args.length == 2) {
					try {
						ItemStack itemstack = new ItemStack(Material.matchMaterial(args[0]), Integer.parseInt(args[1]));
						inventory.addItem(itemstack);
						sender.sendMessage("§6Giving§c " + Integer.parseInt(args[1]) + " §6of§c " + Material.matchMaterial(args[0]) + "§6.");
					} catch (NullPointerException ex) {
						sender.sendMessage("§cError:§4 Unknown item name: " + args[0] + "§4.");
						return true;
					} catch (NumberFormatException ex) {
						return true;
					}
				}
			} else {
				sender.sendMessage("§cError:§4 Only in-game can use freeitem.");
			}
			return true;
		}
		return false;
	}
}