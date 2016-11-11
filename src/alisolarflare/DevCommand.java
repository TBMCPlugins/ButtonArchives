package alisolarflare;

import org.bukkit.command.CommandSender;

import buttondevteam.lib.chat.TBMCCommandBase;

public abstract class DevCommand extends TBMCCommandBase{

	@Override
	public abstract boolean OnCommand(CommandSender sender, String alias, String[] args);

	@Override
	public abstract String[] GetHelpText(String alias);

	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return true;
	}
}
