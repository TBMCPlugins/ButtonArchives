package alisolarflare.uhc.controller;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.uhc.memory.MatchState;
import alisolarflare.uhc.memory.UHCMatch;
import buttondevteam.lib.chat.TBMCCommandBase;

public class SetMatchState extends TBMCCommandBase{

	UHCMatch match;
	public SetMatchState(UHCMatch match) {
		this.match = match;
	}

	@Override
	public String[] GetHelpText(String alias) {
		return null;
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
