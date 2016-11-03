package alisolarflare.minigames.lobby;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.minigames.lobby.commands.ButtonFight;
import alisolarflare.minigames.lobby.commands.ButtonLeave;
import alisolarflare.minigames.lobby.commands.ListFighters;

public class LobbyModule extends Module{
	public List<String> fighters;

	public void register(JavaPlugin plugin){
		registerEvents();
		registerCommands(plugin);
	}
	private void registerEvents() {
	}

	private void registerCommands(JavaPlugin plugin) {	
		plugin.getCommand("buttonfight").setExecutor(new ButtonFight(this));
		plugin.getCommand("buttonleave").setExecutor(new ButtonLeave(this));
		plugin.getCommand("listfighters").setExecutor(new ListFighters(this));
	}
}
