package alisolarflare.components.gpowers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import alisolarflare.AliPresents;

public class gPowerMemory{
	@SuppressWarnings("unused")
	private static AliPresents plugin;
	@SuppressWarnings("unused")
	private static boolean debugMode = true;
	public gPowerMemory(AliPresents plugin){
		gPowerMemory.plugin = plugin;
	}
	//SHORT TERM MEMORY STORAGE
	public static Map<UUID, poweredPlayer> PlayerMap = new HashMap<UUID, poweredPlayer>();
	
	//POWER ACTIVATION
	public static void PowerUpPlayer(Player player, String colour){
		//debug("POWERRRED UP");
		player.sendMessage("POWERRED UP!");
		PlayerMap.put(player.getUniqueId(), new poweredPlayer(player.getUniqueId(), colour, true));
	}
	public static void PowerUpPlayer(Player player){
		//debug("POWERRRED UP");
		player.sendMessage("POWERRED UP!");
		if(PlayerMap.containsKey(player.getUniqueId())){
			PlayerMap.get(player.getUniqueId()).isPowersActive = true;
		}else{
			player.sendMessage("You must instantiate your power settings using /gpowercommand");
		}
	}
	
	//POWER DEACTIVATION
	public static void PowerDownPlayer(Player player){
		//debug("POWERRRED DOWN");
		if (PlayerMap.containsKey(player.getUniqueId())){
			PlayerMap.get(player.getUniqueId()).isPowersActive = false;
		}else{
			return;
		}
		
	}
	public static void PowerDownPlayer(UUID UniqueID){
		//debug("POWEERRED DOWN");
		if (PlayerMap.containsKey(UniqueID)){
			PlayerMap.get(UniqueID).isPowersActive = false;
		}else{
			return;
		}
	}
	public static boolean isPlayerPowered(UUID UniqueID){
		//debug("IS PLAYER POWERED?");
		if (PlayerMap.containsKey(UniqueID)){
			return PlayerMap.get(UniqueID).isPowersActive;
		}else{
			return false;
		}
	}
	public static boolean isPlayerPowered(Player player){
		//debug("IS PLAYER POWERED?");
		if (PlayerMap.containsKey(player.getUniqueId())){
			return PlayerMap.get(player.getUniqueId()).isPowersActive;
		}else{
			return false;
		}
	}
	//MEMORY UNIT
	public static class poweredPlayer{
		public static UUID uuid;
		public String colour;
		public Boolean isPowersActive;

		@SuppressWarnings("static-access")
		public poweredPlayer(UUID uuid, String colour, Boolean activated){
			this.uuid = (uuid);
			this.colour = (colour);
			this.isPowersActive = (activated);
		}
		public String toString(){
			return "[UUID: "+ uuid.toString() + ", Colour: "+ colour+", IsActivated: "+isPowersActive + "]";
		}
	}
	
	public void saveMemoryState(){
		@SuppressWarnings("unused")
		Map<UUID, poweredPlayer> PlayerMap = new HashMap<UUID, poweredPlayer>();
		//for (UUID uuidKey:PlayerMap.keySet()){
			
			//UUID uuidToSave = poweredPlayer.uuid;
			
		//}
	}
	public void loadMemoryState(){
		
	}
}

