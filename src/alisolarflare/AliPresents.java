package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;
import alisolarflare.shulker.AliShulker;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		registerSubPlugins();
		registerCommands();
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
	public void registerSubPlugins(){
		AliLinkSubPlug alilinksubplugin = new AliLinkSubPlug(this);
		alilinksubplugin.register();
	}
	public void registerCommands(){
		getCommand("alishulker").setExecutor(new AliShulker());
	}
}
