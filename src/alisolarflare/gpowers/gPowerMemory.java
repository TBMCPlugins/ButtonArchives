package alisolarflare.gpowers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import alisolarflare.AliPresents;

public class gPowerMemory {
	private AliPresents plugin;
	private boolean debugMode = true;
	public gPowerMemory(AliPresents plugin){
		this.plugin = plugin;
	}
	//SHORT TERM MEMORY STORAGE
	public static Map<UUID, poweredPlayer> PlayerMap = new HashMap<UUID, poweredPlayer>();
	
	//POWER ACTIVATION
	public static void PowerUpPlayer(Player player, String colour){
		if (PlayerMap.containsKey(player.getUniqueId())){
			PlayerMap.get(player.getUniqueId()).playerPowersActivated = true;
		}else{
			PlayerMap.put(player.getUniqueId(), new poweredPlayer(player.getUniqueId(), colour, true));
		}
	}
	
	//POWER DEACTIVATION
	public static void PowerDownPlayer(Player player){
		if (PlayerMap.containsKey(player.getUniqueId())){
			PlayerMap.get(player.getUniqueId()).playerPowersActivated = false;
		}else{
			return;
		}
		
	}
	public static void PowerDownPlayer(UUID UniqueID){
		if (PlayerMap.containsKey(UniqueID)){
			PlayerMap.get(UniqueID).playerPowersActivated = false;
		}else{
			return;
		}
	}
	public static boolean isPlayerPowered(UUID UniqueID){
		if (PlayerMap.containsKey(UniqueID)){
			return PlayerMap.get(UniqueID).playerPowersActivated;
		}else{
			return false;
		}
	}
	public static boolean isPlayerPowered(Player player){
		if (PlayerMap.containsKey(player.getUniqueId())){
			return PlayerMap.get(player.getUniqueId()).playerPowersActivated;
		}else{
			return false;
		}
	}
	//MEMORY UNIT
	public static class poweredPlayer{
		public UUID uuid;
		public String colour;
		public Boolean playerPowersActivated;

		public poweredPlayer(UUID uuid, String colour, Boolean activated){
			this.uuid = (uuid);
			this.colour = (colour);
			this.playerPowersActivated = (activated);
		}
		public String toString(){
			return "[UUID: "+ uuid.toString() + ", Colour: "+ colour+", IsActivated: "+playerPowersActivated + "]";
		}
	}
	
	//DEBUG
	@SuppressWarnings({ "deprecation" })
	public void debug(String debugString){
		if (plugin.getServer().getPlayer("alisolarflare").isOnline() && debugMode == true){
			plugin.getServer().getPlayer("alisolarflare").sendMessage("[gPowerTest]:"+debugString);
		}
	}
}

