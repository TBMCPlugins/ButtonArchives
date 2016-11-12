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
		if (!(sender instanceof Player))
			sender.sendMessage("You must be a player to use this command! Contact dev/ali if you think this is wrong");
		Player player = (Player) sender;
		gPowerMemory.PowerDownPlayer(player);
		return false;
	}

	@Override
	public String GetCommandPath() {
		return "powerdown";
	}
}
