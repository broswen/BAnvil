package me.broswen.banvil;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BAnvil extends JavaPlugin{
	public static BAnvil plugin;
	
	@Override
	public void onEnable(){
		
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		return true;
	}
}
