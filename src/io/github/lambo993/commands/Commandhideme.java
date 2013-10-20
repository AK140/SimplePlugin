package io.github.lambo993.commands;
  
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandhideme implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("HideMe")) {
			if (sender instanceof Player) {
				if (args.length != 1) {
					return false;
				}
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