package alisolarflare.components.metrics.output;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import alisolarflare.components.metrics.MetricsComponent;
import buttondevteam.lib.TBMCCoreAPI;

public class GetLoginMetrics extends ModCommand{

	private MetricsComponent module;

	public GetLoginMetrics(MetricsComponent metricsModule) {
		this.module = metricsModule;
	}

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length == 1){
			BufferedReader outputStream = null;
			try {
				outputStream = new BufferedReader(new FileReader(args[0]));
				
				List<String> outputList = new ArrayList<String>();
				String currentLine;
				
				while ((currentLine = outputStream.readLine()) != null){
					outputList.add(currentLine);
				}
				outputStream.close();
				for (String metric: outputList){
					player.sendMessage(metric);
				}
			} catch (FileNotFoundException e) {
				TBMCCoreAPI.SendException(args[0] + " could not be found", e);
			} catch (IOException e1) {
				TBMCCoreAPI.SendException(args[0] + "encountered an I/O Exception!", e1);
			}
		}
		for (String metric : module.playerLoginsFile.toArrayList()){
			player.sendMessage(metric);
		}
		return true;
	}
}
