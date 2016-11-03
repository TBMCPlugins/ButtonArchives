package alisolarflare.modules.magic;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.events.uhc.commands.AddToUHC;
import alisolarflare.modules.magic.aliarrow.AliArrowListener;
import alisolarflare.modules.magic.boombow.BoomBowListener;
import buttondevteam.lib.TBMCCoreAPI;
import buttondevteam.lib.chat.TBMCChatAPI;

public class MagicModule extends Module{

	@Override
	public void register(JavaPlugin plugin) {
		TBMCCoreAPI.RegisterEventsForExceptions(new AliArrowListener(plugin), plugin);
		TBMCCoreAPI.RegisterEventsForExceptions(new BoomBowListener(), plugin);
		TBMCChatAPI.AddCommands(plugin, AddToUHC.class);
		
	}

}
