package buttondevteam.alipresents.components.insurance;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.ModCommand;
import buttondevteam.alipresents.components.insurance.Insurance.InsuranceType;

public class getInsuranceBlock extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length > 0 && StringUtils.isNumeric(args[0])){
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Block, Integer.parseInt(args[0])));
		}else{
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Block));
		}
		return true;
	}

	@Override
	public String GetCommandPath() {
		return "insurance getblock";
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
				"Usage: /insurance getblock [amount]",
				"This command returns an insurance block, which on death,",
				"splits into 9 insurance ingot which each saves 1 row of",
				"inventory per ingot"
		};
	}
}
