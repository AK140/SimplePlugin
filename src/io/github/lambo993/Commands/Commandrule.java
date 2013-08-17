package io.github.lambo993.commands;

import java.util.List;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.*;

public class Commandrule implements CommandExecutor {

	private SimplePlugin plugin;

	public Commandrule(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rule")) {
			List<String> rules = plugin.getConfig().getStringList("rules");
			for (String s : rules) {
				sender.sendMessage(s);
			}
			return true;
		}
		return false;
	}
}