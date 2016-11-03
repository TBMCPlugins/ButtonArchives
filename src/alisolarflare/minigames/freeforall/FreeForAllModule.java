package alisolarflare.minigames.freeforall;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.minigames.freeforall.commands.SetFFAS;
import alisolarflare.minigames.freeforall.data.SpawnSet;
import buttondevteam.lib.chat.TBMCChatAPI;

public class FreeForAllModule extends Module{
	public SpawnSet spawnSet;
	private int GameState;
	
	@Override
	public void register(JavaPlugin plugin) {
		registerEvents();
		registerCommands(plugin);
		registerMemory();
	}

	private void registerEvents() {
	}

	private void registerCommands(JavaPlugin plugin) {
		TBMCChatAPI.AddCommand(plugin, SetFFAS.class, spawnSet);
	}
	private void registerMemory() {
		this.spawnSet = new SpawnSet();
	}
	public int getGameState() {return GameState;}
	public void setGameState(int gameState) {GameState = gameState;}
	
	
}
