package alisolarflare.components.flairdoor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.flairdoor.flairme.FlairMe;
import alisolarflare.components.flairdoor.listeners.PortalListener;
import alisolarflare.components.flairdoor.playerproximity.PlayerProximityTaskLauncher;
import alisolarflare.components.flairdoor.playerproximity.SetProximityLocation;

public class FlairDoorComponent extends Component {
	public List<Player> playersToBeFlaired = new ArrayList<Player>();
	public Location startLocation = null;
	public Location endLocation = null;
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe(this));
		registerCommand(plugin, new SetProximityLocation(this));
		registerListener(plugin, new PortalListener(plugin, this));
		registerListener(plugin, new PlayerProximityTaskLauncher(plugin, this));
	}
}
