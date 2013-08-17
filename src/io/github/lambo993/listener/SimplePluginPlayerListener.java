package io.github.lambo993.listener;

import io.github.lambo993.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SimplePluginPlayerListener implements Listener {
	
	private SimplePlugin plugin;

	public SimplePluginPlayerListener(SimplePlugin instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(plugin.getConfig().getString("WelcomeMessage"));
		if (player.hasPermission("simpleplugin.event.joingift")) {
			PlayerInventory inventory = player.getInventory();
			ItemStack diamondstack = new ItemStack(Material.DIAMOND, 64);
			ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
			ItemStack emeraldstack = new ItemStack(Material.EMERALD, 64);
			ItemStack emerald = new ItemStack(Material.EMERALD, 1);
			
			if (inventory.contains(diamondstack) && inventory.contains(emeraldstack)) {
				inventory.addItem(diamond);
				inventory.addItem(emerald);
				player.sendMessage("Welcome you seem to be realy rich! so we gave you another stack of diamond!");
			}
		}
		if (player.isOp()) {
			player.getServer().broadcastMessage(plugin.getConfig().getString("operatorjoinmsg").replace("%operator%", player.getDisplayName()));
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteractBlock(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission("simpleplugin.event.thunder")) {
			if (player.getItemInHand().getType() == Material.FISHING_ROD) {
				 player.getWorld().strikeLightning(player.getTargetBlock(null, 200).getLocation());
			}
		}
		if (player.hasPermission("simpleplugin.event.explode")) {
			if (player.getItemInHand().getType() == Material.WOOD_HOE) {
			if (event.getClickedBlock().getType() == Material.AIR) {
					event.setCancelled(true);
			}else{
				player.getWorld().createExplosion(player.getLocation(), 15F, plugin.getConfig().getBoolean("explosion-fire", false));
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerEntityInteract(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission("simpleplugin.event.ignite")) {
			if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
				Player rightClicked = (Player) event.getRightClicked();
				rightClicked.setFireTicks(60 * 20);
			}
		}
		if (player.hasPermission("simpleplugin.event.heal")) {
			if (player.getItemInHand().getType() == Material.STICK) {
				Player rightClicked = (Player) event.getRightClicked();
				rightClicked.setHealth(20.0);
			}
		}
	}
}
