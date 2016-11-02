package alisolarflare.modules.events.uhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.events.uhc.memory.MatchState;
import alisolarflare.modules.events.uhc.memory.UHCMatch;

public class StartMatch implements CommandExecutor {
	private UHCMatch match;
	public StartMatch(UHCMatch match){
		this.match = match;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command! Contact a dev if you think this is wrong");
		}
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
}
