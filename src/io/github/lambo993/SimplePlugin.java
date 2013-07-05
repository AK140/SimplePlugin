package io.github.lambo993;

import io.github.lambo993.Commands.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePlugin extends JavaPlugin {
	
	public static final int BUKKIT_VERSION = 2794;

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		
		this.getLogger().info("SimplePlugin has been enabled!");
		
		getCommand("simpleplugin").setExecutor(new Commandsimpleplugin(this));
		getCommand("ignite").setExecutor(new Commandignite(this));
		getCommand("FreeItem").setExecutor(new Commandfreeitem(this));
		getCommand("healthy").setExecutor(new Commandhealthy(this));
		getCommand("Generateblock").setExecutor(new Commandgenerateblock(this));
		getCommand("rule").setExecutor(new Commandrule(this));
		getCommand("echo").setExecutor(new Commandecho(this));
		getCommand("pm").setExecutor(new Commandpm(this));
		getCommand("ignite").setPermission("simpleplugin.burn");
		getCommand("ignite").setPermissionMessage("§4You do not have access to that command.");
		getCommand("FreeItem").setPermission("simpleplugin.freeitem");
		getCommand("FreeItem").setPermissionMessage("§4You do not have access to that command.");
		getCommand("healthy").setPermission("simpleplugin.healthy");
		getCommand("healthy").setPermissionMessage("§4You do not have access to that command.");
		getCommand("Generateblock").setPermission("simpleplugin.generateblock");
		getCommand("Generateblock").setPermissionMessage("§4You do not have access to that command.");
		getCommand("rule").setPermission("simpleplugin.rule");
		getCommand("rule").setPermissionMessage("§4You do not have access to that command.");
		getCommand("echo").setPermission("simpleplugin.echo");
		getCommand("echo").setPermissionMessage("§4You do not have access to that command.");
		getCommand("pm").setPermission("simpleplugin.pm");
		getCommand("pm").setPermissionMessage("§4You do not have access to that command.");
	}
	
	@Override
	public void onDisable() {
		this.reloadConfig();
		
		this.getLogger().info("SimplePlugin has been disabled!");
	}
}