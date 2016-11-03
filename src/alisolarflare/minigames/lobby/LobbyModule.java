package alisolarflare.minigames.lobby;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.minigames.lobby.commands.ButtonFight;
import alisolarflare.minigames.lobby.commands.ButtonLeave;
import alisolarflare.minigames.lobby.commands.ListFighters;
import buttondevteam.lib.chat.TBMCChatAPI;

public class LobbyModule extends Module{
	public List<String> fighters;

	public void register(JavaPlugin plugin){
		registerEvents();
		registerCommands(plugin);
	}
	private void registerEvents() {
	}

	private void registerCommands(JavaPlugin plugin) {	
		TBMCChatAPI.AddCommands(plugin, ButtonFight.class);
		TBMCChatAPI.AddCommands(plugin, ButtonLeave.class);
		TBMCChatAPI.AddCommands(plugin, ListFighters.class);
	}
}
