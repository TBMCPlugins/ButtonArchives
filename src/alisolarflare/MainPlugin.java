package alisolarflare;

import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin{
	public void onEnable(){
		registerCommands();
	}
	public void registerCommands(){
		getCommand("alishulker").setExecutor(new AliShulker());
	}
}
