/*package graveyard.minigames;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import graveyard.minigames.commands.JoinMinigame;
import graveyard.minigames.commands.LeaveMinigame;
import graveyard.minigames.commands.ListFighters;
import graveyard.minigames.commands.SetColourSpawn;
import graveyard.minigames.data.SpawnSet;

public class MinigameComponent extends Component{
	public SpawnSet spawnSet;
	public List<String> fighters;
	public GameState gameState;
	
	@Override
	public void register(JavaPlugin plugin) {
		this.spawnSet = new SpawnSet();
		registerCommand(plugin, new SetColourSpawn(spawnSet));
		registerCommand(plugin, new JoinMinigame(this));
		registerCommand(plugin, new LeaveMinigame(this));
		registerCommand(plugin, new ListFighters(this));
		
	}
	public class Fighter {
		public Player player;
		public String colour;
		public Fighter(Player player, String colour){
			this.colour = colour;
		}
	}
}
*/