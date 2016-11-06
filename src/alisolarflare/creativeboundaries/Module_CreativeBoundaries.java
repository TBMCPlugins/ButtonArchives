package alisolarflare.creativeboundaries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;


public class Module_CreativeBoundaries extends Module{
	public boolean dickmode;
	public List<Player> cbCreatives = new ArrayList<Player>();
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Command_Cbgm1(this));
		registerCommand(plugin, new Command_Cbgm0(this));
		registerCommand(plugin, new Command_SetDickmode(this));
		
		registerListener(plugin, new Listener_PlotChange(this));
		//registerListener(plugin, new ItemRestrictionListener(this));
	}
	
}
