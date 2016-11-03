package alisolarflare.buttonminigames.freeforall;


import alisolarflare.MainPlugin;
import alisolarflare.buttonminigames.freeforall.commands.SetFFAS;
import alisolarflare.buttonminigames.freeforall.data.SpawnSet;

public class Freeforall {
	private MainPlugin plugin;
	public SpawnSet spawnSet;
	private int GameState;
	
	public Freeforall(MainPlugin plugin){
		this.plugin = plugin;
		this.spawnSet = new SpawnSet();
	}
	public void register(){
		registerEvents();
		registerCommands();
	}
	private void registerEvents() {
	}

	private void registerCommands() {
		plugin.getCommand("setFFAS").setExecutor(new SetFFAS(plugin, spawnSet));			
	}
	public int getGameState() {return GameState;}
	public void setGameState(int gameState) {GameState = gameState;}
}
