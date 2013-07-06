package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

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
					sender.sendMessage("§6SimplePlugin Reloaded §c0.5.3");
				} else {
					sender.sendMessage("§4You do not have permissions to reload the config");
				}
			}
			if(args[0].equalsIgnoreCase("version")) {
				sender.sendMessage("§6SimplePlugin version 0.5.2");
				sender.sendMessage("§6Description: This is a very simple plugins.");
				sender.sendMessage("§6authors: §eLambo993§r, §emahmoudnaruto96");
			}
			if(args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("§6Help for simpleplugin");
				sender.sendMessage("§6/ignite§r: Burns a player");
				sender.sendMessage("§6/freeitem§r: Gives you a free item!");
				sender.sendMessage("§6/healthy§r: Heals you or the given player.");
				sender.sendMessage("§6/generateblock§r: Generate a block on top of you!");
				sender.sendMessage("§6/rule§r: Show the rules.");
				sender.sendMessage("§6/pm§r: Private messages someone.");
			}
			if(args[0].equalsIgnoreCase("moo")) {
				if (sender instanceof ConsoleCommandSender)
				{
					sender.sendMessage(new String[]
							{
								"         (__)", "         (oo)", "   /------\\/", "  / |    ||", " *  /\\---/\\", "    ~~   ~~", "....\"Have you mooed today?\"..."
							});
				}
				else
				{
					sender.sendMessage(new String[]
							{
								"            (__)", "            (oo)", "   /------\\/", "  /  |      | |", " *  /\\---/\\", "    ~~    ~~", "....\"Have you mooed today?\"..."
							});
				}
					final Player player = (Player)sender;
					player.playSound(player.getLocation(), Sound.COW_IDLE, 1, 1.0f);
			}
			sender.sendMessage("Usage: /simpleplugin <help/reload/version>");
			return true;
		}
		return false;
	}
}