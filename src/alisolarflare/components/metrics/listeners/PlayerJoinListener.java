package alisolarflare.components.metrics.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import alisolarflare.components.metrics.MetricsComponent;
import buttondevteam.lib.DebugPotato;
import buttondevteam.lib.DebugPotatoAPI;

public class PlayerJoinListener implements Listener{
	
	private MetricsComponent module;
	public PlayerJoinListener(MetricsComponent module){
		this.module = module;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		try{
			module.saveData(module.metricsYml, "loginlog."+System.currentTimeMillis()+event.getPlayer().getName(), event.getPlayer().getName());
		}catch(NullPointerException e){
			try{
				DebugPotato potato = new DebugPotato();
				potato.setMessage(new String[]{
						"Module: "+ module.toString(),
						"Time: " + System.currentTimeMillis(),
						"MetricsYML: " + module.metricsYml.toString()
				});
				DebugPotatoAPI.SendDebugPotato(potato, event.getPlayer());
			}catch (Exception ex){
				DebugPotato potato = new DebugPotato();
				potato.setMessage("Something went REALLLY wrong");
				DebugPotatoAPI.SendDebugPotato(potato, event.getPlayer());
			}
		}
		module.metricsList.add("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		
	}
}
