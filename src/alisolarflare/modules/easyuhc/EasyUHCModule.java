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
import alisolarflare.modules.easyuhc.gpowers.GPowerMemory;
import alisolarflare.modules.easyuhc.gpowers.commands.GPower;
import alisolarflare.modules.easyuhc.gpowers.commands.PowerDown;
import alisolarflare.modules.easyuhc.gpowers.commands.PowerUp;
import alisolarflare.modules.easyuhc.gpowers.listeners.gPowerListener;

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
