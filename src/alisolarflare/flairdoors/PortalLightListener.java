package alisolarflare.flairdoors;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.entity.EntityPortalEvent;

public class PortalLightListener implements Listener{
	
	//TODO: CREATE - LIST OF PORTALS (only x-z values)
	
	
	@EventHandler
	public void onPortalLight(EntityCreatePortalEvent event){
		
		//SANITATION - entity > player
		if(!(event.getEntity() instanceof Player)){return;}
		Player player = (Player) event.getEntity();
		
		//SANITIATION - player > alisolarflare
		if(!(player.getName() == "alisolarflare")){return;}
		
		//TODO: MARK PORTAL
		if (SetFlairDoorColour.FlairDoorColorMode == "null"){
			player.sendMessage("Your Colour mode is set to Null, use /SetFlairDoorColour [Color] to specify a colour for this portal");
			return;
		}
		//TODO: SAVE PORTAL
	}
	
	@EventHandler
	public void onPortalEnter(EntityPortalEvent event){
		event.setCancelled(false);
		
		//TODO: IF PLAYER LOCATION IS INSIDE A COLOUR PORTAL
		//TODO: IF PLAYER NOT FLAIRED
		//TODO: IF PLAYERSTATE IS TRUE
		//TODO: CHANGE CUSTOM DISPLAY NAME
		//TODO: TELEPORT TO SPAWN
		//TODO: MARK PLAYER AS COLOURED
		
	}
}
