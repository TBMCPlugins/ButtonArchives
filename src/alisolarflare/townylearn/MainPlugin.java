package alisolarflare.townylearn;

import org.bukkit.plugin.java.JavaPlugin;
import alisolarflare.townylearn.commands.Cbgm0;
import alisolarflare.townylearn.commands.Cbgm1;
import alisolarflare.townylearn.commands.SetDickmode;


public class MainPlugin extends JavaPlugin{
	public boolean dickmode;
	public void onEnable(){
		registerCommands();
		registerEvents();
	}
	public void registerCommands(){
		getCommand("cbgm1").setExecutor(new Cbgm1());
		getCommand("cbgm0").setExecutor(new Cbgm0());
		getCommand("setdickmode").setExecutor(new SetDickmode(this));
	}
	public void registerEvents(){
		PlotChangeListener plotChangeListener = new PlotChangeListener(this);
		
		getServer().getPluginManager().registerEvents(plotChangeListener, this);
	}
	public void setDickmode(boolean YES){
		dickmode = YES;
		this.getConfig().set("dickmode", YES);
	}
	public boolean getDickmode(){
		boolean dickmode = this.getConfig().getBoolean("dickmode");
		this.dickmode = dickmode;
		return dickmode;
	}
}
