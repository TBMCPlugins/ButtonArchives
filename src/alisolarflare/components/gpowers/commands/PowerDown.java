package alisolarflare.components.gpowers.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.PlayerCommand;
import alisolarflare.components.gpowers.GPowerMemory;

public class PowerDown extends PlayerCommand {

	private GPowerMemory gPowerMemory;

	public PowerDown(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		Player player = (Player) sender;
		gPowerMemory.PowerDownPlayer(player);
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: Type /PowerDown to disable your g-power"
		};
	}
}
