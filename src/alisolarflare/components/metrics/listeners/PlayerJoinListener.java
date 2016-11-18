package alisolarflare.components.metrics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import alisolarflare.components.metrics.MetricsComponent;

public class PlayerJoinListener implements Listener{
	
	private MetricsComponent module;
	public PlayerJoinListener(MetricsComponent module){
		this.module = module;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		//module.saveData(module.metricsYml, "loginlog."+System.currentTimeMillis()+event.getPlayer().getName(), event.getPlayer().getName());
		module.metricsList.add("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		
	}
}
