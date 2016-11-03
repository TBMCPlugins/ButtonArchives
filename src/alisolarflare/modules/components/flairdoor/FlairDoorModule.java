package alisolarflare.modules.components.flairdoor;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.components.flairdoor.commands.FlairMe;
import alisolarflare.modules.components.flairdoor.listeners.PortalListener;
import buttondevteam.lib.TBMCCoreAPI;
import buttondevteam.lib.chat.TBMCChatAPI;

public class FlairDoorModule extends Module {
	@Override
	public void register(JavaPlugin plugin) {
		TBMCChatAPI.AddCommands(plugin, FlairMe.class);

		TBMCCoreAPI.RegisterEventsForExceptions(new PortalListener(plugin), plugin);
	}
}
