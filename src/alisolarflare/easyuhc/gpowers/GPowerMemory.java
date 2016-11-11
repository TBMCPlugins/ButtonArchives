package alisolarflare.easyuhc.gpowers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class GPowerMemory{
	public Map<UUID, poweredPlayer> poweredPlayerList = new HashMap<UUID, poweredPlayer>();
	
	public void configurePlayer(Player player, String colour, boolean powerIsActive){
		poweredPlayerList.put(player.getUniqueId(), new poweredPlayer(player.getUniqueId(), colour, true));
	}
	public void PowerUpPlayer(Player player){
		player.sendMessage("Powering up!");
		if(poweredPlayerList.containsKey(player.getUniqueId())){
			poweredPlayerList.get(player.getUniqueId()).isPowersActive = true;
			player.sendMessage("Powered up!");
		}else{
			player.sendMessage("You must instantiate your power settings using /GPower");
		}
	}
	
	public void PowerDownPlayer(Player player){
		player.sendMessage("Powering down!");
		if (poweredPlayerList.containsKey(player.getUniqueId())){
			player.sendMessage("Powered down!");
			poweredPlayerList.get(player.getUniqueId()).isPowersActive = false;
		}else{
			player.sendMessage("P down!");
			return;
		}
		
	}
	
	public class poweredPlayer{
		public UUID uuid;
		public String colour;
		public Boolean isPowersActive;

		public poweredPlayer(UUID uuid, String colour, Boolean activated){
			this.uuid = (uuid);
			this.colour = (colour);
			this.isPowersActive = (activated);
		}
		public String toString(){
			return "[UUID: "+ uuid.toString() + ", Colour: "+ colour+", IsActivated: "+isPowersActive + "]";
		}
	}
}

