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
import alisolarflare.easyuhc.gpowers.GPowerMemory;
import alisolarflare.easyuhc.gpowers.commands.GPower;
import alisolarflare.easyuhc.gpowers.commands.PowerDown;
import alisolarflare.easyuhc.gpowers.commands.PowerUp;
import alisolarflare.easyuhc.gpowers.listeners.gPowerListener;

public class EasyUHCModule extends Module{
	public Location lobbyLocation;
	@Override
	public void register(JavaPlugin plugin) {


		GPowerMemory gPowerMemory = new GPowerMemory();
		registerCommand(plugin, new GPower(gPowerMemory));
		registerCommand(plugin, new PowerUp(gPowerMemory));
		registerCommand(plugin, new PowerDown(gPowerMemory));

		registerListener(plugin, new gPowerListener(plugin, gPowerMemory));
		
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
