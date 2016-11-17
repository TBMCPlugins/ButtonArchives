package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.alilinks.AliLinkComponent;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;
import alisolarflare.components.easyuhc.EasyUHCComponent;
import alisolarflare.components.flairdoor.FlairDoorComponent;
import alisolarflare.components.gpowers.GPowerComponent;
import alisolarflare.components.insurance.InsuranceComponent;
import alisolarflare.components.magic.MagicComponent;
import alisolarflare.components.metrics.MetricsComponent;
import alisolarflare.components.minigames.MinigameComponent;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		
		new AliLinkComponent().register(this);
		new CreativeBoundariesComponent().register(this);
		new EasyUHCComponent().register(this);
		new FlairDoorComponent().register(this);
		new GPowerComponent().register(this);
		new InsuranceComponent().register(this);
		new MagicComponent().register(this);
		new MetricsComponent().register(this);
		new MinigameComponent().register(this);
		
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
}
