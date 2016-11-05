package alisolarflare.uhc.idle;

import org.bukkit.command.CommandSender;

import alisolarflare.uhc.memory.UHCMatch;
import buttondevteam.lib.chat.TBMCCommandBase;

public class JoinUHC extends TBMCCommandBase{

	private UHCMatch match;

	public JoinUHC(UHCMatch match) {
		this.match = match;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		return false;
	}

	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
