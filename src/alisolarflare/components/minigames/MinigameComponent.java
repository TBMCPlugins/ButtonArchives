package alisolarflare.components.minigames;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.minigames.commands.JoinMinigame;
import alisolarflare.components.minigames.commands.LeaveMinigame;
import alisolarflare.components.minigames.commands.ListFighters;
import alisolarflare.components.minigames.commands.SetColourSpawn;
import alisolarflare.components.minigames.data.SpawnSet;

public class MinigameComponent extends Component{
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
