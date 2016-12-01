package alisolarflare.components.gpowers.enchant;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import alisolarflare.components.gpowers.api.GPowerAPI;

public class EnchantingLoop extends BukkitRunnable implements Listener{
	private Server server;

	
	public EnchantingLoop(JavaPlugin plugin){
		this.server = plugin.getServer();
		this.runTaskTimer(plugin, 0, 190);
	}	
	
	//REPEATS EVERY 5 SECONDS
	@Override
	public void run() {
		for (Player player : server.getOnlinePlayers()){
			if(GPowerAPI.playerHasActivePowers(player)){
				GPowerAPI.activatePower(player);
			}
		}
	}


	
}
