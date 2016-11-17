package alisolarflare.components.metrics.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.metrics.MetricsComponent;

public class GetMetrics extends ModCommand{

	private MetricsComponent module;

	public GetMetrics(MetricsComponent metricsModule) {
		this.module = metricsModule;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		Player player = (Player) sender;
		for (String metric : module.metricsList){
			SendDebugPotato(player, module.metricsList);
			SendDebugPotato(player, metric);
		}
		return true;
	}

}
