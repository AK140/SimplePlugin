package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandsimpleplugin implements CommandExecutor {
	
	private SimplePlugin plugin;
	
	public Commandsimpleplugin(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("simpleplugin")) {
			if(args[0].equalsIgnoreCase("reload")) {
				if(sender.hasPermission("simpleplugin.reload")) {
					this.plugin.reloadConfig();
				} else {
					sender.sendMessage("§4You do not have access to that command.");
				}
			}
			if(args[0].equalsIgnoreCase("version")) {
				sender.sendMessage("§6SimplePlugin version 0.4.8");
				sender.sendMessage("§6Description: This is a very simple plugins.");
			}
			if(args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("Help for simpleplugin");
				sender.sendMessage("/ignite Burns a player");
				sender.sendMessage("/echo echo a message");
			}
			return true;
		}
		return false;
	}

}
