package alisolarflare.components.metrics.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.components.ModCommand;
import alisolarflare.components.metrics.MetricsModule;

public class GetMetrics extends ModCommand{

	private MetricsModule module;

	public GetMetrics(MetricsModule metricsModule) {
		this.module = metricsModule;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		for (String metric : module.metricsList){
			sender.sendMessage(metric);
		}
		return true;
	}

}
