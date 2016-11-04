package alisolarflare.creativeboundaries;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.creativeboundaries.commands.Cbgm0;
import alisolarflare.creativeboundaries.commands.Cbgm1;
import alisolarflare.creativeboundaries.commands.SetDickmode;


public class CreativeBoundariesModule extends Module{
	public boolean dickmode;
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Cbgm1());
		registerCommand(plugin, new Cbgm0());
		registerCommand(plugin, new SetDickmode(this));
		
		
		registerListener(plugin, new PlotChangeListener(this));
	}
	
}
