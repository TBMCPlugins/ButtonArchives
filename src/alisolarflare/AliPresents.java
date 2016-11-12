package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.alilinks.AliLinkComponent;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;
import alisolarflare.components.easyuhc.EasyUHCComponent;
import alisolarflare.components.flairdoor.FlairDoorComponent;
import alisolarflare.components.magic.MagicComponent;
import alisolarflare.components.minigames.MinigameModule;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		
		new FlairDoorComponent().register(this);
		new AliLinkComponent().register(this);
		new EasyUHCComponent().register(this);
		new MagicComponent().register(this);
		new MinigameModule().register(this);
		new CreativeBoundariesComponent().register(this);
		
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
}
