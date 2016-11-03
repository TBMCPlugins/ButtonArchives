package alisolarflare.buttonminigames.hero;


import alisolarflare.MainPlugin;

public class Hero {
	@SuppressWarnings("unused")
	private MainPlugin plugin;
	public Hero(MainPlugin plugin){
		this.plugin = plugin;
	}
	public void register(){
		registerEvents();
		registerCommands();
	}
	private void registerEvents() {
	}

	private void registerCommands() {		
	}
}
