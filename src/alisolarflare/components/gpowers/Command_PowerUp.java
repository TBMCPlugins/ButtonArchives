package alisolarflare.components.gpowers;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import buttondevteam.lib.chat.TBMCCommandBase;

public class Command_PowerUp extends TBMCCommandBase {

	private Memory_GPower gPowerMemory;

	public Command_PowerUp(Memory_GPower gPowerMemory) {
		this.gPowerMemory = gPowerMemory;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (!(sender instanceof Player))
			sender.sendMessage("You must be a player to use this command! Contact a dev/ali if you think this is wrong");
		
		Player player = (Player) sender;
		gPowerMemory.PowerUpPlayer(player);
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetCommandPath() {
		return "powerup";
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

}
