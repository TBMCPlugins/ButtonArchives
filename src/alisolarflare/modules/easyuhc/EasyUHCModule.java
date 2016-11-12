package alisolarflare.modules.easyuhc;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.easyuhc.commands.ActivatePowers;
import alisolarflare.modules.easyuhc.commands.SetUHCLobby;
import alisolarflare.modules.easyuhc.commands.SetWorldBorders;
import alisolarflare.modules.easyuhc.commands.SpreadPlayers;
import alisolarflare.modules.easyuhc.commands.StartTimer;
import alisolarflare.modules.easyuhc.commands.StartUHC;
import alisolarflare.modules.easyuhc.commands.TeleportToUHC;

public class EasyUHCModule extends Module{
	public Location lobbyLocation;
	@Override
	public void register(JavaPlugin plugin) {


		
		registerCommand(plugin, new ActivatePowers());
		registerCommand(plugin, new SetUHCLobby(this));
		registerCommand(plugin, new SetWorldBorders());
		registerCommand(plugin, new SetWorldBorders());
		registerCommand(plugin, new SpreadPlayers());
		registerCommand(plugin, new StartTimer());
		registerCommand(plugin, new StartUHC());
		registerCommand(plugin, new TeleportToUHC());
		
	}
}
