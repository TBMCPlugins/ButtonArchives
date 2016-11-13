package alisolarflare.components.metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;

public class MetricsModule extends Component{

	public FileConfiguration metricsYml;

	@Override
	public void register(JavaPlugin plugin){
		
		try {
			loadFileConfiguration(plugin, "config.yml");
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		
	}
	
	private FileConfiguration loadFileConfiguration(JavaPlugin plugin, String fileName) throws FileNotFoundException, IOException, InvalidConfigurationException {

		File file = new File(plugin.getDataFolder(), fileName);

		if (!file.exists()) {
			file.getParentFile().mkdirs();
			plugin.saveResource(fileName, false);
		}
		
		FileConfiguration config = new YamlConfiguration();
		
		config.load(file);
		
		return config;
	}
}
