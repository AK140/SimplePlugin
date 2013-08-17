package io.github.lambo993;

import io.github.lambo993.commands.*;
import io.github.lambo993.listener.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePlugin extends JavaPlugin {

	public static final int BUKKIT_VERSION = 2838;
	private static final Logger LOGGER = Logger.getLogger("Minecraft");
	private final SimplePluginPlayerListener playerListener = new SimplePluginPlayerListener(this);
	
	@Override
	public void onLoad() {
		LOGGER.log(Level.INFO, "SimplePlugin is being loaded!");
	}

	@Override
	public void onEnable() {
		final Server server = this.getServer();
		final PluginManager pm = server.getPluginManager();
		for (Plugin plugin : pm.getPlugins()) {
			if (plugin.getDescription().getName().startsWith("SimplePlugin")
					&& !plugin.getDescription().getVersion().equals(this.getDescription().getVersion())
					&& !plugin.getDescription().getName().equals("SimplePluginAntiCheat")) {
					LOGGER.log(Level.WARNING, "Version mismatch! Please update " + plugin.getDescription().getName() + " to the same version.");
				}
		}
		final Matcher versionMatch = Pattern.compile("git-Bukkit-(?:(?:[0-9]+)\\.)+[0-9]+-R[\\.0-9]+-(?:[0-9]+-g[0-9a-f]+-)?b([0-9]+)jnks.*").matcher(getServer().getVersion());
		if (versionMatch.matches()) {
			final int versionNumber = Integer.parseInt(versionMatch.group(1));
			if (versionNumber < BUKKIT_VERSION && versionNumber > 100) {
				LOGGER.log(Level.SEVERE, " * ! * ! * ! * ! * ! * ! * ! * ! * ! * ! * ! * ! *");
				LOGGER.log(Level.SEVERE, " * ! * Bukkit version is not the recommended build for SimplePlugin.");
				LOGGER.log(Level.SEVERE, " * ! * You need atleast build " + Integer.toString(BUKKIT_VERSION) + " of CraftBukkit, download it from http://dl.bukkit.org/downloads/craftbukkit/");
				LOGGER.log(Level.SEVERE, " * ! * ! * ! * ! * ! * ! * ! * ! * ! * ! * ! * ! *");
				this.setEnabled(false);
				return;
			}
		} else {
			LOGGER.log(Level.INFO, "Bukkit version format changed. Version not checked.");
			LOGGER.log(Level.INFO, getServer().getVersion());
			LOGGER.log(Level.INFO, getServer().getBukkitVersion());
		}
		try {
			Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Error lost response to report.mcstats.org");
		}
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		
		getLogger().info("SimplePlugin has been enabled!");
		pm.registerEvents(playerListener, this);

		getCommand("simpleplugin").setExecutor(new Commandsimpleplugin(this));
		getCommand("ignite").setExecutor(new Commandignite(this));
		getCommand("Hideme").setExecutor(new Commandhideme(this));
		getCommand("freeitem").setExecutor(new Commandfreeitem(this));
		getCommand("freegift").setExecutor(new Commandfreegift(this));
		getCommand("healthy").setExecutor(new Commandhealthy(this));
		getCommand("Generateblock").setExecutor(new Commandgenerateblock(this));
		getCommand("rule").setExecutor(new Commandrule(this));
		getCommand("pm").setExecutor(new Commandpm(this));
		getCommand("KillPlayer").setExecutor(new Commandkillplayer(this));
		getCommand("explode").setExecutor(new Commandexplode(this));
		getCommand("teleport").setExecutor(new Commandteleport(this));
		getCommand("teleportto").setExecutor(new Commandteleportto(this));
		getCommand("ignite").setPermission("simpleplugin.burn");
		getCommand("ignite").setPermissionMessage("§4You do not have access to that command.");
		getCommand("Hideme").setPermission("simpleplugin.hideme");
		getCommand("Hideme").setPermissionMessage("§4You do not have access to that command.");
		getCommand("freeitem").setPermission("simpleplugin.freeitem");
		getCommand("freeitem").setPermissionMessage("§4You do not have access to that command.");
		getCommand("freegift").setPermission("simpleplugin.freeitem.give");
		getCommand("freegift").setPermissionMessage("§4You do not have access to that command.");
		getCommand("healthy").setPermission("simpleplugin.healthy");
		getCommand("healthy").setPermissionMessage("§4You do not have access to that command.");
		getCommand("Generateblock").setPermission("simpleplugin.generateblock");
		getCommand("Generateblock").setPermissionMessage("§4You do not have access to that command.");
		getCommand("pm").setPermission("simpleplugin.pm");
		getCommand("pm").setPermissionMessage("§4You do not have access to that command.");
		getCommand("KillPlayer").setPermission("simpleplugin.killplayer");
		getCommand("KillPlayer").setPermissionMessage("§4You do not have access to that command.");
		getCommand("explode").setPermission("simpleplugin.explode");
		getCommand("explode").setPermissionMessage("§4You do not have access to that command.");
		getCommand("teleport").setPermission("simpleplugin.teleport");
		getCommand("teleport").setPermissionMessage("§4You do not have access to that command.");
		getCommand("teleportto").setPermission("simpleplugin.teleport.others");
		getCommand("teleportto").setPermissionMessage("§4You do not have access to that command.");
	}

	@Override
	public void onDisable() {
		this.reloadConfig();
		
		this.getLogger().info("SimplePlugin has been disabled!");
	}
}