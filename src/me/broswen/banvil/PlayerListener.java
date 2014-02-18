package me.broswen.banvil;


import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener{
	public static BAnvil plugin;
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		plugin = BAnvil.plugin;
		
		if(event.getClickedBlock() == null){
			return;
		}
		
		if(event.getAction() != Action.RIGHT_CLICK_BLOCK){
			return;
		}
		
		if(player.hasPermission("banvil.use")){
			return;
		}
		
		if(!(event.getClickedBlock().getType() == Material.ANVIL)){
			return;
		}
		
		event.setCancelled(true);
		player.sendMessage(plugin.prefix + "You are not permitted to use anvils!");
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		plugin = BAnvil.plugin;
		
		if(event.getBlock() == null){
			return;
		}
		
		if(!(event.getBlock().getType() == Material.ANVIL)){
			return;
		}
		
		if(player.hasPermission("banvil.break")){
			return;
		}
		
		event.setCancelled(true);
		player.sendMessage(plugin.prefix + "You are not permitted to break anvils!");
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player player = event.getPlayer();
		plugin = BAnvil.plugin;
		
		if(event.getBlock() == null){
			return;
		}
		
		if(!(event.getBlock().getType() == Material.ANVIL)){
			return;
		}
		
		if(player.hasPermission("banvil.place")){
			return;
		}
		
		event.setCancelled(true);
		player.sendMessage(plugin.prefix + "You are not permitted to place anvils!");
	}
	
	@EventHandler
	public void onBlockDamage(BlockDamageEvent event){
		Player player = event.getPlayer();
		plugin = BAnvil.plugin;
		FileConfiguration config = plugin.getConfig();
		
		if(event.getBlock() == null){
			return;
		}
		
		if(!config.getBoolean("infinite")){
			return;
		}
		
		if(event.getBlock().getType() == Material.ANVIL){
			event.setCancelled(true);
		}
	}
	
	
}
