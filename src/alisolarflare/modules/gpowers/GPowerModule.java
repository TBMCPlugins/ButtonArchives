package alisolarflare.modules.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;
import alisolarflare.modules.gpowers.commands.GPower;
import alisolarflare.modules.gpowers.commands.PowerDown;
import alisolarflare.modules.gpowers.commands.PowerUp;
import alisolarflare.modules.gpowers.listeners.gPowerListener;

public class GPowerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		GPowerMemory gPowerMemory = new GPowerMemory();
		registerCommand(plugin, new GPower(gPowerMemory));
		registerCommand(plugin, new PowerUp(gPowerMemory));
		registerCommand(plugin, new PowerDown(gPowerMemory));

		registerListener(plugin, new gPowerListener(plugin, gPowerMemory));

	}

}
