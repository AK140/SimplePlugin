package io.github.lambo993.Commands;

import io.github.lambo993.SimplePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.earth2me.essentials.utils.FormatUtil;

public class Commandecho implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private SimplePlugin plugin;
	
	public Commandecho(SimplePlugin plugin) {
		this.plugin = plugin;
	}
	
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("echo")) {
			if (args.length > 1) {
				sender.sendMessage("echo");
			}
			//TODO:remove the essentials dependency
			sender.sendMessage(FormatUtil.replaceFormat(getFinalArg(args, 0)));
			return true;
		}
		return false;
	}

}
