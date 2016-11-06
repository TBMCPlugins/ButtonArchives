package alisolarflare.easyuhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.easyuhc.commands.ActivatePowers;
import alisolarflare.easyuhc.commands.SetupWorldBorders;
import alisolarflare.easyuhc.commands.SpreadPlayers;
import alisolarflare.easyuhc.commands.StartTimer;
import alisolarflare.easyuhc.commands.StartUHC;
import alisolarflare.easyuhc.commands.TeleportToUHC;

public class EasyUHCModule extends Module{
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new ActivatePowers());
		registerCommand(plugin, new SetupWorldBorders());
		registerCommand(plugin, new SetupWorldBorders());
		registerCommand(plugin, new SpreadPlayers());
		registerCommand(plugin, new StartTimer());
		registerCommand(plugin, new StartUHC());
		registerCommand(plugin, new TeleportToUHC());
	}
}
