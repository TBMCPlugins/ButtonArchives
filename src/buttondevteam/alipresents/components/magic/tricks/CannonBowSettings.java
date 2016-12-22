package buttondevteam.alipresents.components.magic.tricks;

import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;

public class CannonBowSettings extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length > 1){
			switch(args[0].toLowerCase()){
			case "speedmultiplier":
				CannonBowListener.setSpeedMultiplier(NumberUtils.toDouble(args[1], CannonBowListener.getSpeedMultiplier()));
				break;
			case "minforce":
				CannonBowListener.setMinforce(NumberUtils.toDouble(args[1], CannonBowListener.getMinforce()));
				break;
			case "fuseticks":
				CannonBowListener.setFuseticks(NumberUtils.toInt(args[1], CannonBowListener.getFuseticks()));
				break;
			case "recoil":
				CannonBowListener.setRecoil(NumberUtils.toDouble((args[1]), CannonBowListener.getRecoil()));
				break;
			case "display":
				player.sendMessage("Speed Multiplier: "+CannonBowListener.getSpeedMultiplier());
				player.sendMessage("Minimum Force: "+CannonBowListener.getMinforce());
				player.sendMessage("Fuseticks: " + CannonBowListener.getFuseticks());
				player.sendMessage("Recoil: " + CannonBowListener.getRecoil());
				break;
			default:
				player.sendMessage("That isn't a valid setting!");
				player.sendMessage("Valid Settings are: speedmultiplier, minforce, fuseticks, recoil");
				player.sendMessage("Use argument 'display' to disply current settings");
				return false;
			}
		}
		return true;
	}

	@Override
	public String GetCommandPath(){
		return "magic cannonbow settings";
	}

}
