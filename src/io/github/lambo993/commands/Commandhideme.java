package io.github.lambo993.commands;

import io.github.lambo993.SimplePlugin;
  
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandhideme implements CommandExecutor {

	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandhideme(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("HideMe") && args.length == 1 ) {
			if (sender instanceof Player) {
				Player player = (Player)sender; 
				Player target = player.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage(args[0] + " is not online!");
					return true;
				}
				target.hidePlayer(player);
			} else {
				sender.sendMessage("§cError: §4hideme can only be used by players.");
			}
			return true;
		}
		return false;
	}
}