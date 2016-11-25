package alisolarflare.components.metrics.commands;

import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.metrics.MetricsComponent;

public class GetLoginMetrics extends ModCommand{

	private MetricsComponent module;

	public GetLoginMetrics(MetricsComponent metricsModule) {
		this.module = metricsModule;
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		for (String metric : module.metricsList){
			player.sendMessage(metric);
		}
		if (args.length < 1){
			return true;
		}
		return true;
	}
}
