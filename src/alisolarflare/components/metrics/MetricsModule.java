package alisolarflare.components.metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.metrics.commands.GetMetrics;
import alisolarflare.components.metrics.listeners.PlayerJoinListener;

public class MetricsModule extends Component{

	public FileConfiguration metricsYml; // DATA - STRING
	public List<String> metricsList;

	@Override
	public void register(JavaPlugin plugin){
		try {
			metricsYml = loadFileConfiguration(plugin, "metrics.yml");
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
			return;
		}
		
		metricsList = metricsYml.getStringList("playerLogins");
		registerCommand(plugin, new GetMetrics(this));
		registerListener(plugin, new PlayerJoinListener(this));
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
