package alisolarflare.creativeboundaries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.creativeboundaries.commands.Cbgm0;
import alisolarflare.creativeboundaries.commands.Cbgm1;
import alisolarflare.creativeboundaries.commands.SetDickmode;
import alisolarflare.creativeboundaries.listeners.ItemRestrictionListener;
import alisolarflare.creativeboundaries.listeners.PlotChangeListener;


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
