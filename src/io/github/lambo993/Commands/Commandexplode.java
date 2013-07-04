package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandexplode implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandexplode(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("explode")) {
			//TODO: add logic to explode player here
			return true;
		}
		return false;
	}

}
