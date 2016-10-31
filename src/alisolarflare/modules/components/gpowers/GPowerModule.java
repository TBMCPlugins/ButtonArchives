package alisolarflare.modules.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.components.gpowers.commands.PowerDown;
import alisolarflare.modules.components.gpowers.commands.PowerUp;
import alisolarflare.modules.components.gpowers.commands.gPowerCommand;
import alisolarflare.modules.components.gpowers.listeners.gPowerListener;

public class GPowerModule extends Module{

	@Override
	public void register(JavaPlugin plugin) {
		plugin.getCommand("powerup").setExecutor(new PowerUp());
		plugin.getCommand("powerdown").setExecutor(new PowerDown());
		plugin.getCommand("gpowercommand").setExecutor(new gPowerCommand());
		
		plugin.getServer().getPluginManager().registerEvents(new gPowerListener(plugin), plugin);
	}

}
