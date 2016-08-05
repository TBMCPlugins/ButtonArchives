package alisolarflare;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.links.AliLinkSubPlugin;
import alisolarflare.shulker.AliShulker;

public class MainPlugin extends JavaPlugin{
	public void onEnable(){
		registerSubPlugins();
		registerCommands();
	}
	public void registerSubPlugins(){
		AliLinkSubPlugin alilinksubplugin = new AliLinkSubPlugin(this);
		alilinksubplugin.register();
	}
	public void registerCommands(){
		getCommand("alishulker").setExecutor(new AliShulker());
	}
}
