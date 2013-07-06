package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandgenerateblock implements CommandExecutor {
 
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
 
	public Commandgenerateblock(SimplePlugin plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("Generateblock") && args.length == 1 ) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				Location loc = player.getPlayer().getLocation();
				World w = loc.getWorld();
				loc.setY(loc.getY() + 4);
				Block b = w.getBlockAt(loc);
				if(args[0].equalsIgnoreCase("Dirt")){
					b.setTypeId(3);
					player.sendMessage("Look above you! it's a dirt");
				}
				if(args[0].equalsIgnoreCase("Stone")){
					b.setTypeId(1);
					player.sendMessage("Look above you! it's a stone");
				}
				if(args[0].equalsIgnoreCase("Wood")){
					b.setTypeId(5);
					player.sendMessage("Look above you! it's a woodplank");
				}
			} else {
				sender.sendMessage("§cError:§4 generateblock can only be used by player!");
			}
			return true;
		}
		return false;
	}
}