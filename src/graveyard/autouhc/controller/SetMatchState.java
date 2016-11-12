package graveyard.autouhc.controller;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.ModCommand;
import graveyard.autouhc.memory.MatchState;
import graveyard.autouhc.memory.UHCMatch;
/**@deprecated*/
public class SetMatchState extends ModCommand{

	UHCMatch match;
	public SetMatchState(UHCMatch match) {
		this.match = match;
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		
		if (player.getName().equalsIgnoreCase("alisolarflare") && player.getName().equalsIgnoreCase("Arsen_Derby_FTW")){
			sender.sendMessage("You must be either Ali or Arsen to use this command!");
			return false;
		}
		
		
		if(args.length < 1 ){
			player.sendMessage("Usage: /setMatchState [stateToBeSet]");
			player.sendMessage("States: IDLE, WAITING, SETUP, INTRO, PEACE, POWER, TENSION, END");
			return false;
		}
		
		String inputState = args[0];
		boolean inputIsValidState = false;
		for (MatchState defaultMatchState : MatchState.values()){
			if(inputState.equalsIgnoreCase(defaultMatchState.toString())){
				inputIsValidState = true;
			}
		}
		
		if (inputIsValidState){
			match.setMatchState(MatchState.valueOf(inputState));
			player.sendMessage("Match State set to: " + match.getMatchState().toString() + "!");
		}else{
			player.sendMessage("Error, could not parse state.");
			player.sendMessage("Valid States: IDLE, WAITING, SETUP, INTRO, PEACE, POWER, TENSION, END");
			return false;
		}
		
		
		return false;
	}

	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
