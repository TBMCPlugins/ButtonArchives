package alisolarflare.components.metrics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import alisolarflare.components.metrics.MetricsModule;

public class PlayerLoginListener implements Listener{
	
	private MetricsModule module;
	public PlayerLoginListener(MetricsModule module){
		this.module = module;
	}
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event){
		module.saveData(module.metricsYml, "loginlog."+System.currentTimeMillis()+event.getPlayer().getName(), event.getPlayer().getName());
		module.metricsList.add("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		event.getPlayer();
	}
}
