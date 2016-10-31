package alisolarflare.modules.components.flairdoor;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.components.flairdoor.commands.FlairMe;
import alisolarflare.modules.components.flairdoor.commands.SetFlairDoorColour;
import alisolarflare.modules.components.flairdoor.listeners.PortalListener;

public class FlairDoorModule extends Module{
	@SuppressWarnings("unused")
	private JavaPlugin plugin;
	public FlairDoorModule(JavaPlugin plugin){
		this.plugin = plugin;
	}
	@Override
	public void register(JavaPlugin plugin) {
		plugin.getCommand("flairme").setExecutor(new FlairMe());
		plugin.getCommand("setflairdoorcolour").setExecutor(new SetFlairDoorColour());	

		plugin.getServer().getPluginManager().registerEvents(new PortalListener(plugin), plugin);
	}
}
