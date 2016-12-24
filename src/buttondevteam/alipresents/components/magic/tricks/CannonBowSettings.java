package buttondevteam.alipresents.components.magic.tricks;

import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;

public class CannonBowSettings extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length > 1 && args[0] == "display"){
			switch(args[0].toLowerCase()){
			case "force":
			case "speedmultiplier":
				CannonBowListener.setSpeedMultiplier(NumberUtils.toDouble(args[1], CannonBowListener.getSpeedMultiplier()));
				break;
			case "minimumforce":
			case "minforce":
			case "minimumdraw":
			case "mindraw":
				CannonBowListener.setMinforce(NumberUtils.toDouble(args[1], CannonBowListener.getMinforce()));
				break;
			case "fuse":
			case "fusetick":
			case "fuseticks":
				CannonBowListener.setFuseticks(NumberUtils.toInt(args[1], CannonBowListener.getFuseticks()));
				break;
			case "recoil":
				CannonBowListener.setRecoil(NumberUtils.toDouble((args[1]), CannonBowListener.getRecoil()));
				break;
			case "isDestructive":
				CannonBowListener.setIsDestructive(args[1]);
			case "display":
				player.sendMessage("Speed Multiplier: "+CannonBowListener.getSpeedMultiplier());
				player.sendMessage("Minimum Force: "+CannonBowListener.getMinforce());
				player.sendMessage("Fuseticks: " + CannonBowListener.getFuseticks());
				player.sendMessage("Recoil: " + CannonBowListener.getRecoil());
				player.sendMessage("isDestructive: " + CannonBowListener.getIsDestructive());
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
