package alisolarflare.modules.magic.tricks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.modules.ModCommand;
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
			player.sendMessage("Usage: /boomBowRule [rulename] [true/false]");
			player.sendMessage("Rules:");
			player.sendMessage("boomDecay" + boomDecay);
			player.sendMessage("healthReduction" + healthReduction);
			player.sendMessage("endCrystal" + endCrystal);
			player.sendMessage("localized" + localized);
			return false;
		}
		if(!(args[1].startsWith("t")|| args[1].startsWith("f"))){
			player.sendMessage("Usage: /boomBowRule [rulename] [true/false]");
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
			player.sendMessage("Usage: /boomBowRule [rulename] [true/false]");
			player.sendMessage("Rule settings: boomDecay, healthReduction, endCrystal, localized");
			break;
		}
		
		return false;
	}
	@Override
	public String GetCommandPath() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] GetHelpText(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
