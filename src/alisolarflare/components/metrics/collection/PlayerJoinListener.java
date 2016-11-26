package alisolarflare.components.metrics.collection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import alisolarflare.components.metrics.MetricsComponent;
import alisolarflare.components.metrics.files.MetricsFile;

public class PlayerJoinListener implements Listener{
	
	private MetricsComponent module;
	private MetricsFile playerLoginsFile;
	public PlayerJoinListener(MetricsComponent module, MetricsFile playerLoginsFile){
		this.module = module;
		this.playerLoginsFile = playerLoginsFile;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		playerLoginsFile.AddLine("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		module.metricsList.add("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		
	}
}
