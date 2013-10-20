package io.github.lambo993.commands;

import java.util.regex.Pattern;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commandpm implements CommandExecutor {
	
	private static final transient Pattern REPLACE_PATTERN = Pattern.compile("&([0-9a-fk-orA-FK-OR])");
	
	public static String getFinalArg(final String[] args, final int start)
	{
		final StringBuilder bldr = new StringBuilder();
		for (int i = start; i < args.length; i++)
		{
			if (i != start)
			{
				bldr.append(" ");
			}
			bldr.append(args[i]);
		}
		return bldr.toString();
	}
	
	public static String replaceFormat(final String input)
	{
		if (input == null)
		{
			return null;
		}
		return REPLACE_PATTERN.matcher(input).replaceAll("\u00a7$1");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pm")) {
			if (sender instanceof Player) {
				if (args.length < 2 || args[0].trim().length() < 2 || args[1].trim().isEmpty()) {
					sender.sendMessage("Sends a private message to the specified player.");
					return false;
				}
				Player player = (Player)sender;
				Player target = player.getServer().getPlayer(args[0]);
				if (target == null || !((Player)sender).canSee(target)) {
					player.sendMessage("§cError: " + "§4Player not found.");
					return true;
				}
				player.sendMessage("§6[me -> " + target.getDisplayName() + " §6]§r " + replaceFormat(getFinalArg(args, 1)));
				target.sendMessage("§6[" + player.getDisplayName() + " §6-> me]§r " + replaceFormat(getFinalArg(args, 1)));
			} else {
				if (args.length < 2 || args[0].trim().length() < 2 || args[1].trim().isEmpty()) {
					sender.sendMessage("Sends a private message to the specified player.");
					return false;
				}
				Player target = sender.getServer().getPlayer(args[0]);
				if (target == null) {
					sender.sendMessage("§cError: " + "§4Player not found.");
					return true;
				}
				sender.sendMessage("§6[me -> " + target.getDisplayName() + "§6]§r " + Commandpm.replaceFormat(getFinalArg(args, 1)));
				target.sendMessage("§6[Console -> me]§r " + Commandpm.replaceFormat(getFinalArg(args, 1)));
			}
			return true;
		}
		return false;
	}
}