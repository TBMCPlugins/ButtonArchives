package alisolarflare.modules.minigames;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.minigames.commands.JoinMinigame;
import alisolarflare.modules.minigames.commands.LeaveMinigame;
import alisolarflare.modules.minigames.commands.ListFighters;
import alisolarflare.modules.minigames.commands.SetColourSpawn;
import alisolarflare.modules.minigames.data.SpawnSet;

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
