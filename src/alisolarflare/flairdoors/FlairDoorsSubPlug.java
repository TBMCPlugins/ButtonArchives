package alisolarflare.flairdoors;

import alisolarflare.AliPresents;

public class FlairDoorsSubPlug{
	private AliPresents plugin;
	public FlairDoorsSubPlug(AliPresents plugin){
		this.plugin = plugin;
	}
	public void register(){
		registerCommands();
		registerEvents();
	}
	private void registerCommands() {
		plugin.getCommand("FlairMe").setExecutor(new FlairMe());
	}
	private void registerEvents() {
		// TODO Auto-generated method stub

	}
}
