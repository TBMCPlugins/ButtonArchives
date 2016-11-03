package alisolarflare;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import alisolarflare.links.AliLinkSubPlug;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.flairdoor.FlairDoorModule;
import alisolarflare.components.gpowers.GPowerModule;
import alisolarflare.components.links.AliLinkModule;
import alisolarflare.components.shulker.AliShulkerModule;
import alisolarflare.events.uhc.UHCModule;
import alisolarflare.magic.MagicModule;
import alisolarflare.minigames.freeforall.FreeForAllModule;
import alisolarflare.minigames.lobby.LobbyModule;

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
		
		new MagicModule().register(this);
		
		new FreeForAllModule().register(this);
		new LobbyModule().register(this);
	}
}
