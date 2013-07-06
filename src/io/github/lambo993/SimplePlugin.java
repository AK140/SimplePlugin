package io.github.lambo993;

import io.github.lambo993.Commands.*;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePlugin extends JavaPlugin {
	
	public static final int BUKKIT_VERSION = 2807;

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		this.getLogger().info("SimplePlugin has been enabled!");
		
		getServer().getPluginManager().registerEvents(new Listener() {
			
			@EventHandler
			public void playerJoin(PlayerJoinEvent event) {
				event.getPlayer().sendMessage(SimplePlugin.this.getConfig().getString("WelcomeMessage"));
			}
		},this);
		
		getCommand("simpleplugin").setExecutor(new Commandsimpleplugin(this));
		getCommand("ignite").setExecutor(new Commandignite(this));
		getCommand("FreeItem").setExecutor(new Commandfreeitem(this));
		getCommand("healthy").setExecutor(new Commandhealthy(this));
		getCommand("Generateblock").setExecutor(new Commandgenerateblock(this));
		getCommand("rule").setExecutor(new Commandrule(this));
		getCommand("pm").setExecutor(new Commandpm(this));
		getCommand("KillPlayer").setExecutor(new Commandkillplayer(this));
		getCommand("ignite").setPermission("simpleplugin.burn");
		getCommand("ignite").setPermissionMessage("§4You do not have access to that command.");
		getCommand("FreeItem").setPermission("simpleplugin.freeitem");
		getCommand("FreeItem").setPermissionMessage("§4You do not have access to that command.");
		getCommand("healthy").setPermission("simpleplugin.healthy");
		getCommand("healthy").setPermissionMessage("§4You do not have access to that command.");
		getCommand("Generateblock").setPermission("simpleplugin.generateblock");
		getCommand("Generateblock").setPermissionMessage("§4You do not have access to that command.");
		getCommand("pm").setPermission("simpleplugin.pm");
		getCommand("pm").setPermissionMessage("§4You do not have access to that command.");
		getCommand("KillPlayer").setPermission("simpleplugin.killplayer");
		getCommand("KillPlayer").setPermissionMessage("§4You do not have access to that command.");
	}
	
	@Override
	public void onDisable() {
		this.reloadConfig();
		
		this.getLogger().info("SimplePlugin has been disabled!");
	}
}