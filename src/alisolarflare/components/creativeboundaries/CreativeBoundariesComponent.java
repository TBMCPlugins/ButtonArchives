package alisolarflare.components.creativeboundaries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.creativeboundaries.commands.Cbgm0;
import alisolarflare.components.creativeboundaries.commands.Cbgm1;
import alisolarflare.components.creativeboundaries.commands.SetDickmode;
import alisolarflare.components.creativeboundaries.listeners.PlotChangeListener;


public class CreativeBoundariesComponent extends Component{
	public boolean dickmode;
	public List<Player> cbCreatives = new ArrayList<Player>();
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Cbgm1(this));
		registerCommand(plugin, new Cbgm0(this));
		registerCommand(plugin, new SetDickmode(this));
		
		registerListener(plugin, new PlotChangeListener(this));
		//registerListener(plugin, new ItemRestrictionListener(this));
	}
	
}
