package me.broswen.banvil;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BAnvil extends JavaPlugin{
	public static BAnvil plugin;
	public String prefix = ChatColor.DARK_GRAY + "[BAnvil] " + ChatColor.RESET;
	public final PlayerListener playerlistener = new PlayerListener();
	
	@Override
	public void onEnable(){
		loadConfig();
		this.plugin = this;
		getServer().getPluginManager().registerEvents(this.playerlistener, this);
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		PluginDescriptionFile pdfFile = this.getDescription();
		
		if(cmd.getName().equalsIgnoreCase("banvil")){
			if(!sender.hasPermission("banvil.info")){
				sender.sendMessage(ChatColor.GRAY + "You don't have permission!");
				return true;
			}
			
			if(sender instanceof Player){
				Player player = (Player) sender;
				
				player.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "====== BAnvil ======");
				player.sendMessage("Version: " + pdfFile.getVersion());
				player.sendMessage("Author: " + pdfFile.getAuthors());
				player.sendMessage("About: " + pdfFile.getDescription());
				player.sendMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "====== BAnvil ======");
			}else{
				getLogger().info("====== BAnvil ======");
				getLogger().info("Version: " + pdfFile.getVersion());
				getLogger().info("Author: " + pdfFile.getAuthors());
				getLogger().info("About: " + pdfFile.getDescription());
				getLogger().info("====== BAnvil ======");
			}
		}
		return true;
	}
	
	public void loadConfig(){
		saveDefaultConfig();
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
