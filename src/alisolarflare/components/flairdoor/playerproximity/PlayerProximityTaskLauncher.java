package alisolarflare.components.flairdoor.playerproximity;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.flairdoor.FlairDoorComponent;

public class PlayerProximityTaskLauncher implements Listener{
	public PlayerProximityTaskLauncher(JavaPlugin plugin, FlairDoorComponent component){
		new PlayerProximityTask(plugin, component).runTaskTimer(plugin, 0, 20);	
	}
}
