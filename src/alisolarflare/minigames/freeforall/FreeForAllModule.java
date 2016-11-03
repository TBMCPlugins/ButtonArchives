package alisolarflare.minigames.freeforall;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.minigames.freeforall.commands.SetFFAS;
import alisolarflare.minigames.freeforall.data.SpawnSet;

public class FreeForAllModule extends Module{
	public SpawnSet spawnSet;
	private int GameState;
	
	@Override
	public void register(JavaPlugin plugin) {
		registerMemory();
		registerEvents();
		registerCommands(plugin);
	}
	private void registerMemory() {
		this.spawnSet = new SpawnSet();
	}

	private void registerEvents() {
	}

	private void registerCommands(JavaPlugin plugin) {
		registerCommand(plugin, new SetFFAS(spawnSet));
	}
	
	public int getGameState() {return GameState;}
	public void setGameState(int gameState) {GameState = gameState;}
	
	
}
