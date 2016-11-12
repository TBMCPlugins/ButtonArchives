package alisolarflare.components.easyuhc;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.easyuhc.commands.ActivatePowers;
import alisolarflare.components.easyuhc.commands.SetUHCLobby;
import alisolarflare.components.easyuhc.commands.SetWorldBorders;
import alisolarflare.components.easyuhc.commands.SpreadPlayers;
import alisolarflare.components.easyuhc.commands.StartTimer;
import alisolarflare.components.easyuhc.commands.StartUHC;
import alisolarflare.components.easyuhc.commands.TeleportToUHC;

public class EasyUHCComponent extends Component{
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
