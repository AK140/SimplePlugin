package io.github.lambo993.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandgenerateblock implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("generateblock") && args.length == 2) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				Location loc = player.getLocation();
				World world = loc.getWorld();
				int locY;
				try {
					locY = Integer.parseInt(args[1]);
					loc.setY(loc.getY() + locY);
				} catch (NumberFormatException ex) {
					sender.sendMessage("§cError: §4" + ex.getMessage());
					return true;
				}
				Block block = world.getBlockAt(loc);
				try {
					block.setType(Material.matchMaterial(args[0]));
					String material = Material.matchMaterial(args[0]).toString().toLowerCase();
					if (locY > 0) {
						player.sendMessage("Generated Block " + material + " on top of you!");
					} else {
						player.sendMessage("Generated Block " + material + " below of you!");
					}
				} catch (NullPointerException e) {
					sender.sendMessage(args[0] + " is not a block");
					return true;
				}
			} else {
				sender.sendMessage("§cError:§4 Only in-game players can use generateblock.");
			}
			return true;
		}
		return false;
	}

	public void generateCube(Location loc, int length, Material type) {
		// Set one corner of the cube to the given location.
		// Uses getBlockN() instead of getN() to avoid casting to an int later.
		int x1 = loc.getBlockX(); 
		int y1 = loc.getBlockY();
		int z1 = loc.getBlockZ();

		// Figure out the opposite corner of the cube by taking the corner and adding length to all coordinates.
		int x2 = x1 + length;
		int y2 = y1 + length;
		int z2 = z1 + length;

		World world = loc.getWorld();

		// Loop over the cube in the x dimension.
		for (int xPoint = x1; xPoint <= x2; xPoint++) {
			// Loop over the cube in the y dimension.
			for (int yPoint = y1; yPoint <= y2; yPoint++) {
				// Loop over the cube in the z dimension.
				for (int zPoint = z1; zPoint <= z2; zPoint++) {
					// Get the block that we are currently looping over.
					Block currentBlock = world.getBlockAt(xPoint, yPoint, zPoint);
					// Set the block to type 57 (Diamond block!)
					currentBlock.setType(type);
				}
			}
		}
	}
}