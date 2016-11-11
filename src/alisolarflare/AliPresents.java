package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.flairdoor.FlairDoorModule;
import alisolarflare.components.links.AliLinkModule;
import alisolarflare.creativeboundaries.CreativeBoundariesModule;
import alisolarflare.easyuhc.EasyUHCModule;
import alisolarflare.easyuhc.gpowers.GPowerModule;
import alisolarflare.magic.MagicModule;
import alisolarflare.minigames.MinigameModule;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		
		new FlairDoorModule().register(this);
		new GPowerModule().register(this);
		new AliLinkModule().register(this);
		new EasyUHCModule().register(this);
		new MagicModule().register(this);
		new MinigameModule().register(this);
		new CreativeBoundariesModule().register(this);
		
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
}
