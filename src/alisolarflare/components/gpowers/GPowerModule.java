package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.gpowers.commands.gPowerCommand;
import alisolarflare.components.gpowers.listeners.gPowerListener;
import buttondevteam.lib.TBMCCoreAPI;
import buttondevteam.lib.chat.TBMCChatAPI;

public class GPowerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		TBMCChatAPI.AddCommands(plugin, gPowerCommand.class);

		TBMCCoreAPI.RegisterEventsForExceptions(new gPowerListener(plugin), plugin);
	}

}
