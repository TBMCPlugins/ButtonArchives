package alisolarflare.flairdoors;

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
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.material.Wool;

import alisolarflare.AliPresents;

public class PortalListener implements Listener{
	AbstractMap<String,Location> portalMap = new HashMap<String,Location>();
	public List<String> playersToBeFlaired = new ArrayList<String>();
	public AliPresents plugin;
	
	//TODO: CREATE - LIST OF PORTALS (only x-z values)
	
	
	public PortalListener(AliPresents plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPortalEnter(EntityPortalEvent event){
		//SANITATION - Player
		if(!(event.getEntity() instanceof Player)){
			return;
		}
		
		//INIT - Player
		Player player = (Player) event.getEntity();
		
		//SANITATION - PlayersToBeFlaired
		if(!(playersToBeFlaired.contains(player.getName()))){
			return;
		}
		
		//INIT - x,y,z
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		//INIT - Blocks Under Portal
		Block blockTopper = player.getWorld().getBlockAt(x,y-1,z);
		Block blockMiddle = player.getWorld().getBlockAt(x,y-2,z);
		Block blockBottom = player.getWorld().getBlockAt(x,y-3,z);
		
		//RECOLOUR PLAYER
		if(blockTopper.getType() == Material.STONE){
			recolourPlayer(player, DyeColor.GRAY);
			
		//TOP BLOCK IS WOOL?
		}else if(blockTopper.getType() == Material.WOOL){
			Wool wool = (Wool) blockTopper;
			recolourPlayer(player, wool.getColor());
		
		//MIDDLE BLOCK IS WOOL?
		}else if(blockMiddle.getType() == Material.WOOL){
			Wool wool = (Wool) blockMiddle;
			recolourPlayer(player, wool.getColor());
		
		//BOTTOM BLOCK IS WOOL?
		}else if (blockBottom.getType() == Material.WOOL){
			Wool wool = (Wool) blockBottom;
			recolourPlayer(player, wool.getColor());
		}
		
	}
	public void recolourPlayer(Player player, DyeColor dyecolour){

		String name = player.getDisplayName();
		for(int i = 0; i < name.length(); i++){
			if (name.charAt(i) == '&'){
				//TODO: Remove all &* symbols
				name = name.substring(0, i) + name.substring(i + 1, name.length());
				
			}
		}
		
		if(dyecolour == DyeColor.GRAY){
		}else if(dyecolour == DyeColor.RED){
		}else if(dyecolour == DyeColor.ORANGE){
		}else if(dyecolour == DyeColor.YELLOW){
		}else if(dyecolour == DyeColor.GREEN){
		}else if(dyecolour == DyeColor.BLUE){
		}else if(dyecolour == DyeColor.PURPLE){
		}else{
			return;
		}
		playersToBeFlaired.remove(player.getName());
	}
}
