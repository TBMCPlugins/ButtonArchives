package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.alilinks.AliLinkComponent;
import alisolarflare.components.bankchest.BankChestComponent;
import alisolarflare.components.cashmob.CashMobComponent;
import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;
import alisolarflare.components.flaircolouring.FlairColouringComponent;
import alisolarflare.components.gpowers.GPowerComponent;
import alisolarflare.components.insurance.InsuranceComponent;
import alisolarflare.components.magic.MagicComponent;
import alisolarflare.components.spawn.SpawnComponent;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		
		new AliLinkComponent().register(this);
		new BankChestComponent().register(this);
		new CashMobComponent().register(this);
		new CreativeBoundariesComponent().register(this);
		new FlairColouringComponent().register(this);
		new GPowerComponent().register(this);
		new InsuranceComponent().register(this);
		new MagicComponent().register(this);
		//new MetricsComponent().register(this);
		new SpawnComponent().register(this);
		
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
}
