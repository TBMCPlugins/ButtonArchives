package alisolarflare.components.metrics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import alisolarflare.components.metrics.MetricsModule;

public class PlayerJoinListener implements Listener{
	
	private MetricsModule module;
	public PlayerJoinListener(MetricsModule module){
		this.module = module;
	}
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent event){
		module.saveData(module.metricsYml, "loginlog."+System.currentTimeMillis()+event.getPlayer().getName(), event.getPlayer().getName());
		module.metricsList.add("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		event.getPlayer();
	}
}
