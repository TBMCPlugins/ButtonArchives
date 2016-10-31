package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.components.flairdoor.FlairDoorModule;
import alisolarflare.modules.components.gpowers.GPowerModule;
import alisolarflare.modules.components.links.AliLinkModule;
import alisolarflare.modules.components.shulker.AliShulkerModule;
import alisolarflare.modules.events.uhc.UHCModule;
import alisolarflare.modules.magictrick.aliarrow.AliArrowModule;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		registerModules();
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
	public void registerModules(){
		new FlairDoorModule().register(this);
		new GPowerModule().register(this);
		new AliLinkModule().register(this);
		new AliShulkerModule().register(this);
		new UHCModule().register(this);
		new AliArrowModule().register(this);
	}
}
