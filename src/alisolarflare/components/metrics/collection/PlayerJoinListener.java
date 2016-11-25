package alisolarflare.components.metrics.collection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import alisolarflare.components.metrics.MetricsComponent;
import buttondevteam.lib.DebugPotato;

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
				potato.Send(event.getPlayer());
			}catch (Exception ex){
				DebugPotato potato = new DebugPotato();
				potato.setMessage("Something went REALLLY wrong");
				potato.Send(event.getPlayer());
			}
		}
		module.metricsList.add("loginlog."+System.currentTimeMillis()+event.getPlayer().getName());
		
	}
}
