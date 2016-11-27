package alisolarflare.components.metrics;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.architecture.Component;
import alisolarflare.components.metrics.collection.PlayerJoinListener;
import alisolarflare.components.metrics.files.MetricsFile;
import alisolarflare.components.metrics.output.GetLoginMetrics;

public class MetricsComponent extends Component{
	String defaultPath = "/AliPresents/metrics";
	String defaultFilePath = (defaultPath + "/metrics.txt");
	String playerLoginsFilePath  = (defaultPath + "/playerLogins.txt");
	
	public MetricsFile playerLoginsFile; // DATA - STRING
	public List<String> metricsList;

	@Override
	public void register(JavaPlugin plugin){
		playerLoginsFile = new MetricsFile(playerLoginsFilePath);
		registerCommand(plugin, new GetLoginMetrics(this));
		registerListener(plugin, new PlayerJoinListener(this, playerLoginsFile));
		
		metricsList = new ArrayList<String>();
	}
}
