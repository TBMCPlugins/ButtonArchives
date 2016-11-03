package alisolarflare.components.flairdoor;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.flairdoor.commands.FlairMe;
import alisolarflare.components.flairdoor.listeners.PortalListener;
import buttondevteam.lib.TBMCCoreAPI;
import buttondevteam.lib.chat.TBMCChatAPI;

public class FlairDoorModule extends Module {
	@Override
	public void register(JavaPlugin plugin) {
		TBMCChatAPI.AddCommands(plugin, FlairMe.class);

		TBMCCoreAPI.RegisterEventsForExceptions(new PortalListener(plugin), plugin);
	}
}
