package alisolarflare.components.flairdoor.listeners;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;

public class PortalListener implements Listener{
	AbstractMap<String,Location> portalMap = new HashMap<String,Location>();
	public static List<String> playersToBeFlaired = new ArrayList<String>();
	public JavaPlugin plugin;
	
	//TODO: CREATE - LIST OF PORTALS (only x-z values)
	
	
	public PortalListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event){
		//SANITATION - Player
		if(!(event.getPlayer() instanceof Player)){
			return;
		}
		
		//INIT - Player
		Player player = event.getPlayer();
		
		//SANITATION - PlayersToBeFlaired
		if(!(playersToBeFlaired.contains(player.getName()))){
			return;
		}
		player.sendMessage("-MAY THE FLAIRING COMMENCE-");
		player.sendMessage("Deactivating regular portal behaviour...");
		event.setTo(player.getLocation());
		
		//INIT - x,y,z
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		//INIT - Blocks Under Portal
		Block HigherBlock = player.getWorld().getBlockAt(x,y-1,z);
		Block MiddleBlock = player.getWorld().getBlockAt(x,y-2,z);
		Block BottomBlock = player.getWorld().getBlockAt(x,y-3,z);
		
		player.sendMessage("Blocks being inspected:");
		player.sendMessage(HigherBlock.toString());
		player.sendMessage(MiddleBlock.toString());
		player.sendMessage(BottomBlock.toString());
		
		//RECOLOUR PLAYER
		if(HigherBlock.getType() == Material.STONE){
			player.sendMessage("STONE DETECTED");
			recolourPlayer(player, DyeColor.GRAY);
			
		//TOP BLOCK IS WOOL?
		}else if(HigherBlock.getType() == Material.WOOL){
			player.sendMessage("WOOL DETECTED T");
			Wool wool = (Wool) HigherBlock.getState().getData();
			recolourPlayer(player, wool.getColor());
		
		//MIDDLE BLOCK IS WOOL?
		}else if(MiddleBlock.getType() == Material.WOOL){

			player.sendMessage("WOOL DETECTED M");
			MaterialData mData = MiddleBlock.getState().getData();
			player.sendMessage("MATERIAL DATA COLLECTED: "+ mData.toString());
			Wool wool = (Wool) mData;
			player.sendMessage("WOOL DATA CONVERTED: "+ wool.toString());

			recolourPlayer(player, wool.getColor());
		
		//BOTTOM BLOCK IS WOOL?
		}else if (BottomBlock.getType() == Material.WOOL){
			player.sendMessage("WOOL DETECTED B");
			Wool wool = (Wool) BottomBlock.getState().getData();
			recolourPlayer(player, wool.getColor());
		}
		
	}
	public void recolourPlayer(Player player, DyeColor dyecolour){
		player.sendMessage("Recolouring Player as..." + dyecolour.toString());
		String name = player.getName();
		player.sendMessage("name:" + name);
		for(int i = 0; i < name.length(); i++){
			if (name.charAt(i) == '&'){
				//TODO: Remove all &* symbols
				name = name.substring(0, i) + name.substring(i + 1, name.length());
				
			}
		}
		player.sendMessage("Adjusted Name: " + name);
		
		if(dyecolour == DyeColor.GRAY){
			player.sendMessage("Adding GRAY");
			player.setCustomName("&7" + name);
			
		}else if(dyecolour == DyeColor.RED){
			player.sendMessage("Adding RED");
			player.setCustomName("&4" + name);
			
		}else if(dyecolour == DyeColor.ORANGE){
			player.sendMessage("Adding ORANGE");
			player.setCustomName("&6" + name);
			
		}else if(dyecolour == DyeColor.YELLOW){
			player.sendMessage("Adding YELLOW");
			player.setCustomName("&e" + name);
			
		}else if(dyecolour == DyeColor.GREEN){
			player.sendMessage("Adding GREEN");
			player.setCustomName("&a" + name);
			
		}else if(dyecolour == DyeColor.BLUE){
			player.sendMessage("Adding BLUE");
			player.setCustomName("&9" + name);
			
		}else if(dyecolour == DyeColor.PURPLE){
			player.sendMessage("Adding PURPLE");
			player.setCustomName("&5" + name);
			
		}else{
			player.sendMessage("ERROR, PORTAL HAS INVALID UNDER-BLOCK");
			return;
		}
		player.sendMessage("Your name is now: " + player.getCustomName() +"! Removing you from playersToBeFlaired...");
		playersToBeFlaired.remove(player.getName());
	}
}
