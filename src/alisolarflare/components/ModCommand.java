package alisolarflare.components;

import org.bukkit.command.CommandSender;

import buttondevteam.lib.chat.TBMCCommandBase;

public abstract class ModCommand extends TBMCCommandBase{

	@Override
	public abstract boolean OnCommand(CommandSender sender, String alias, String[] args);

	@Override
	public String[] GetHelpText(String alias){
		return new String[] {"This command doesn't have help text, ask a dev to add one, using public String[] GetHelpText. "
				+ "If you're a dev, write the help text you lazy bastard. -Ali"};
	}

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
