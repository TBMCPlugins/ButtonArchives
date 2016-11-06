package alisolarflare.easyuhc;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;

public class Module_EasyUHC extends Module{
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new Command_ActivatePowers());
		registerCommand(plugin, new Command_SetupWorldBorders());
		registerCommand(plugin, new Command_SetupWorldBorders());
		registerCommand(plugin, new Command_SpreadPlayers());
		registerCommand(plugin, new Command_StartTimer());
		registerCommand(plugin, new Command_StartUHC());
		registerCommand(plugin, new Command_TeleportToUHC());
	}
}
