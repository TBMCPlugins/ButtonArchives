package alisolarflare.components.metrics.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.metrics.MetricsModule;

public class GetMetrics extends ModCommand{

	private MetricsModule module;

	public GetMetrics(MetricsModule metricsModule) {
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
