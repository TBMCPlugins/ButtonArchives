package buttondevteam.alipresents.components.insurance;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.insurance.Insurance.InsuranceType;

public class getInsuranceIngot extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length > 0 && StringUtils.isNumeric(args[0])){
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Ingot, Integer.parseInt(args[0])));
		}else{
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Ingot));
		}
		return true;
	}

	@Override
	public String GetCommandPath() {
		return "insurance getingot";
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: /insurance getingot [amount]",
				"This command returns an insurance ingot, which on death,",
				"saves one row of inventory"
		};
	}
}
