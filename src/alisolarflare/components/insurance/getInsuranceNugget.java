package alisolarflare.components.insurance;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;

import alisolarflare.architecture.commands.ModCommand;
import alisolarflare.components.insurance.Insurance.InsuranceType;

public class getInsuranceNugget extends ModCommand {

	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		if (args.length > 0 && StringUtils.isNumeric(args[0])){
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Nugget, Integer.parseInt(args[0])));
		}else{
			player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Nugget));
		}
		return false;
	}

}
