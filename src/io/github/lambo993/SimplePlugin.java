package io.github.lambo993;

import io.github.lambo993.commands.*;
import io.github.lambo993.listener.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePlugin extends JavaPlugin {

	public static final int BUKKIT_VERSION = 2900;
	public static final Logger LOGGER = Logger.getLogger("Minecraft");
	private final SimplePluginPlayerListener playerListener = new SimplePluginPlayerListener(this);

	@Override
	public void onEnable() {
		final Server server = this.getServer();
		final PluginManager pm = server.getPluginManager();
		for (Plugin plugin : pm.getPlugins()) {
			if (plugin.getDescription().getName().startsWith("SimplePlugin") && !plugin.getDescription().getVersion().equals(this.getDescription().getVersion())) {
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
			LOGGER.log(Level.INFO, server.getVersion());
			LOGGER.log(Level.INFO, server.getBukkitVersion());
		}
		try {
			new Metrics(this).start();
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Error lost response to report.mcstats.org");
		}
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.reloadConfig();
		
		getLogger().info("SimplePlugin has been enabled!");
		pm.registerEvents(playerListener, this);

		initCommands("§4You do not have access to that command.");
	}

	@Override
	public void onDisable() {
		this.saveConfig();
		
		this.getLogger().info("SimplePlugin has been disabled!");
	}

	private void initCommands(String permMessage) {
		getCommand("simpleplugin").setExecutor(new Commandsimpleplugin(this));
		getCommand("ignite").setExecutor(new Commandignite());
		getCommand("Hideme").setExecutor(new Commandhideme());
		getCommand("freeitem").setExecutor(new Commandfreeitem());
		getCommand("freegift").setExecutor(new Commandfreegift());
		getCommand("healthy").setExecutor(new Commandhealthy());
		getCommand("generateblock").setExecutor(new Commandgenerateblock());
		getCommand("rule").setExecutor(new Commandrule(this));
		getCommand("pm").setExecutor(new Commandpm());
		getCommand("killplayer").setExecutor(new Commandkillplayer());
		getCommand("explode").setExecutor(new Commandexplode(this));
		getCommand("teleport").setExecutor(new Commandteleport());
		getCommand("teleportto").setExecutor(new Commandteleportto());
		getCommand("helmet").setExecutor(new Commandhelmet());
		getCommand("ignite").setPermission("simpleplugin.burn");
		getCommand("ignite").setPermissionMessage(permMessage);
		getCommand("Hideme").setPermission("simpleplugin.hideme");
		getCommand("Hideme").setPermissionMessage(permMessage);
		getCommand("freeitem").setPermission("simpleplugin.freeitem");
		getCommand("freeitem").setPermissionMessage(permMessage);
		getCommand("freegift").setPermission("simpleplugin.freeitem.give");
		getCommand("freegift").setPermissionMessage(permMessage);
		getCommand("healthy").setPermission("simpleplugin.healthy");
		getCommand("healthy").setPermissionMessage(permMessage);
		getCommand("generateblock").setPermission("simpleplugin.generateblock");
		getCommand("generateblock").setPermissionMessage(permMessage);
		getCommand("pm").setPermission("simpleplugin.pm");
		getCommand("pm").setPermissionMessage(permMessage);
		getCommand("killplayer").setPermission("simpleplugin.killplayer");
		getCommand("killplayer").setPermissionMessage(permMessage);
		getCommand("explode").setPermission("simpleplugin.explode");
		getCommand("explode").setPermissionMessage(permMessage);
		getCommand("teleport").setPermission("simpleplugin.teleport");
		getCommand("teleport").setPermissionMessage(permMessage);
		getCommand("teleportto").setPermission("simpleplugin.teleport.others");
		getCommand("teleportto").setPermissionMessage(permMessage);
		getCommand("helmet").setPermission("simpleplugin.helmet");
		getCommand("helmet").setPermissionMessage(permMessage);
	}

	public static void main(String[] args) {
		System.out.println("Plugin Info");
		System.out.println("Plugin name: SimplePlugin");
		System.out.println("Plugin version: 0.7.4");
		System.out.println("Plugin authors: Lambo993 and Kjordo711");
		System.out.println("Required Bukkit version: 1.6.4 build " + BUKKIT_VERSION);
	}
}