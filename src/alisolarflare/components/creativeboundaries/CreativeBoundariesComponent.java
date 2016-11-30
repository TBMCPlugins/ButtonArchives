package alisolarflare.components.creativeboundaries;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.creativeboundaries.commands.Cbgm0;
import alisolarflare.components.creativeboundaries.commands.Cbgm1;
import alisolarflare.components.creativeboundaries.commands.SetForceBoundaries;
import alisolarflare.components.creativeboundaries.listeners.PlotChangeListener;


public class CreativeBoundariesComponent extends Component{
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Cbgm1());
		registerCommand(plugin, new Cbgm0());
		registerCommand(plugin, new SetForceBoundaries());
		registerListener(plugin, new PlotChangeListener());
		//registerListener(plugin, new ItemRestrictionListener(this));
	}
	
}
