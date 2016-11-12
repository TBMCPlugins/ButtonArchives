package alisolarflare.modules.gpowers.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.modules.ModCommand;
import alisolarflare.modules.gpowers.GPowerMemory;
import alisolarflare.modules.gpowers.GPowerMemory.poweredPlayer;

public class PowerAll extends ModCommand{
	private GPowerMemory gPowerMemory;

	public PowerAll(GPowerMemory gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}
	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		for (poweredPlayer poweredPlayer : gPowerMemory.poweredPlayerList.values()){
			poweredPlayer.isPowersActive = true;
		}
		return false;
	}
}
