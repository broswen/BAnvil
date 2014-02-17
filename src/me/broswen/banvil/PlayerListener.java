package me.broswen.banvil;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
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
		
		if(!player.hasPermission("banvil.use")){
			if(event.getClickedBlock().getType() == Material.ANVIL){
				event.setCancelled(true);
				player.sendMessage(plugin.prefix + "You are not permitted to use anvils!");
			}
		}
	}
	
	@EventHandler
	public void onBlockDamage(BlockDamageEvent event){
		Player player = event.getPlayer();
		
	}
	
	
}
