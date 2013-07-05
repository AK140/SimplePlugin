package io.github.lambo993.Commands;

import static io.github.lambo993.Commands.Commandecho.getFinalArg;
import io.github.lambo993.SimplePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

import com.earth2me.essentials.utils.FormatUtil;

public class Commandpm implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandpm(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pm")) {
			if(sender instanceof Player){
				Player player = (Player)sender;
				Player target = player.getServer().getPlayer(args[0]);
				if (target == null) {
					player.sendMessage("§cError: " + "§4Player not found.");
				}
				//TODO:remove the essentials dependency
				player.sendMessage("§6[me -> " + target.getDisplayName() + " §6]§r " + FormatUtil.replaceFormat(getFinalArg(args, 1)));
				target.sendMessage("§6[" + player.getDisplayName() + " §6-> me]§r " + FormatUtil.replaceFormat(getFinalArg(args, 1)));
			} else {
				Player target = sender.getServer().getPlayer(args[0]);
				sender.sendMessage("§6[me -> " + target.getDisplayName() + "§6]§r " + FormatUtil.replaceFormat(getFinalArg(args, 1)));
				target.sendMessage("§6[§cConsole -> " + " §6me]§r " + FormatUtil.replaceFormat(getFinalArg(args, 1)));
			}
			return true;
		}
		return false;
	}
}