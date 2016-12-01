package alisolarflare.components.flairdoor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.flairdoor.flairme.FlairMe;
import alisolarflare.components.flairdoor.listeners.PortalListener;
import alisolarflare.components.flairdoor.proximitydetector.PlayerProximityLoop;
import alisolarflare.components.flairdoor.proximitydetector.SetProximityLocation;

public class FlairDoorComponent extends Component {
	public List<Player> playersToBeFlaired = new ArrayList<Player>();
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe(this));
		registerCommand(plugin, new SetProximityLocation());
		registerListener(plugin, new PortalListener(plugin, this));
		registerListener(plugin, new PlayerProximityLoop(plugin, this));
	}
}
