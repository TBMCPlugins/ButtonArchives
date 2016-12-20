package buttondevteam.alipresents.components.magic.tricks;

import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;

public class CannonBowSettings extends ModCommand {
	
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		switch(args[0].toLowerCase()){
		case "speedmultiplier":
			CannonBowListener.SpeedMultiplier = NumberUtils.toDouble(args[1], CannonBowListener.SpeedMultiplier);
			break;
		case "minforce":
			CannonBowListener.minforce = NumberUtils.toDouble(args[1], CannonBowListener.SpeedMultiplier);
			break;
		default:
			player.sendMessage("That isn't a valid setting!");
			player.sendMessage("Valid Settings are: ");
			return false;
		}
		return true;
	}
	
	@Override
	public String GetCommandPath(){
		return "magic cannonbow";
	}
	
}
