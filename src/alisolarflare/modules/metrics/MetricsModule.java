package alisolarflare.modules.metrics;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.modules.Module;

public class MetricsModule extends Module{
	
	public FileConfiguration config;

	@Override
	public void register(JavaPlugin plugin) {
		this.config = plugin.getConfig();
	}
}
