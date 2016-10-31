package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.components.flairdoor.listeners.PortalListener;
import alisolarflare.modules.magictrick.aliarrow.AliArrowModule;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		registerModules();
		registerEvents();
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
	private void registerEvents() {
	}
	public void registerModules(){
		new AliArrowModule(this).register();
	}
}
