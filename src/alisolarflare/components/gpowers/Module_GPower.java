package alisolarflare.components.gpowers;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;

public class Module_GPower extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		Memory_GPower gPowerMemory = new Memory_GPower();
		registerCommand(plugin, new Command_GPower(gPowerMemory));
		registerCommand(plugin, new Command_PowerUp(gPowerMemory));
		registerCommand(plugin, new Command_PowerDown(gPowerMemory));

		registerListener(plugin, new Listener_PowerLooper(plugin, gPowerMemory));
	}

}
