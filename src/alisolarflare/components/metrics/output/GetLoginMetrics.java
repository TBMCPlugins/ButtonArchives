package alisolarflare.components.metrics.output;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import alisolarflare.components.metrics.MetricsComponent;

public class GetLoginMetrics extends ModCommand{

	private MetricsComponent module;

	public GetLoginMetrics(MetricsComponent metricsModule) {
		this.module = metricsModule;
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		for (String metric : module.playerLoginsFile.toArrayList()){
			player.sendMessage(metric);
		}
		return true;
	}
}
