package buttondevteam.alipresents.components.insurance;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.insurance.Insurance.InsuranceType;

public class getInsurance extends ModCommand {
	private final int defaultAmount = 1;
	private final InsuranceType defaultInsuranceType  = InsuranceType.Block;
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		int amount = defaultAmount;
		InsuranceType insuranceType = defaultInsuranceType;
		
		switch(args.length){
		case 0: // no arguments
			break;
		case 1: // <amount> or <type> argument
			if (StringUtils.isNumeric(args[0])){
				amount = Integer.parseInt(args[0]);
				break;
			}else if (Insurance.isInsuranceType(args[0])){
				insuranceType = InsuranceType.valueOf(args[0]);
				break;
			}else{
				player.sendMessage("Invalid Argument " + args[0]);
				player.sendMessage("Enter a type of insurance or a number as an argument");
				player.sendMessage(Insurance.InsuranceType.values().toString());
				return false;
			}
		default: 
			// <amount> <type> argument
			if (StringUtils.isNumeric(args[0]) && Insurance.isInsuranceType(args[1])){
				amount = Integer.parseInt(args[0]);
				insuranceType = InsuranceType.valueOf(args[0]);
				break;
			}else{
				player.sendMessage("Invalid Argument " + args[0] + "|" + args[1]);
				player.sendMessage("Usage /" + this.GetCommandPath() 
					+ " <amount>"
					+ " <" + Insurance.InsuranceType.values().toString() + ">");
				return false;
			}
		}

		player.getInventory().addItem(Insurance.getInsurance(insuranceType, amount));
		return true;
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

	@Override
	public String GetCommandPath() {
		return "insurance get";
	}

}
