package buttondevteam.alipresents.components.metrics;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.metrics.collection.PlayerJoinListener;
import buttondevteam.alipresents.components.metrics.files.MetricsFile;
import buttondevteam.alipresents.components.metrics.output.GetLoginMetrics;

public class MetricsComponent extends Component{
	String defaultPath;
	String defaultFilePath;
	String playerLoginsFilePath;
	
	public MetricsFile playerLoginsFile; // DATA - STRING
	public List<String> metricsList;

	@Override
	public void register(JavaPlugin plugin){
		
		defaultPath = plugin.getDataFolder().getAbsolutePath();
		defaultFilePath = defaultPath + "/metrics.txt";
		playerLoginsFilePath = defaultPath + "/playerLogins.txt";
		
		playerLoginsFile = new MetricsFile(playerLoginsFilePath);
		registerCommand(plugin, new GetLoginMetrics(this));
		registerListener(plugin, new PlayerJoinListener(this, playerLoginsFile));
		
		metricsList = new ArrayList<String>();
	}
}
