package alisolarflare.components.magic.tricks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
//HEHEHHEHEH EAASSSTER EGGS
public class BoomBowRule extends ModCommand{
	public static boolean boomDecay;
	public static boolean healthReduction;
	public static boolean endCrystal;
	public static boolean localized;;
	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (sender instanceof Player == false){
			sender.sendMessage("You must be a player to use this command");
			return false;
		}
		Player player = (Player) sender;
		if (player.getName().equals("alisolarflare") == false){
			player.sendMessage("You must be alisolarflare to use this command");
			return false;
		}
		if (args.length < 2){
			player.sendMessage("Rules:");
			player.sendMessage("boomDecay" + boomDecay);
			player.sendMessage("healthReduction" + healthReduction);
			player.sendMessage("endCrystal" + endCrystal);
			player.sendMessage("localized" + localized);
			return false;
		}
		if(!(args[1].startsWith("t")|| args[1].startsWith("f"))){
			return false;
		}
		boolean gameRule = false;
		if(args[1].startsWith("t") || args[1].startsWith("T")){
			gameRule = true;
		}
		switch(args[0]){
		case "boomDecay":
			boomDecay = gameRule;
			break;
		case "healthReduction":
			healthReduction = gameRule;
			break;
		case "endCrystal":
			endCrystal = gameRule;
			break;
		case "localized":
			localized = gameRule;
			break;
		default:
			player.sendMessage("Error: "+args[0]+" not defined as a rule");
			return false;
		}
		
		return true;
	}
	@Override
	public String[] GetHelpText(String alias) {
		return new String[]{
				"Usage: /boomBowRule [rulename] [true/false]",
				"Rule settings: boomDecay, healthReduction, endCrystal, localized"
		};
	}
}
