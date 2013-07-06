package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Commandfreeitem implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandfreeitem(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("FreeItem") && args.length == 1 ) {
			Player player = (Player) sender;
			PlayerInventory inventory = player.getInventory();
			ItemStack woodstack = new ItemStack(Material.WOOD, 64);
			ItemStack dirtstack = new ItemStack(Material.DIRT, 64);
			ItemStack stonestack = new ItemStack(Material.STONE, 64);
			ItemStack diamondstack = new ItemStack(Material.DIAMOND, 64);
			if(args[0].equalsIgnoreCase("Wood")){
				inventory.addItem(woodstack);
			}
			if(args[0].equalsIgnoreCase("Dirt")){
				inventory.addItem(dirtstack);
			}
			if(args[0].equalsIgnoreCase("Stone")){
				inventory.addItem(stonestack);
			}
			if(args[0].equalsIgnoreCase("Diamond")){
				inventory.addItem(diamondstack);
			}
			return true;
		}
		return false;
	}

}
