package alisolarflare.components.flaircolouring;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

import alisolarflare.architecture.Component;
import alisolarflare.components.flaircolouring.letterdyes.GetLetterDye;
import alisolarflare.components.flaircolouring.letterdyes.LetterDyeListener;
import alisolarflare.components.flaircolouring.portals.FlairMe;
import alisolarflare.components.flaircolouring.portals.PlayerProximityLoop;
import alisolarflare.components.flaircolouring.portals.PortalListener;
import alisolarflare.components.flaircolouring.portals.SetProximityLocation;

public class FlairColouringComponent extends Component {
	public List<Player> playersToBeFlaired = new ArrayList<Player>();
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe(this));
		registerCommand(plugin, new SetProximityLocation());
		registerCommand(plugin, new GetLetterDye());
		
		registerListener(plugin, new PortalListener(plugin, this));
		registerListener(plugin, new PlayerProximityLoop(plugin, this));
		//registerListener(plugin, new LetterDyeListener((Essentials) Bukkit.getPluginManager().getPlugin("Essentials")));
	}
}
