package alisolarflare.autouhc.idle;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.autouhc.memory.UHCMatch;
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
