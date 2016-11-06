package alisolarflare.components.gpowers;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Listener_PowerLooper implements Listener{
	
	public Listener_PowerLooper(JavaPlugin plugin, Memory_GPower gPowerMemory){
		new Task_PowerApplier(plugin.getServer(), gPowerMemory.poweredPlayerList).runTaskTimer(plugin, 190, 190);
	}		
}