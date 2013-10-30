package io.github.lambo993.commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Commandsimpleplugin implements CommandExecutor {

	private SimplePlugin plugin;

	public Commandsimpleplugin(SimplePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("simpleplugin")) {
			 if (args.length != 1 || args[0].length() == 0) {
				 return false;
			 }
			PluginDescriptionFile pdf = plugin.getDescription();
			if (args[0].equalsIgnoreCase("reload")) {
				if(sender.hasPermission("simpleplugin.reload")) {
					this.plugin.reloadConfig();
					sender.sendMessage("§6SimplePlugin Reloaded §c" + pdf.getVersion());
				} else {
					sender.sendMessage("§4You do not have permissions to reload the config");
				}
			}
			if (args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("about")) {
				sender.sendMessage(pdf.getFullName());
				sender.sendMessage(pdf.getDescription());
				sender.sendMessage(pdf.getVersion());
				for (String s : pdf.getAuthors()) {
					sender.sendMessage(s);
				}
			}
			if (args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("§6Help for simpleplugin");
				sender.sendMessage("§6/ignite§r: Burns a player");
				sender.sendMessage("§6/freeitem§r: Gives you a free item!");
				sender.sendMessage("§6/healthy§r: Heals you or the given player.");
				sender.sendMessage("§6/generateblock§r: Generate a block on top of you!");
				sender.sendMessage("§6/rule§r: Show the rules.");
				sender.sendMessage("§6/pm§r: Private messages someone.");
				sender.sendMessage("§6/explode:§r Explodes the target.");
			}
			if (args[0].equalsIgnoreCase("moo")) {
				if (sender instanceof ConsoleCommandSender) {
					sender.sendMessage(new String[] {
								"         (__)", "         (oo)", "   /------\\/", "  / |    ||", " *  /\\---/\\", "    ~~   ~~", "....\"Have you mooed today?\"..."
							});
				} else {
					sender.sendMessage(new String[] {
								"            (__)", "            (oo)", "   /------\\/", "  /  |      | |", " *  /\\---/\\", "    ~~    ~~", "....\"Have you mooed today?\"..."
							});
					final Player player = (Player)sender;
					player.playSound(player.getLocation(), Sound.COW_IDLE, 1, 1.0f);
				}	
			}
			return true;
		}
		return false;
	}
}