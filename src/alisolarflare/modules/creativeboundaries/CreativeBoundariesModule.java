package alisolarflare.modules.creativeboundaries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.creativeboundaries.commands.Cbgm0;
import alisolarflare.modules.creativeboundaries.commands.Cbgm1;
import alisolarflare.modules.creativeboundaries.commands.SetDickmode;
import alisolarflare.modules.creativeboundaries.listeners.ItemRestrictionListener;
import alisolarflare.modules.creativeboundaries.listeners.PlotChangeListener;


public class CreativeBoundariesModule extends Module{
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
