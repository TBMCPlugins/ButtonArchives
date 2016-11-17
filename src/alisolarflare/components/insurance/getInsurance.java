package alisolarflare.components.insurance;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alisolarflare.components.ModCommand;
import alisolarflare.components.insurance.Insurance.InsuranceType;

public class getInsurance extends ModCommand {

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		Player player = (Player) sender;
		if (args.length == 0){
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Block));
			return true;
		}else if(args.length == 1){
			if (StringUtils.isNumeric(args[0])){
				int amount = Integer.parseInt(args[0]);
				player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Block, amount));
				return true;
			}else{
				if (Insurance.isInsuranceType(args[0])){
					player.getInventory().addItem((Insurance.getInsurance(InsuranceType.valueOf(args[0]))));
					return true;
				}else{
					return false;
				}
			}
		}else if (args.length >=2){
			if (StringUtils.isNumeric(args[0]) && Insurance.isInsuranceType(args[1])){
				player.getInventory().addItem((Insurance.getInsurance(InsuranceType.valueOf(args[1]), Integer.parseInt(args[0]))));
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: /getInsurance [amount] [type:nugget/bar/block/compound]",
				"Use this command to get gold-standard inventory insurance, that saves ",
				"items in an inventory upon death. One nugget saves one ItemStack, a bar",
				"saves nine, a block saves 54. Compound converts amount (in nuggets) to a",
				"mix of both nuggets, bars and blocks"
		};
	}

}
