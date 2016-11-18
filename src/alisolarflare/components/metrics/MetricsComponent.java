package alisolarflare.components.metrics;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;
import alisolarflare.components.metrics.commands.GetLoginMetrics;
import alisolarflare.components.metrics.listeners.PlayerJoinListener;

public class MetricsComponent extends Component{

	public FileConfiguration metricsYml; // DATA - STRING
	public List<String> metricsList;

	@Override
	public void register(JavaPlugin plugin){
		registerCommand(plugin, new GetLoginMetrics(this));
		registerListener(plugin, new PlayerJoinListener(this));
		
		metricsList = new ArrayList<String>();
		/*
		try {
			metricsYml = loadFileConfiguration(plugin, "metrics.yml");
			metricsList = metricsYml.getStringList("playerLogins");
		} catch (IOException | InvalidConfigurationException e) {
			TBMCCoreAPI.SendException("metrics.yml in AliPresents could not be created!", e);
			return;
		}*/
		
	}
	/*
	private FileConfiguration loadFileConfiguration(JavaPlugin plugin, String fileName) throws FileNotFoundException, IOException, InvalidConfigurationException {

		File file = new File(plugin.getDataFolder(), fileName);

		if (!file.exists()) {
			file.getParentFile().mkdirs();
			plugin.saveResource(fileName, false);
		}
		
		FileConfiguration config = new YamlConfiguration();
		
		config.load(file);
		
		return config;
	}*/
}
