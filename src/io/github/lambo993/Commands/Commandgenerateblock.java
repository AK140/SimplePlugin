package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandgenerateblock implements CommandExecutor {
 
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
				World world = loc.getWorld();
				loc.setY(loc.getY() + plugin.getConfig().getInt("Generateblock-height"));
				Block block = world.getBlockAt(loc);
				try {
					block.setType(Material.matchMaterial(args[0]));
					player.sendMessage("Generated Block " + args[0] + " on top of you!");
				} catch (NullPointerException e) {
					sender.sendMessage(args[0] + " is not a block");
					return true;
				}
			} else {
				sender.sendMessage("§cError:§4 Only in-game players can use generateblock");
			}
			return true;
		}
		return false;
	}
}