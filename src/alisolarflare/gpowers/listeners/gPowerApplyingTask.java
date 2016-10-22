package alisolarflare.gpowers.listeners;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.AliPresents;
import alisolarflare.gpowers.gPowerMemory;

public class gPowerApplyingTask extends BukkitRunnable{
	
	private AliPresents plugin;;

	public gPowerApplyingTask(AliPresents plugin) {
		this.plugin = plugin;
	}
	
	//REPEATS EVERY 5 SECONDS
	@Override
	public void run() {
		for (Player player : plugin.getServer().getOnlinePlayers()){
			if(gPowerMemory.PlayerMap.containsKey(player.getUniqueId())){
				activatePower(player, gPowerMemory.PlayerMap.get(player.getUniqueId()).colour);
			}
		}
	}

	private void activatePower(Player player, String colour) {
		if ((colour.startsWith("grey") || colour.startsWith("gra")) && (player.getWorld().getTime() > 12575 && player.getWorld().getTime() < 22925)){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1, true, false, Color.GRAY));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100, 1, true, false, Color.GRAY));
		}else if (colour.startsWith("r")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 1, true, false, Color.GRAY));
		}else if (colour.startsWith("o")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1, true, false, Color.GRAY));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1, true, false, Color.GRAY));
		}else if (colour.startsWith("y") && player.getLocation().getBlock().getLightFromSky() == 15){
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1, true, false, Color.GRAY));
		}else if (colour.startsWith("g")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 100, 1, true, false, Color.GRAY));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100, 1, true, false, Color.GRAY));
		}else if (colour.startsWith("b")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1, true, false, Color.GRAY));
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100, 1, true, false, Color.GRAY));
		}else if (colour.startsWith("p")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 100, 1, true, false, Color.GRAY));
		}		
	}
	
}
