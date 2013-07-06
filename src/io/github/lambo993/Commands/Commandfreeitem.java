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
		if(cmd.getName().equalsIgnoreCase("FreeItem") && args.length == 2 ) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				PlayerInventory inventory = player.getInventory();
				ItemStack wood = new ItemStack(Material.WOOD, Integer.parseInt(args[1]));
				ItemStack dirt = new ItemStack(Material.DIRT, Integer.parseInt(args[1]));
				ItemStack stone = new ItemStack(Material.STONE, Integer.parseInt(args[1]));
				ItemStack diamond = new ItemStack(Material.DIAMOND, Integer.parseInt(args[1]));
				ItemStack cake = new ItemStack(Material.CAKE, Integer.parseInt(args[1]));
				ItemStack cobblestone = new ItemStack(Material.COBBLESTONE , Integer.parseInt(args[0]));
				if(args[0].equalsIgnoreCase("Wood")){
					inventory.addItem(wood);
				}
				if(args[0].equalsIgnoreCase("Dirt")){
					inventory.addItem(dirt);
				}
				if(args[0].equalsIgnoreCase("Stone")){
					inventory.addItem(stone);
				}
				if(args[0].equalsIgnoreCase("Diamond")){
					inventory.addItem(diamond);
				}
				if(args[0].equalsIgnoreCase("Cake")){
					inventory.addItem(cake);
				}
				if(args[0].equalsIgnoreCase("Cobblestone")) {
					inventory.addItem(cobblestone);
				}
			} else {
				sender.sendMessage("§cError:§4 freeitem can only be used by player!");
			}
			return true;
		}
		return false;
	}
}