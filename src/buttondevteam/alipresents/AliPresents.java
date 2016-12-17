package buttondevteam.alipresents;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.components.alilinks.AliLinkComponent;
import buttondevteam.alipresents.components.cashmob.CashMobComponent;
import buttondevteam.alipresents.components.creativeboundaries.CreativeBoundariesComponent;
import buttondevteam.alipresents.components.flaircolouring.FlairColouringComponent;
import buttondevteam.alipresents.components.fruit.FruitComponent;
import buttondevteam.alipresents.components.gpower.GPowerComponent;
import buttondevteam.alipresents.components.insurance.InsuranceComponent;
import buttondevteam.alipresents.components.magic.MagicComponent;
import buttondevteam.alipresents.components.spawn.SpawnComponent;

public class AliPresents extends JavaPlugin{
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " has been started (V." + pdfFile.getVersion()+ ").");
		
		
		new AliLinkComponent().register(this);
		new CashMobComponent().register(this);
		new CreativeBoundariesComponent().register(this);
		new FlairColouringComponent().register(this);
		new FruitComponent().register(this);
		new GPowerComponent().register(this);
		new InsuranceComponent().register(this);
		new MagicComponent().register(this);
		//new MetricsComponent().register(this);
		new SpawnComponent().register(this);
		
		
		logger.info(pdfFile.getName() + " has fully registered (V." + pdfFile.getVersion()+ ").");
		
		
	}
}
