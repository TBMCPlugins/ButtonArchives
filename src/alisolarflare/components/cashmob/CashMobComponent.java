package alisolarflare.components.cashmob;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

import alisolarflare.architecture.Component;

public class CashMobComponent extends Component{

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new MobKillListener((Essentials) Bukkit.getPluginManager().getPlugin("Essentials")));
		
	}

}
