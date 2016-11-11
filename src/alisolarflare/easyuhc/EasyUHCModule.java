package alisolarflare.easyuhc;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.easyuhc.commands.ActivatePowers;
import alisolarflare.easyuhc.commands.SetUHCLobby;
import alisolarflare.easyuhc.commands.SetWorldBorders;
import alisolarflare.easyuhc.commands.SpreadPlayers;
import alisolarflare.easyuhc.commands.StartTimer;
import alisolarflare.easyuhc.commands.StartUHC;
import alisolarflare.easyuhc.commands.TeleportToUHC;

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
