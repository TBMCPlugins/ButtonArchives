package alisolarflare.buttonminigames.lobby;

import alisolarflare.MainPlugin;
import alisolarflare.buttonminigames.lobby.commands.ButtonFight;
import alisolarflare.buttonminigames.lobby.commands.ButtonLeave;
import alisolarflare.buttonminigames.lobby.commands.ListFighters;

public class Lobby {
	private MainPlugin plugin;
	public Lobby(MainPlugin plugin){
		this.plugin = plugin;
	}
	public void register(){
		registerEvents();
		registerCommands();
	}
	private void registerEvents() {
	}

	private void registerCommands() {	
		plugin.getCommand("buttonfight").setExecutor(new ButtonFight(plugin));
		plugin.getCommand("buttonleave").setExecutor(new ButtonLeave(plugin));
		plugin.getCommand("listfighters").setExecutor(new ListFighters(plugin));
	}
}
