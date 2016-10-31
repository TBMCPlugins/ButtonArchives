package alisolarflare.uhc;

import alisolarflare.AliPresents;

public class UHCSubPlugin {
	public AliPresents plugin;
	public UHCMatch generalMemory;

	public UHCSubPlugin(AliPresents plugin){
		this.plugin = plugin;		
	}
	public void register(){
		registerCommands();
		registerListeners();
		registerMemoryUnits();
	}
	private void registerListeners() {
	}
	private void registerCommands() {
		// TODO Auto-generated method stub
		plugin.getCommand("addToUHC").setExecutor(new AddToUHC(this.generalMemory));
	}
	private void registerMemoryUnits(){
		generalMemory = new UHCMatch();
	}
	
}
