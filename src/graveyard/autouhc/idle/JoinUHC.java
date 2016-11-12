package graveyard.autouhc.idle;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.ModCommand;
import graveyard.autouhc.memory.UHCMatch;
/**@deprecated*/
public class JoinUHC extends ModCommand{

	private UHCMatch match;

	public JoinUHC(UHCMatch match) {
		this.match = match;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player player = (Player) sender;
		player.sendMessage("Adding you to the UltraHardcore match!");
		switch(match.getMatchState()){
		
		//Before the game
		case IDLE:
		case WAITING:
		case SETUP:
		case INTRO:
			player.sendMessage("Adding you to the UltraHardcore match!");
			match.getPlayerList().add(player.getName());
			break;
			
		//During the game
		case PEACE:
		case TENSION:
		case POWER:
			player.sendMessage("There is currently an UltraHardcore match going on! #POINTTOSPECTATORMODE, tell Ali asap if you see this");
		
		//After the game
		case END:
			player.sendMessage("There is currently an ending ceremony going on! #POINTTOCEREMONY, tell Ali ASAP if you see this");
			
		}
		
		return false;
	}	
}
