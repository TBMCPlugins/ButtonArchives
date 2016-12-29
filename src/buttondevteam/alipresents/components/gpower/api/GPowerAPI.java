package buttondevteam.alipresents.components.gpower.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import buttondevteam.alipresents.components.gpower.PoweredPlayer;

public class GPowerAPI{
	public static final int defaultPowerLength = 300;
	public static Map<UUID, PoweredPlayer> poweredPlayerList = new HashMap<UUID, PoweredPlayer>();
	
	public static void addPlayer(Player player, String colour, boolean powerIsActive){
		poweredPlayerList.put(player.getUniqueId(), new PoweredPlayer(player.getUniqueId(), colour, true));
	}
	public static void PowerUpPlayer(Player player, String colour){
		PowerUpPlayer(player);
	}
	public static void PowerUpPlayer(Player player){
		player.sendMessage("Powering up!");
		if(poweredPlayerList.containsKey(player.getUniqueId())){
			poweredPlayerList.get(player.getUniqueId()).isPowersActive = true;
			player.sendMessage("Powered up!");
		}else{
			player.sendMessage("You must instantiate your power settings using /GPower");
		}
	}
	public static void PowerUpAllPlayers(){
		for (PoweredPlayer poweredPlayer : GPowerAPI.poweredPlayerList.values()){
			poweredPlayer.isPowersActive = true;
		}
	}
	
	public static boolean PowerDownPlayer(Player player){
		player.sendMessage("Powering down!");
		if (poweredPlayerList.containsKey(player.getUniqueId())){
			player.sendMessage("Powered down!");
			poweredPlayerList.get(player.getUniqueId()).isPowersActive = false;
			return true;
		}else{
			player.sendMessage("P down!");
			return false;
		}
		
	}
	public static void activatePower(Player player){
		 activatePower(player, poweredPlayerList.get(player.getUniqueId()).colour, defaultPowerLength);
	}
	public static void activatePower(Player player, String colour){
		activatePower(player, colour, defaultPowerLength);
	}
	public static void activatePower(Player player, String colour, int powerLength) {
		//GREY
		for (PotionEffect potionEffect : player.getActivePotionEffects()){
			player.removePotionEffect(potionEffect.getType());
		}
		if ((colour.startsWith("grey") || colour.startsWith("gra")) && (player.getWorld().getTime() > 12575 && player.getWorld().getTime() < 22925)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, powerLength, 0, true, false, Color.GRAY), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, powerLength+100, 0, true, false, Color.GRAY), true);
		//RED
		}else if (colour.startsWith("r")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, powerLength, 0, true, false, Color.RED), true);
		//ORANGE
		}else if (colour.startsWith("o")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, powerLength, 0, true, false, Color.ORANGE), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, powerLength, 0, true, false, Color.ORANGE), true);
		//YELLOW
		}else if (colour.startsWith("y") && player.getLocation().getBlock().getLightFromSky() == 15 && player.getLocation().getBlock().getLightFromBlocks() == 15){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, powerLength, 0, true, false, Color.YELLOW), true);
		//GREEN
		}else if (colour.startsWith("g") && !colour.startsWith("gra") && !colour.startsWith("grey")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, powerLength, 1, true, false, Color.GREEN), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, powerLength, 0, true, false, Color.GREEN), true);
		//BLUE
		}else if (colour.startsWith("b")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, powerLength, 1, true, false, Color.BLUE), true);
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, powerLength, 0, true, false, Color.BLUE), true);
		//PURPLE
		}else if (colour.startsWith("p")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, powerLength, 0, true, false, Color.PURPLE), true);
		//NULL
		}else{
		}
	}
	public static boolean playerHasActivePowers(Player player){
		return poweredPlayerList.containsKey(player.getUniqueId()) && poweredPlayerList.get(player.getUniqueId()).isPowersActive;
	}
	
	
}

