package alisolarflare.minigames;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.minigames.commands.JoinMinigame;
import alisolarflare.minigames.commands.LeaveMinigame;
import alisolarflare.minigames.commands.ListFighters;
import alisolarflare.minigames.commands.SetColourSpawn;
import alisolarflare.minigames.data.SpawnSet;

public class MinigameModule extends Module{
	public SpawnSet spawnSet;
	public List<String> fighters;
	private GameState gameState;
	
	@Override
	public void register(JavaPlugin plugin) {
		this.spawnSet = new SpawnSet();
		registerCommand(plugin, new SetColourSpawn(spawnSet));
		registerCommand(plugin, new JoinMinigame(this));
		registerCommand(plugin, new LeaveMinigame(this));
		registerCommand(plugin, new ListFighters(this));
		
	}
	
	public GameState getGameState() {return gameState;}
	public void setGameState(GameState gameState) {this.gameState = gameState;}
	
	
}
