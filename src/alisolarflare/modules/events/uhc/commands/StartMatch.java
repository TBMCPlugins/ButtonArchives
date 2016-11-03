package alisolarflare.modules.events.uhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.events.uhc.memory.MatchState;
import alisolarflare.modules.events.uhc.memory.UHCMatch;
import buttondevteam.lib.chat.TBMCCommandBase;

public class StartMatch extends TBMCCommandBase {
	private UHCMatch match;

	public StartMatch(UHCMatch match) {
		this.match = match;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (match.getMatchState() == MatchState.NULL)
			sender.sendMessage("There is no match to begin.");
		else if (match.getMatchState() == MatchState.IDLE)
			sender.sendMessage("There is currently a match ready... Activating...");
		else if (match.getMatchState() == MatchState.WAITING)
			sender.sendMessage("There currently a match planned for: TIME:TIME:TIME");
		else if (match.getMatchState() == MatchState.END)
			sender.sendMessage("The match has ended! Would you like to restart?");
		else
			sender.sendMessage("You cannot start a match now, one is already in progress!");

		return false;

	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetCommandPath() {
		return "startmatch";
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
