package alisolarflare.flairdoors;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;

import alisolarflare.AliPresents;

public class PortalListener implements Listener{
	AbstractMap<String,Location> portalMap = new HashMap<String,Location>();
	public List<String> playersToBeFlaired = new ArrayList<String>();
	private AliPresents plugin;
	
	//TODO: CREATE - LIST OF PORTALS (only x-z values)
	
	
	public PortalListener(AliPresents plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onPortalEnter(EntityPortalEvent event){
		if(!(event.getEntity() instanceof Player)){
			return;
		}
		Player player = (Player) event.getEntity();
		if(!(playersToBeFlaired.contains(player.getName()))){
			return;
		}
		
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		Material blockTopper = player.getWorld().getBlockAt(x,y-1,z).getType();
		Material blockMiddle = player.getWorld().getBlockAt(x,y-2,z).getType();
		Material blockBottom = player.getWorld().getBlockAt(x,y-3,z).getType();
		
		if(blockTopper == Material.STONE){
			
		}else if(blockTopper == Material.WOOL){
			
		}
		//TODO: IF PLAYER LOCATION IS INSIDE A COLOUR PORTAL
		//TODO: IF PLAYER NOT FLAIRED
		//TODO: IF PLAYERSTATE IS TRUE
		//TODO: CHANGE CUSTOM DISPLAY NAME
		//TODO: TELEPORT TO SPAWN
		//TODO: MARK PLAYER AS COLOURED
		
	}
	/*
	@EventHandler
	public void onAliRightClick(PlayerInteractEvent event){
		if (event.getPlayer().getName() != "alisolarflare"){
			return;
		}
		if (event.getClickedBlock().getType() != Material.OBSIDIAN){
			return;
		}
		if(event.getItem().getType() != Material.FLINT_AND_STEEL && event.getItem().getType() != Material.FIREBALL){
			return;
		}
		if(event.getAction() != Action.RIGHT_CLICK_BLOCK){
			return;
		}
		plugin.getServer().broadcastMessage("RIIIIGHTCLICK");
	}
	
	@EventHandler
	public void onPortalLight(PortalCreateEvent event){
		plugin.getServer().broadcastMessage("PORTAL LIIIIIT");
	}
	/*
	 *  NOTE: WRONG ENTITY EVENT ALLTOGETHER.
	 *  ENTITY CREATE PORTAL EVENT ONLY TRIGGERS WHEN AN ENDERDRAGON DIES
	 */
	/*
	@EventHandler
	public void onPortalLight(EntityCreatePortalEvent event){
		plugin.getServer().broadcastMessage("PORTAL LIT WHOOP WHOOP");
		plugin.getServer().broadcastMessage(event.getEntity().getName());
		//SANITATION - entity > player
		if(!(event.getEntity() instanceof Player)){return;}
		Player player = (Player) event.getEntity();
		event.getEntity().getServer().broadcastMessage(player.getName());
		
		//SANITIATION - player > alisolarflare
		if(!(player.getName() == "alisolarflare")){return;}
		event.getEntity().getServer().broadcastMessage(SetFlairDoorColour.FlairDoorColorMode);
		//SANITATION - FlairDoorColourMode
		if (SetFlairDoorColour.FlairDoorColorMode == "null"){
			player.sendMessage("Your Colour mode is set to Null, use /SetFlairDoorColour [Color] to specify a colour for this portal");
			return;
		}

		//INIT - colourMode, portalLocation
		String colourMode = SetFlairDoorColour.FlairDoorColorMode;
		Location portalLocation = event.getBlocks().get(0).getBlock().getLocation();
		event.getEntity().getServer().broadcastMessage(portalLocation.toString()); 
		//SAVE - Portal
		if(SetFlairDoorColour.COLOURMODES.contains(colourMode)){
			for (BlockState blockstate : event.getBlocks()){
				player.sendMessage(blockstate.getBlock().getLocation().toString());
			}
			portalMap.put(colourMode, portalLocation);
		}
	}
	*/
	
	
}
