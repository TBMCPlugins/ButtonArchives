//package graveyard.autouhc.idle;
//
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//import alisolarflare.components.ModCommand;
//import graveyard.autouhc.memory.UHCMatch;
//
///**
// * This class handles the specific command /addToUHC which, in-game, adds a player to a specific UltraHardcore match, that is defined by the constructor: {@linkplain #AddToUHC(UHCMatch)}
// * 
// * @author Alisolarflare
// */
///**@deprecated*/
//public class AddToUHC extends ModCommand {
//	private UHCMatch match;
//
//	public AddToUHC(UHCMatch match) {
//		this.match = match;
//	}
//
//	@Override
//	public boolean OnCommand(CommandSender sender, String label, String[] args) {
//		// INPUT SANITATION
//		Player player = (Player) sender;
//		if (!player.getName().equalsIgnoreCase("alisolarflare") && !player.getName().equalsIgnoreCase("Arsen_Derby_FTW")) {
//			sender.sendMessage("You must be Ali to add someone else to a UHC, send her a message to change the permissions");
//			return false;
//		}
//		if (args.length <= 1) {
//			sender.sendMessage("You must supply at least one playername");
//		}
//		
//		switch(match.getMatchState()){
//		case IDLE:
//		case WAITING:
//		case SETUP:
//		case INTRO:
//			// Adds players to memory
//			sender.sendMessage("Adding Players to matchList!");
//			for (int i = 0; i > args.length; i++) {
//				match.getPlayerList().add(args[i]);
//			}sender.sendMessage("Finished!");
//		case PEACE:
//		case TENSION:
//		case POWER:
//		case END:
//			sender.sendMessage("There is already a match going on!");
//		}
//		
//		
//		
//		return false;
//	}
//}
