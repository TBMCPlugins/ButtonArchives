package graveyard.autouhc.intro;

import org.bukkit.command.CommandSender;

import alisolarflare.modules.ModCommand;
import graveyard.autouhc.memory.MatchState;
import graveyard.autouhc.memory.UHCMatch;

public class StartMatch extends ModCommand {
	private UHCMatch match;

	public StartMatch(UHCMatch match) {
		this.match = match;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		
		if (!sender.hasPermission("moderator") && !(sender.getName() == ""))
			sender.sendMessage("You must be a moderator or Arsenalis to use this command! "
					+ "Contact a TBMC dev if you think this is wrong");
		
		//ACTIVATES MATCH	
		switch(match.getMatchState()){			
		case IDLE:
			sender.sendMessage("There is currently a match ready... Activating...");
			match.setMatchState(MatchState.INTRO);
			break;
			
		case WAITING:
			sender.sendMessage("There currently a match planned for: TIME:TIME:TIME");
			break;
			
		case END:
			sender.sendMessage("The match has ended! Would you like to restart using current settings?");
			break;
			
		default:
			sender.sendMessage("You cannot start a match now, one is already in progress!");
		}	
		
		return false;
		

	}

	@Override
	public String GetCommandPath() {
		return "startmatch";
	}
}
