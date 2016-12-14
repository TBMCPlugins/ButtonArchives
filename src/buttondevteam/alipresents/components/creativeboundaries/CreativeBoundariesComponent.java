package buttondevteam.alipresents.components.creativeboundaries;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.creativeboundaries.commands.Cbgm0;
import buttondevteam.alipresents.components.creativeboundaries.commands.Cbgm1;
import buttondevteam.alipresents.components.creativeboundaries.commands.SetForceBoundaries;
import buttondevteam.alipresents.components.creativeboundaries.listeners.PlotChangeListener;


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
