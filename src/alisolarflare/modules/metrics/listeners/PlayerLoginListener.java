package alisolarflare.modules.metrics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import alisolarflare.modules.metrics.MetricsModule;

public class PlayerLoginListener implements Listener{
	
	private MetricsModule module;
	public PlayerLoginListener(MetricsModule module){
		this.module = module;
	}
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event){
		module.saveData(module.config, "loginlog."+System.currentTimeMillis(), event.getPlayer().getName());
		event.getPlayer();
	}
}
