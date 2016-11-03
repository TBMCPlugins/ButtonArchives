package alisolarflare.events.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.events.uhc.commands.AddToUHC;
import alisolarflare.events.uhc.memory.UHCMatch;
import buttondevteam.lib.chat.TBMCChatAPI;

public class UHCModule extends Module {
	public UHCMatch match;

	public void register(JavaPlugin plugin) {
		registerCommands(plugin);
		registerListeners(plugin);
		registerMemoryUnits(plugin);
	}

	private void registerListeners(JavaPlugin plugin) {
	}

	private void registerCommands(JavaPlugin plugin) {
		TBMCChatAPI.AddCommands(plugin, AddToUHC.class);
	}

	private void registerMemoryUnits(JavaPlugin plugin) {
		match = new UHCMatch(plugin.getConfig(), plugin.getConfig().getString("UHCMatchState"));
	}
}
