package buttondevteam.alipresents.components.gpower;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.gpower.api.GPowerAPI;

public class ApplyPowerUp extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length > 1) //No one's online
			return false;
		
		String playerArgument = args[0];

		Player argPlayer = player.getServer().getPlayer(playerArgument);
		
		if (argPlayer == null)
		{ 
			
			// Attempted player is not online
			player.sendMessage(playerArgument + " is not online right now. Players online are: ");
			player.sendMessage(player.getServer().getOnlinePlayers().toString());
			
			if (args.length < 2){
				player.sendMessage("You may apply the effect " + args[1] + "to them");
			}
			
		}
		if (args.length < 2){
			//recolour no colour
			GPowerAPI.PowerUpPlayer(player);
			return true;
		}else{
			GPowerAPI.PowerUpPlayer(player);
			//recolour with colour
			return true;
		}
		
		
	}
	@Override
	public String[] GetHelpText(String string){
		return new String[]{
			"Usage: /"+GetCommandPath()+"<player> <colour>",
			"Use this command to apply a gpower colour to players",
		};
	}
	@Override
	public String GetCommandPath(){
		return "gpower applypowerup";
	}

}
