package alisolarflare.components.gpowers.commands;

import org.bukkit.command.CommandSender;

import buttondevteam.lib.chat.TBMCCommandBase;

public class PowerUp extends TBMCCommandBase {

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		// gPowerMemory.PowerUpPlayer(player, colour);
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
