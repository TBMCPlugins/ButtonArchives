package alisolarflare.easyuhc.gpowers.commands;

import org.bukkit.command.CommandSender;

import alisolarflare.DevCommand;
import alisolarflare.easyuhc.gpowers.GPowerMemory;
import alisolarflare.easyuhc.gpowers.GPowerMemory.poweredPlayer;

public class PowerAll extends DevCommand{
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

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
}
